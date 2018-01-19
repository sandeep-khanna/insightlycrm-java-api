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

import com.insightly.api.LeadsApi;
import com.insightly.etl.util.InsightlyApiException;
import com.insightly.model.CustomField;
import com.insightly.model.Lead;

/**
 * 
 * 
 * @author Sandeep Khanna
 */
@Service("LeadServiceRestImpl")
@Transactional("InsightlyCrmEtlTransactionManager")
@CacheConfig(cacheNames = {"insightlyLeadsCache"})
@ConditionalOnExpression("'${repository}'=='RemoteAPI' or '${repository}'=='Hybrid'")
public class LeadServiceRestImpl extends AbstractLeadServiceImpl implements ILeadService {

	@Autowired
	private LeadsApi leadsApi;
	
	@Override
	@Cacheable(value = "insightlyLeadsCache", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')")
	public Optional<Lead> findById(Long leadId) throws InsightlyApiException {
		Optional<Lead> lead = Optional.empty();
		logger.trace("Retrieving Lead by ID:{}", leadId);
		
		try {
			lead = Optional.ofNullable(leadsApi.getLead(leadId));
		} catch(HttpClientErrorException ex) {
			logger.error("Error searching Insightly for Lead by ID:{}", leadId);
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
			logger.error("Error searching Insightly for Lead by ID:{}", leadId);
			ExceptionUtils.rethrow(ex);
		}
		return lead;
	}
	
	@Override
	@Cacheable(value = "insightlyLeadsCache", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')")
	public List<Lead> findByEmail(String email) throws InsightlyApiException {
		List<Lead> leads = Collections.emptyList();
		logger.trace("Retrieving all leads (including converted) for email: {}", email);
		
		try {
			leads = leadsApi.getLeadsBySearch(email, null, null, null, 
										null, null, null, null, 
										null, null, null, true, 
										null, null, null, null);
		} catch(HttpClientErrorException ex) {
			logger.error("Error searching Insightly for Lead by email: {}", email);
			final HttpStatus errorStatusCode = ex.getStatusCode();
			
			if(HttpStatus.BAD_REQUEST.equals(errorStatusCode)
				||
				HttpStatus.UNAUTHORIZED.equals(errorStatusCode)
				||
				HttpStatus.FORBIDDEN.equals(errorStatusCode)
				||
				HttpStatus.TOO_MANY_REQUESTS.equals(errorStatusCode)) {
				throw new InsightlyApiException(ex.getResponseBodyAsString(), ex);
			}
		} catch(RestClientException ex) {
			logger.error("Error searching Insightly for Lead by email: {}", email);
			ExceptionUtils.rethrow(ex);
		}
		return leads;
	}
	
	@Override
	public List<Lead> findLeads(Instant updatedAfterUtc, Integer skip, Integer top) throws InsightlyApiException {
		List<Lead> leads = Collections.emptyList();
		logger.trace("Retrieving all leads (including converted) updated after: {} (Skipping first {} records and fetching next {}", updatedAfterUtc, skip, top);
		
		try {
			leads = leadsApi.getLeadsBySearch(null, null, null, null, null, null, null, null, null, null,
											updatedAfterUtc, true, null, skip, top, false);
		} catch(HttpClientErrorException ex) {
			logger.error("Unable to retrieve leads (including converted) updated after: {} (Skipping first {} records and fetching next {}", updatedAfterUtc, skip, top);
			final HttpStatus errorStatusCode = ex.getStatusCode();
			
			if(HttpStatus.BAD_REQUEST.equals(errorStatusCode)
				||
				HttpStatus.UNAUTHORIZED.equals(errorStatusCode)
				||
				HttpStatus.FORBIDDEN.equals(errorStatusCode)
				||
				HttpStatus.TOO_MANY_REQUESTS.equals(errorStatusCode)) {
				throw new InsightlyApiException(ex.getResponseBodyAsString(), ex);
			}
		} catch(RestClientException ex) {
			logger.error("Unable to retrieve leads (including converted) updated after: {} (Skipping first {} records and fetching next {}", updatedAfterUtc, skip, top);
			ExceptionUtils.rethrow(ex);
		}
		return leads;
	}

	@Override
	@Caching(evict = {
			@CacheEvict(value = "insightlyLeadsCache", key = "#result.id", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')"),
			@CacheEvict(value = "insightlyLeadsCache", key = "#result.email", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')")})
	public Lead save(Lead lead) throws InsightlyApiException {
		logger.trace("Adding {}", lead);
		
		try {
			lead = leadsApi.addLead(lead);
		} catch(HttpClientErrorException ex) {
			logger.error("Error posting new Insightly {}", lead);
			final HttpStatus errorStatusCode = ex.getStatusCode();
			
			if(HttpStatus.BAD_REQUEST.equals(errorStatusCode)
				||
				HttpStatus.UNAUTHORIZED.equals(errorStatusCode)
				||
				HttpStatus.PAYMENT_REQUIRED.equals(errorStatusCode)
				||
				HttpStatus.FORBIDDEN.equals(errorStatusCode)
				||
				HttpStatus.TOO_MANY_REQUESTS.equals(errorStatusCode)) {
				throw new InsightlyApiException(ex.getResponseBodyAsString(), ex);
			}
		} catch(RestClientException ex) {
			logger.error("Error posting new Insightly {}", lead);
			ExceptionUtils.rethrow(ex);
		}
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
	@Caching(evict = {
			@CacheEvict(value = "insightlyLeadsCache", key = "#leadId", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')"),
			@CacheEvict(value = "insightlyLeadsCache", key = "#root.target.findById(#leadId).get().email", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')")})
	public CustomField updateCustomField(Long leadId, CustomField customField) throws InsightlyApiException {
		logger.trace("Updating Custom Field {} for Lead id:{}", customField, leadId);
		
		try {
			customField = leadsApi.updateCustomField(leadId, customField);
		} catch(HttpClientErrorException ex) {
			logger.error("Error updating Insightly Lead ID:{} with {}", leadId, customField);
			final HttpStatus errorStatusCode = ex.getStatusCode();
			
			if(HttpStatus.BAD_REQUEST.equals(errorStatusCode)
				||
				HttpStatus.UNAUTHORIZED.equals(errorStatusCode)
				||
				HttpStatus.FORBIDDEN.equals(errorStatusCode)
				||
				HttpStatus.TOO_MANY_REQUESTS.equals(errorStatusCode)
				||
				HttpStatus.NOT_FOUND.equals(errorStatusCode)) {
				throw new InsightlyApiException(ex.getResponseBodyAsString(), ex);
			}
		} catch(RestClientException ex) {
			logger.error("Error updating Insightly Lead ID:{} with {}", leadId, customField);
			ExceptionUtils.rethrow(ex);
		}
		return customField;
	}
}