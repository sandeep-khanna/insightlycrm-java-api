package com.insightly.etl.service;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import com.insightly.api.OrganisationsApi;
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
@Service("OrganisationServiceRestImpl")
@Transactional("InsightlyCrmEtlTransactionManager")
@CacheConfig(cacheNames = {"insightlyOrganisationsCache"})
@ConditionalOnExpression("'${repository}'=='RemoteAPI' or '${repository}'=='Hybrid'")
public class OrganisationServiceRestImpl extends AbstractOrganisationServiceImpl implements IOrganisationService {

	@Autowired
	private OrganisationsApi organisationsApi;

	@Override
	@Cacheable(value = "insightlyOrganisationsCache", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')")
	public Optional<Organisation> findById(Long organisationId) throws InsightlyApiException {
		Optional<Organisation> organisation = Optional.empty();
		logger.trace("Retrieving Organisation by ID:{}", organisationId);
		
		try {
			organisation = Optional.ofNullable(organisationsApi.getOrganisation(organisationId));
		} catch(HttpClientErrorException ex) {
			final HttpStatus errorStatusCode = ex.getStatusCode();
			
			if(HttpStatus.BAD_REQUEST.equals(errorStatusCode)
				||
				HttpStatus.UNAUTHORIZED.equals(errorStatusCode)
				||
				HttpStatus.FORBIDDEN.equals(errorStatusCode)
				||
				HttpStatus.NOT_FOUND.equals(errorStatusCode)
				||
				HttpStatus.TOO_MANY_REQUESTS.equals(errorStatusCode)) {
				throw new InsightlyApiException(ex.getResponseBodyAsString(), ex);
			}
		} catch(RestClientException ex) {
			logger.error("Error searching Insightly for Organisation by ID:{}", organisationId);
			ExceptionUtils.rethrow(ex);
		}
		return organisation;
	}
	
	@Override
	@Cacheable(value = "insightlyOrganisationsCache", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')")
	public List<Organisation> findByName(String organisationName) throws InsightlyApiException {
		List<Organisation> organisations = Collections.emptyList();
		logger.trace("Retrieving all Organisations by name: {}", organisationName);
		
		try {
			organisations = organisationsApi.getOrganisationsBySearch(null, null, null, 
														null, organisationName, 
														null, null, null, 
														null, null, null, 
														null, null, null);
		} catch(HttpClientErrorException ex) {
			logger.error("Error searching Insightly for Organisation: {}", organisationName);
			final HttpStatus errorStatusCode = ex.getStatusCode();
			
			if(HttpStatus.BAD_REQUEST.equals(errorStatusCode)
				||
				HttpStatus.UNAUTHORIZED.equals(errorStatusCode)
				||
				HttpStatus.TOO_MANY_REQUESTS.equals(errorStatusCode)) {
				throw new InsightlyApiException(ex.getResponseBodyAsString(), ex);
			}
		} catch(RestClientException ex) {
			logger.error("Error searching Insightly for Organisation: {}", organisationName);
			ExceptionUtils.rethrow(ex);
		}
		return organisations;
	}
	
	@Override
	public List<Organisation> findOrganisations(Instant updatedAfterUtc, Integer skip, Integer top) throws InsightlyApiException {
		List<Organisation> organisations = Collections.emptyList();
		logger.trace("Retrieving all organisations updated after: {} (Skipping first {} records and fetching next {}", updatedAfterUtc, skip, top);
		
		try {
			organisations = organisationsApi.getOrganisationsBySearch(null, null, null, null, null, null, null, null,
																		null, updatedAfterUtc, null, skip, top, false);
		} catch(HttpClientErrorException ex) {
			logger.error("Unable to retrieve organisations updated after: {} (Skipping first {} records and fetching next {}", updatedAfterUtc, skip, top);
			final HttpStatus errorStatusCode = ex.getStatusCode();
			
			if(HttpStatus.BAD_REQUEST.equals(errorStatusCode)
				||
				HttpStatus.UNAUTHORIZED.equals(errorStatusCode)
				||
				HttpStatus.TOO_MANY_REQUESTS.equals(errorStatusCode)) {
				throw new InsightlyApiException(ex.getResponseBodyAsString(), ex);
			}
		} catch(RestClientException ex) {
			logger.error("Unable to retrieve organisations updated after: {} (Skipping first {} records and fetching next {}", updatedAfterUtc, skip, top);
			ExceptionUtils.rethrow(ex);
		}
		return organisations;
	}

	@Override
	@Caching(evict = {
			@CacheEvict(value = "insightlyOrganisationsCache", key = "#result.id", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')"),
			@CacheEvict(value = "insightlyOrganisationsCache", key = "#result.name", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')")})
	public Organisation save(Organisation organisation) throws InsightlyApiException {
		logger.trace("Adding {}", organisation);
		
		try {
			organisation = organisationsApi.addOrganisation(organisation);
		} catch(HttpClientErrorException ex) {
			logger.error("Error posting new Insightly {}", organisation);
			final HttpStatus errorStatusCode = ex.getStatusCode();
			
			if(HttpStatus.BAD_REQUEST.equals(errorStatusCode)
				||
				HttpStatus.UNAUTHORIZED.equals(errorStatusCode)
				||
				HttpStatus.PAYMENT_REQUIRED.equals(errorStatusCode)
				||
				HttpStatus.TOO_MANY_REQUESTS.equals(errorStatusCode)) {
				throw new InsightlyApiException(ex.getResponseBodyAsString(), ex);
			}
		} catch(RestClientException ex) {
			logger.error("Error posting new Insightly {}", organisation);
			ExceptionUtils.rethrow(ex);
		}
		return organisation;
	}
	
	@Override
	@Caching(evict = {
			@CacheEvict(value = "insightlyOrganisationsCache", key = "#result.id", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')"),
			@CacheEvict(value = "insightlyOrganisationsCache", key = "#result.name", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')")})
	public Organisation update(Organisation organisation, boolean brief) throws InsightlyApiException {
		logger.trace("Updating {}", organisation);
		
		try {
			organisation = organisationsApi.updateOrganisation(organisation, brief);
		} catch(HttpClientErrorException ex) {
			logger.error("Error posting new Insightly {}", organisation);
			final HttpStatus errorStatusCode = ex.getStatusCode();
			
			if(HttpStatus.BAD_REQUEST.equals(errorStatusCode)
				||
				HttpStatus.UNAUTHORIZED.equals(errorStatusCode)
				||
				HttpStatus.FORBIDDEN.equals(errorStatusCode)
				||
				HttpStatus.NOT_FOUND.equals(errorStatusCode)
				||
				HttpStatus.TOO_MANY_REQUESTS.equals(errorStatusCode)) {
				throw new InsightlyApiException(ex.getResponseBodyAsString(), ex);
			}
		} catch(RestClientException ex) {
			logger.error("Error posting new Insightly {}", organisation);
			ExceptionUtils.rethrow(ex);
		}
		return organisation;
	}

	@Override
	@Caching(evict = {
			@CacheEvict(value = "insightlyOrganisationsCache", key = "#organisationId", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')"),
			@CacheEvict(value = "insightlyOrganisationsCache", key = "#root.target.findById(#organisationId).get().name", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')")})
	public Address addAddress(Long organisationId, Address address) throws InsightlyApiException {
		logger.trace("Adding {} for Organisation ID:{}", address, organisationId);
		
		try {
			address = organisationsApi.addAddress(organisationId, address);
		} catch(HttpClientErrorException ex) {
			logger.error("Error updating Insightly Organisation ID:{} with {}", organisationId, address);
			final HttpStatus errorStatusCode = ex.getStatusCode();
			
			if(HttpStatus.BAD_REQUEST.equals(errorStatusCode)
				||
				HttpStatus.UNAUTHORIZED.equals(errorStatusCode)
				||
				HttpStatus.FORBIDDEN.equals(errorStatusCode)
				||
				HttpStatus.NOT_FOUND.equals(errorStatusCode)
				||
				HttpStatus.TOO_MANY_REQUESTS.equals(errorStatusCode)) {
				throw new InsightlyApiException(ex.getResponseBodyAsString(), ex);
			}
		} catch(RestClientException ex) {
			logger.error("Error updating Insightly Organisation ID:{} with ", organisationId, address);
			ExceptionUtils.rethrow(ex);
		}
		return address;
	}

	@Override
	@Caching(evict = {
			@CacheEvict(value = "insightlyOrganisationsCache", key = "#organisationId", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')"),
			@CacheEvict(value = "insightlyOrganisationsCache", key = "#root.target.findById(#organisationId).get().name", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')")})
	public ContactInfo addContactInfo(Long organisationId, ContactInfo contactInfo) throws InsightlyApiException {
		logger.trace("Adding {} for Organisation ID:{}", contactInfo, organisationId);
		
		try {
			contactInfo = organisationsApi.addContactInfo(organisationId, contactInfo);
		} catch(HttpClientErrorException ex) {
			logger.error("Error updating Insightly Organisation ID:{} with {}", organisationId, contactInfo);
			final HttpStatus errorStatusCode = ex.getStatusCode();
			
			if(HttpStatus.BAD_REQUEST.equals(errorStatusCode)
				||
				HttpStatus.UNAUTHORIZED.equals(errorStatusCode)
				||
				HttpStatus.FORBIDDEN.equals(errorStatusCode)
				||
				HttpStatus.NOT_FOUND.equals(errorStatusCode)
				||
				HttpStatus.TOO_MANY_REQUESTS.equals(errorStatusCode)) {
				throw new InsightlyApiException(ex.getResponseBodyAsString(), ex);
			}
		} catch(RestClientException ex) {
			logger.error("Error updating Insightly Organisation ID:{} with {}", organisationId, contactInfo);
			ExceptionUtils.rethrow(ex);
		}
		return contactInfo;
	}

	@Override
	@Caching(evict = {
			@CacheEvict(value = "insightlyOrganisationsCache", key = "#organisationId", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')"),
			@CacheEvict(value = "insightlyOrganisationsCache", key = "#root.target.findById(#organisationId).get().name", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')")})
	public CustomField updateCustomField(Long organisationId, CustomField customField) throws InsightlyApiException {
		logger.trace("Updating Custom Field {} for Organisation ID:{}", customField, organisationId);
		
		try {
			customField = organisationsApi.updateCustomField(organisationId, customField);
		} catch(HttpClientErrorException ex) {
			logger.error("Error updating Insightly Organisation ID:{} with {}", organisationId, customField);
			final HttpStatus errorStatusCode = ex.getStatusCode();
			
			if(HttpStatus.BAD_REQUEST.equals(errorStatusCode)
				||
				HttpStatus.UNAUTHORIZED.equals(errorStatusCode)
				||
				HttpStatus.FORBIDDEN.equals(errorStatusCode)
				||
				HttpStatus.NOT_FOUND.equals(errorStatusCode)
				||
				HttpStatus.TOO_MANY_REQUESTS.equals(errorStatusCode)) {
				throw new InsightlyApiException(ex.getResponseBodyAsString(), ex);
			}
		} catch(RestClientException ex) {
			logger.error("Error updating Insightly Organisation ID:{} with {}", organisationId, customField);
			ExceptionUtils.rethrow(ex);
		}
		return customField;
	}
}