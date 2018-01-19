package com.insightly.etl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.insightly.etl.util.InsightlyApiException;
import com.insightly.model.CustomField;
import com.insightly.model.Lead;

@Primary
@Service
@Transactional("InsightlyCrmEtlTransactionManager")
@ConditionalOnProperty(name = "repository", havingValue = "Hybrid")
public class LeadServiceImpl extends AbstractLeadServiceImpl implements ILeadService {

	@Autowired
	@Qualifier("LeadServiceDatabaseImpl")
	private ILeadService leadServiceDatabaseImpl;
	@Autowired
	@Qualifier("LeadServiceRestImpl")
	private ILeadService leadServiceRestImpl;
	
	@Override
	public Optional<Lead> findById(Long leadId) throws InsightlyApiException {
		return leadServiceDatabaseImpl.findById(leadId);
	}
	
	@Override
	public List<Lead> findByExample(Lead lead) throws InsightlyApiException {
		return leadServiceDatabaseImpl.findByExample(lead);
	}

	@Override
	public List<Lead> findByEmail(String email) throws InsightlyApiException {
		return leadServiceDatabaseImpl.findByEmail(email);
	}

	@Override
	public Lead save(Lead lead) throws InsightlyApiException {
		// Perform one final check if the lead already exists in Insightly		
		final String organisationName = lead.getOrganizationName();
		List<Lead> leads = leadServiceRestImpl.findByEmail(lead.getEmail());
		Optional<Lead> insightlyLead = leads.stream()
											.filter(l -> l.getOrganizationName().equalsIgnoreCase(organisationName))
											.findFirst();
		
		if(!insightlyLead.isPresent()) {
			lead = leadServiceRestImpl.save(lead);
		} else {
			// The Lead already exists.
			// Retrieve its LEAD_ID to update the passed in 'Lead' argument
			// Perhaps the local database was missing the lead in the first place and needs to be updated
			lead.setId(insightlyLead.get().getId());
		}
		lead = leadServiceDatabaseImpl.save(lead);
		return lead;
	}
	
	@Override
	public void sync(Lead leadToSync) throws InsightlyApiException {
		final String organisationName = leadToSync.getOrganizationName();
		List<Lead> leads = findByEmail(leadToSync.getEmail());
		Optional<Lead> insightlyLead = leads.stream()
									.filter(l -> l.getOrganizationName().equalsIgnoreCase(organisationName))
									.findFirst();
		
		if(!insightlyLead.isPresent()) {
			save(leadToSync);
		} else {
			updateLead(insightlyLead.get(), leadToSync);
		}
	}	

	private Lead updateLead(Lead lead, Lead leadToSync) throws InsightlyApiException {
		logger.trace("Updating Insightly {} ...", lead);
		
		leadToSync.getCustomFields().forEach(customField -> {
			Optional<CustomField> newOrUpdatedCustomField = lead.setCustomField(customField);
			
			newOrUpdatedCustomField.ifPresent(cf -> {
				try {
					updateCustomField(lead.getId(), cf);
				} catch (InsightlyApiException e) {
					ExceptionUtils.rethrow(e);
				}
			});
		});
		return lead;
	}

	@Override
	@Transactional(propagation = Propagation.NEVER)
	public void syncDB() throws InsightlyApiException {
		int numberOfLeadsToProcess = 0;
		int numberOfLeadsProcessed = 0;
		int skip = 0;
		int top = appConfig.getResourceCount();
		List<Lead> leads = new ArrayList<Lead>();

		do {
			try {
				leads = leadServiceRestImpl.findLeads(appConfig.getUpdatedAfterUtc(), skip, top);
			} catch(Exception ex) {
				throw new InsightlyApiException(ex);
			}
			numberOfLeadsToProcess += leads.size();

			for (Lead lead : leads) {
				numberOfLeadsProcessed++;
				logger.debug("Processing Lead {}/{}: {} ...", numberOfLeadsProcessed, 
															numberOfLeadsToProcess, 
															lead);

				if (CollectionUtils.isEmpty(leadServiceDatabaseImpl.findByExample(lead))) {
					logger.trace("Saving {}", lead);
					leadServiceDatabaseImpl.save(lead);
				} else {
					logger.trace("Skipping {}", lead);
				}
			}
			skip += top;
		} while (leads.size() > 0);
	}
	
	@Override
	public CustomField updateCustomField(Long leadId, CustomField customField) throws InsightlyApiException {
		customField = leadServiceRestImpl.updateCustomField(leadId, customField);
		customField = leadServiceDatabaseImpl.updateCustomField(leadId, customField);
		return customField;
	}
}