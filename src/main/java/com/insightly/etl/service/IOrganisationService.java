package com.insightly.etl.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;

import com.insightly.etl.util.InsightlyApiException;
import com.insightly.model.Address;
import com.insightly.model.ContactInfo;
import com.insightly.model.CustomField;
import com.insightly.model.Organisation;

/**
 * 
 * 
 * @author Sandeep Khanna
 */
@NoRepositoryBean
public interface IOrganisationService {
	public Optional<Organisation> findById(Long organisationId) throws InsightlyApiException;
	public List<Organisation> findByName(String organisationName) throws InsightlyApiException;
	public List<Organisation> findOrganisations(Instant updatedAfterUtc, Integer skip, Integer top) throws InsightlyApiException;
	public Organisation save(Organisation organisation) throws InsightlyApiException;
	public Organisation update(Organisation organisation, boolean brief) throws InsightlyApiException;
	public void sync(Organisation organisationToSync) throws InsightlyApiException;
	public void syncDB() throws InsightlyApiException;
	public Address addAddress(Long organisationId, Address address) throws InsightlyApiException;
	public ContactInfo addContactInfo(Long organisationId, ContactInfo contactInfo) throws InsightlyApiException;
	public CustomField updateCustomField(Long organisationId, CustomField customField) throws InsightlyApiException;
}