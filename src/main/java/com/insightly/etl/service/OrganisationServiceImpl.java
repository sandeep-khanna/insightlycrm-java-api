package com.insightly.etl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.insightly.etl.util.InsightlyApiException;
import com.insightly.model.Address;
import com.insightly.model.AddressType;
import com.insightly.model.ContactInfo;
import com.insightly.model.ContactInfoType;
import com.insightly.model.CustomField;
import com.insightly.model.Organisation;

@Primary
@Service
@Transactional("InsightlyCrmEtlTransactionManager")
@ConditionalOnProperty(name = "repository", havingValue = "Hybrid")
public class OrganisationServiceImpl extends AbstractOrganisationServiceImpl implements IOrganisationService {
	
	@Autowired
	@Qualifier("OrganisationServiceDatabaseImpl")
	private IOrganisationService organisationServiceDatabaseImpl;
	@Autowired
	@Qualifier("OrganisationServiceRestImpl")
	private IOrganisationService organisationServiceRestImpl;
	
	@Override
	public Optional<Organisation> findById(Long organisationId) throws InsightlyApiException {
		return organisationServiceDatabaseImpl.findById(organisationId);
	}

	@Override
	public List<Organisation> findByName(String organisationName) throws InsightlyApiException {
		return organisationServiceDatabaseImpl.findByName(organisationName);
	}

	@Override
	public Organisation save(Organisation organisation) throws InsightlyApiException {
		// Perform one final check if the organisation already exists in Insightly
		final String organisationName = organisation.getName();
		List<Organisation> organisations = organisationServiceRestImpl.findByName(organisationName);
		Optional<Organisation> insightlyOrganisation = organisations.stream()
																	.filter(o -> o.getName().equalsIgnoreCase(organisationName))
																	.findFirst();

		if(!insightlyOrganisation.isPresent()) {
			organisation = organisationServiceRestImpl.save(organisation);
		} else {
			// The Organisation already exists.
			// Retrieve its ORGANISATION_ID to update the passed in 'Organisation' argument
			// Perhaps the local database was missing the organisation in the first place and needs to be updated
			organisation = insightlyOrganisation.get();
		}
		organisation = organisationServiceDatabaseImpl.save(organisation);
		return organisation;
	}
	
	@Override
	public Organisation update(Organisation organisation, boolean brief) throws InsightlyApiException {		
		Organisation insightlyOrganisation = organisationServiceRestImpl.update(organisation, brief);
		organisation = organisationServiceDatabaseImpl.save(insightlyOrganisation);
		return organisation;
	}
	
	@Override
	public void sync(Organisation organisationToSync) throws InsightlyApiException {
		final String organisationName = organisationToSync.getName();
		List<Organisation> organisations = findByName(organisationName);
		Optional<Organisation> insightlyOrganisation = organisations.stream()
															.filter(o -> o.getName().equalsIgnoreCase(organisationName))
															.findFirst();
		
		if(!insightlyOrganisation.isPresent()) {
			save(organisationToSync);
		} else {
			updateOrganisation(insightlyOrganisation.get(), organisationToSync);
		}
	}

	@Override
	@Transactional(propagation = Propagation.NEVER)
	public void syncDB() throws InsightlyApiException {
		int numberOfOrganisationsToProcess = 0;
		int numberOfOrganisationsProcessed = 0;
		int skip = 0;
		int top = appConfig.getResourceCount();
		List<Organisation> organisations = new ArrayList<Organisation>();
		
		do {
			organisations = organisationServiceRestImpl.findOrganisations(appConfig.getUpdatedAfterUtc(), skip, top);
			numberOfOrganisationsToProcess += organisations.size();
			long organisationId = 0L;

			for (Organisation organisation : organisations) {
				numberOfOrganisationsProcessed++;
				organisationId = organisation.getId();
				logger.debug("Processing Organisation {}/{}: {} ...", numberOfOrganisationsProcessed,
																	numberOfOrganisationsToProcess, 
																	organisation);

				if (!organisationServiceDatabaseImpl.findById(organisationId).isPresent()) {
					logger.trace("Saving {}", organisation);
					organisationServiceDatabaseImpl.save(organisation);
				} else {
					logger.trace("Skipping {}", organisation);
				}
			}
			skip += top;
		} while (organisations.size() > 0);
	}
	
