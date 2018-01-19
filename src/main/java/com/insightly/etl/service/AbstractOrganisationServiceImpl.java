package com.insightly.etl.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.insightly.etl.util.AppConfig;
import com.insightly.etl.util.InsightlyApiException;
import com.insightly.model.Address;
import com.insightly.model.ContactInfo;
import com.insightly.model.CustomField;
import com.insightly.model.Organisation;

public abstract class AbstractOrganisationServiceImpl implements IOrganisationService {

	protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	public AppConfig appConfig;
	
	@Override
	public Optional<Organisation> findById(Long organisationId) throws InsightlyApiException {
		 throw new NotImplementedException(getClass() + " does not implement " + new Object() {}
																				      .getClass()
																				      .getEnclosingMethod()
																				      .getName());
	}

	@Override
	public List<Organisation> findByName(String organisationName) throws InsightlyApiException {
		 throw new NotImplementedException(getClass() + " does not implement " + new Object() {}
																				      .getClass()
																				      .getEnclosingMethod()
																				      .getName());
	}
	
	@Override
	public List<Organisation> findOrganisations(Instant updatedAfterUtc, Integer skip, Integer top) throws InsightlyApiException {
		 throw new NotImplementedException(getClass() + " does not implement " + new Object() {}
																				      .getClass()
																				      .getEnclosingMethod()
																				      .getName());
	}

	@Override
	public Organisation save(Organisation organisation) throws InsightlyApiException {
		 throw new NotImplementedException(getClass() + " does not implement " + new Object() {}
																				      .getClass()
																				      .getEnclosingMethod()
																				      .getName());
	}
	
	@Override
	public Organisation update(Organisation organisation, boolean brief) throws InsightlyApiException {
		 throw new NotImplementedException(getClass() + " does not implement " + new Object() {}
																				      .getClass()
																				      .getEnclosingMethod()
																				      .getName());
	}
	
	@Override
	public void sync(Organisation organisationToSync) throws InsightlyApiException {
		 throw new NotImplementedException(getClass() + " does not implement " + new Object() {}
																				      .getClass()
																				      .getEnclosingMethod()
																				      .getName());
	}
	
	@Override
	public void syncDB() throws InsightlyApiException {
		 throw new NotImplementedException(getClass() + " does not implement " + new Object() {}
																				      .getClass()
																				      .getEnclosingMethod()
																				      .getName());
	}
	
	@Override
	public Address addAddress(Long organisationId, Address address) throws InsightlyApiException {
		 throw new NotImplementedException(getClass() + " does not implement " + new Object() {}
																				      .getClass()
																				      .getEnclosingMethod()
																				      .getName());
	}

	@Override
	public ContactInfo addContactInfo(Long organisationId, ContactInfo contactInfo) throws InsightlyApiException {
		 throw new NotImplementedException(getClass() + " does not implement " + new Object() {}
																				      .getClass()
																				      .getEnclosingMethod()
																				      .getName());
	}

	@Override
	public CustomField updateCustomField(Long organisationId, CustomField customField) throws InsightlyApiException {
		 throw new NotImplementedException(getClass() + " does not implement " + new Object() {}
																				      .getClass()
																				      .getEnclosingMethod()
																				      .getName());
	}
}