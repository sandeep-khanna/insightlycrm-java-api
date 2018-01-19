package com.insightly.etl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insightly.etl.dao.ILeadRepository;
import com.insightly.model.CustomField;
import com.insightly.model.Lead;

/**
 * 
 * 
 * @author Sandeep Khanna
 */
@Service("LeadServiceDatabaseImpl")
@Transactional("InsightlyCrmEtlTransactionManager")
@ConditionalOnExpression("'${repository}'=='LocalDB' or '${repository}'=='Hybrid'")
public class LeadServiceDatabaseImpl extends AbstractLeadServiceImpl implements ILeadService {

	@Autowired
	private ILeadRepository leadRepository;
	
	@Override
	public Optional<Lead> findById(Long leadId) {
		return leadRepository.findById(leadId);
	}
	
	@Override
	public List<Lead> findByExample(Lead lead) {
		return leadRepository.findAll(Example.of(lead));
	}
	
	@Override
	public List<Lead> findByEmail(String email) {
		return leadRepository.findByEmailIgnoreCase(email);
	}

	@Override
	public Lead save(Lead lead) {
		return leadRepository.save(lead);
	}
	
	@Override
	public void sync(Lead leadToSync) {
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
	
	private Lead updateLead(Lead lead, Lead leadToSync) {
		logger.trace("Updating Insightly {} ...", lead);
		
		leadToSync.getCustomFields().forEach(customField -> {
			Optional<CustomField> newOrUpdatedCustomField = lead.setCustomField(customField);
			
			newOrUpdatedCustomField.ifPresent(cf -> {
				updateCustomField(lead.getId(), cf);
			});
		});
		return lead;
	}
	
	@Override
	public CustomField updateCustomField(Long leadId, CustomField customField) {
		Optional<Lead> lead = findById(leadId);
		CustomField updatedCustomField = null;
		
		if(lead.isPresent()) {
			Lead l = lead.get();
			l.setCustomField(customField);
//			updatedCustomField = customFieldRepository.save(customField);
			save(l);
		}
		return updatedCustomField;
	}
}