package com.insightly.etl.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;

import com.insightly.etl.util.InsightlyApiException;
import com.insightly.model.CustomField;
import com.insightly.model.Lead;

/**
 * 
 * 
 * @author Sandeep Khanna
 */
@NoRepositoryBean
public interface ILeadService {
	public Optional<Lead> findById(Long leadId) throws InsightlyApiException;
	public List<Lead> findByExample(Lead lead) throws InsightlyApiException;
	public List<Lead> findByEmail(String email) throws InsightlyApiException;
	public List<Lead> findLeads(Instant updatedAfterUtc, Integer skip, Integer top) throws InsightlyApiException;
	public Lead save(Lead lead) throws InsightlyApiException;
	public void sync(Lead leadToSync) throws InsightlyApiException;
	public void syncDB() throws InsightlyApiException;
	public CustomField updateCustomField(Long leadId, CustomField customField) throws InsightlyApiException;
}