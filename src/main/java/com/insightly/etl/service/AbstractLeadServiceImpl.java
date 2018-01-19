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
import com.insightly.model.CustomField;
import com.insightly.model.Lead;

public abstract class AbstractLeadServiceImpl implements ILeadService {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	public AppConfig appConfig;
	
	@Override
	public Optional<Lead> findById(Long leadId) throws InsightlyApiException {
		 throw new NotImplementedException(getClass() + " does not implement " + new Object() {}
																				      .getClass()
																				      .getEnclosingMethod()
																				      .getName());
	}
	
	@Override
	public List<Lead> findByExample(Lead lead) throws InsightlyApiException {
		 throw new NotImplementedException(getClass() + " does not implement " + new Object() {}
																				      .getClass()
																				      .getEnclosingMethod()
																				      .getName());
	}

	@Override
	public List<Lead> findByEmail(String email) throws InsightlyApiException {
		 throw new NotImplementedException(getClass() + " does not implement " + new Object() {}
																				      .getClass()
																				      .getEnclosingMethod()
																				      .getName());
	}
	
	@Override
	public List<Lead> findLeads(Instant updatedAfterUtc, Integer skip, Integer top) throws InsightlyApiException {
		 throw new NotImplementedException(getClass() + " does not implement " + new Object() {}
																				      .getClass()
																				      .getEnclosingMethod()
																				      .getName());
	}
	
	@Override
	public Lead save(Lead lead) throws InsightlyApiException {
		 throw new NotImplementedException(getClass() + " does not implement " + new Object() {}
																				      .getClass()
																				      .getEnclosingMethod()
																				      .getName());
	}
	
	@Override
	public void sync(Lead lead) throws InsightlyApiException {
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
	public CustomField updateCustomField(Long leadId, CustomField customField) throws InsightlyApiException {
		 throw new NotImplementedException(getClass() + " does not implement " + new Object() {}
																				      .getClass()
																				      .getEnclosingMethod()
																				      .getName());
	}
}