	private Organisation updateOrganisation(Organisation organisation, Organisation organisationToSync) throws InsightlyApiException {
		logger.trace("Updating Insightly {} ...", organisation);
		
		if( !StringUtils.equalsIgnoreCase(organisation.getDescription(), organisationToSync.getDescription()) ) {
			organisationToSync.setId(organisation.getId());
			update(organisationToSync, true);
		}
		
		organisationToSync.getAddresses().forEach(address -> {
			Optional<Address> newOrUpdatedAddress = organisation.setAddress(address);
			
			newOrUpdatedAddress.ifPresent(a -> {
				try {
					addAddress(organisation.getId(), a);
				} catch (InsightlyApiException e) {
					ExceptionUtils.rethrow(e);
				}
			});
		});
		
		organisationToSync.getContactInfos().forEach(contactInfo -> {
			Optional<ContactInfo> newOrUpdatedContactInfo = organisation.setContactInfo(contactInfo);
			
			newOrUpdatedContactInfo.ifPresent(ci -> {
				try {
					addContactInfo(organisation.getId(), ci);
				} catch (InsightlyApiException e) {
					ExceptionUtils.rethrow(e);
				}
			});
		});
		
		organisationToSync.getCustomFields().forEach(customField -> {
			Optional<CustomField> newOrUpdatedCustomField = organisation.setCustomField(customField);
			
			newOrUpdatedCustomField.ifPresent(cf -> {
				try {
					updateCustomField(organisation.getId(), cf);
				} catch (InsightlyApiException e) {
					ExceptionUtils.rethrow(e);
				}
			});
		});
		return organisation;
	}
	
	@Override
	public Address addAddress(Long organisationId, Address address) throws InsightlyApiException {
		AddressType addressType = address.getType();
		Address a = address;
		
		try {
			address = organisationServiceRestImpl.addAddress(organisationId, address);
		} catch(InsightlyApiException ex) {
			// The Address already exists.
			// Retrieve its ADDRESS_ID to update the passed in 'Address' argument
			// Perhaps the local database was missing the address in the first place and needs to be updated
			organisationServiceRestImpl.findById(organisationId).ifPresent(organisation -> {
				
				organisation.getAddresses().stream()
												.filter(x -> x.getType().equals(addressType))
												.findFirst()
												.ifPresent(y -> {
													a.setId(y.getId());
												});
 
			});
		}
		
		if(null != a.getId()) {
			address = organisationServiceDatabaseImpl.addAddress(organisationId, a);
		}
		return address;
	}

	@Override
	public ContactInfo addContactInfo(Long organisationId, ContactInfo contactInfo) throws InsightlyApiException {
		ContactInfoType contactInfoType = contactInfo.getType();
		ContactInfo ci = contactInfo;
		
		try {
			contactInfo = organisationServiceRestImpl.addContactInfo(organisationId, contactInfo);
		} catch(InsightlyApiException ex) {
			// The Contact Info already exists.
			// Retrieve its CONTACT_INFO_ID to update the passed in 'ContactInfo' argument
			// Perhaps the local database was missing the contact info in the first place and needs to be updated
			organisationServiceRestImpl.findById(organisationId).ifPresent(organisation -> {
				
				organisation.getContactInfos().stream()
												.filter(x -> x.getType().equals(contactInfoType))
												.findFirst()
												.ifPresent(y -> {
													ci.setId(y.getId());
												});
 
			});
		}
		
		if(null != ci.getId()) {
			contactInfo = organisationServiceDatabaseImpl.addContactInfo(organisationId, ci);
		}
		return contactInfo;
	}
	
	@Override
	public CustomField updateCustomField(Long organisationId, CustomField customField) throws InsightlyApiException {
		customField = organisationServiceRestImpl.updateCustomField(organisationId, customField);
		customField = organisationServiceDatabaseImpl.updateCustomField(organisationId, customField);
		return customField;
	}
}