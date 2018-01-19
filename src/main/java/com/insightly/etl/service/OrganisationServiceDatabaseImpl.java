package com.insightly.etl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insightly.etl.dao.IOrganisationRepository;
import com.insightly.model.Address;
import com.insightly.model.ContactInfo;
import com.insightly.model.CustomField;
import com.insightly.model.Organisation;

/**
 * 
 * 
 * @author Sandeep Khanna
 */
@Service("OrganisationServiceDatabaseImpl")
@Transactional("InsightlyCrmEtlTransactionManager")
@ConditionalOnExpression("'${repository}'=='LocalDB' or '${repository}'=='Hybrid'")
public class OrganisationServiceDatabaseImpl extends AbstractOrganisationServiceImpl implements IOrganisationService {

	@Autowired
	private IOrganisationRepository organisationRepository;

	@Override
	public Optional<Organisation> findById(Long organisationId) {
		return organisationRepository.findOne(organisationId);
	}
	
	@Override
	public List<Organisation> findByName(String organisationName) {
		return organisationRepository.findByName(organisationName);
	}

	@Override
	public Organisation save(Organisation organisation) {
		return organisationRepository.save(organisation);
	}
	
	@Override
	public Organisation update(Organisation organisation, boolean brief) {
		return save(organisation);
	}
	
	public Address addAddress(Long organisationId, Address address) {
		Optional<Organisation> organisation = findById(organisationId);
		
		organisation.ifPresent(o -> {
			o.setAddress(address).ifPresent(a -> {
				save(o);
			});
		});
		return address;
	}
	
	public ContactInfo addContactInfo(Long organisationId, ContactInfo contactInfo) {
		Optional<Organisation> organisation = findById(organisationId);
		
		organisation.ifPresent(o -> {
			o.setContactInfo(contactInfo).ifPresent(c ->{
				save(o);
			});
		});
		return contactInfo;
	}
	
	@Override
	public CustomField updateCustomField(Long organisationId, CustomField customField) {
		Optional<Organisation> organisation = findById(organisationId);
		
		organisation.ifPresent(o -> {
			o.setCustomField(customField).ifPresent(cf -> {
				save(o);
			});
		});
		return customField;
	}
}