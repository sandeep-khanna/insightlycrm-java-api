package com.insightly.etl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.insightly.etl.util.InsightlyApiException;
import com.insightly.model.CustomFieldMetadata;

/**
 * 
 * 
 * @author Sandeep Khanna
 */
@Primary
@Service
@Transactional("InsightlyCrmEtlTransactionManager")
@ConditionalOnProperty(name = "repository", havingValue = "Hybrid")
public class CustomFieldMetadataServiceImpl extends AbstractCustomFieldMetadataServiceImpl implements ICustomFieldMetadataService {

	@Autowired
	@Qualifier("CustomFieldMetadataServiceDatabaseImpl")
	private ICustomFieldMetadataService customFieldMetadataDatabaseImpl;
	@Autowired
	@Qualifier("CustomFieldMetadataServiceRestImpl")
	private ICustomFieldMetadataService customFieldMetadataRestImpl;

	@Override
	public List<CustomFieldMetadata> findAll(Integer skip, Integer top) throws InsightlyApiException {
		List<CustomFieldMetadata> customFieldMetadataList = customFieldMetadataDatabaseImpl.findAll(skip, top);
		
		if(CollectionUtils.isEmpty(customFieldMetadataList)) {
			customFieldMetadataList = customFieldMetadataRestImpl.findAll(skip, top);
			
			if(!CollectionUtils.isEmpty(customFieldMetadataList)) {
				customFieldMetadataDatabaseImpl.save(customFieldMetadataList);
			}
		}
		return customFieldMetadataList;
	}

	@Override
	@Cacheable(value = "insightlyCustomFieldMetadataCache", unless = "#result == null")
	public Optional<CustomFieldMetadata> findOptionalByFieldID(String customFieldID) throws InsightlyApiException {
		Optional<CustomFieldMetadata> customFieldMetadata = customFieldMetadataDatabaseImpl.findOptionalByFieldID(customFieldID);
		
		if(!customFieldMetadata.isPresent()) {
			customFieldMetadata = customFieldMetadataRestImpl.findOptionalByFieldID(customFieldID);
			
			customFieldMetadata.ifPresent(cfm -> {
				customFieldMetadataDatabaseImpl.save(cfm);
			});
		}
		return customFieldMetadata;
	}
	
	@Override
	@Transactional(propagation = Propagation.NEVER)
	public void syncDB() throws InsightlyApiException {
		int numberOfCustomFieldsToProcess = 0;
		int numberOfCustomFieldsProcessed = 0;
		int skip = 0;
		int top = appConfig.getResourceCount();
		List<CustomFieldMetadata> customFieldMetadataList = new ArrayList<CustomFieldMetadata>();

		do {
			try {
				customFieldMetadataList = customFieldMetadataRestImpl.findAll(skip, top);
			} catch(Exception ex) {
				throw new InsightlyApiException(ex);
			}
			numberOfCustomFieldsToProcess += customFieldMetadataList.size();

			for (CustomFieldMetadata customFieldMetadata : customFieldMetadataList) {
				numberOfCustomFieldsProcessed++;
				String customFieldID = customFieldMetadata.getFieldID();
				logger.debug("Processing CustomFieldMetadata {}/{}: {} ...", numberOfCustomFieldsProcessed, 
																			numberOfCustomFieldsToProcess, 
																			customFieldMetadata);
				Optional<CustomFieldMetadata> cfm = customFieldMetadataDatabaseImpl.findOptionalByFieldID(customFieldID);
				
				if (!cfm.isPresent()) {
					logger.trace("Saving {}", customFieldMetadata);
					customFieldMetadataDatabaseImpl.save(customFieldMetadata);
				} else {
					logger.trace("Skipping {}", customFieldMetadata);
				}
			}
			skip += top;
		} while (customFieldMetadataList.size() > 0);
	}
}