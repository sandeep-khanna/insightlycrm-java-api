package com.insightly.etl.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.insightly.api.CustomFieldsApi;
import com.insightly.etl.util.InsightlyApiException;
import com.insightly.model.CustomFieldMetadata;

/**
 * 
 * 
 * @author Sandeep Khanna
 */
@Service("CustomFieldMetadataServiceRestImpl")
@Transactional("InsightlyCrmEtlTransactionManager")
@CacheConfig(cacheNames = {"insightlyCustomFieldMetadataCache"})
@ConditionalOnExpression("'${repository}'=='RemoteAPI' or '${repository}'=='Hybrid'")
public class CustomFieldMetadataServiceRestImpl extends AbstractCustomFieldMetadataServiceImpl implements ICustomFieldMetadataService {

	@Autowired
	private CustomFieldsApi customFieldsApi;
	private List<CustomFieldMetadata> customFieldMetadataList = null;

	@Override
	@Cacheable(value = "insightlyCustomFieldMetadataCache", key="all", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')")
	public List<CustomFieldMetadata> findAll(Integer skip, Integer top) throws InsightlyApiException {
		customFieldMetadataList = customFieldsApi.getCustomFields(skip, top, null);
		return customFieldMetadataList;
	}

	@Override
	@Cacheable(value = "insightlyCustomFieldMetadataCache", condition = "(#result != null) && (#root.target.appConfig.repository == 'RemoteAPI')")
	public Optional<CustomFieldMetadata> findOptionalByFieldID(String customFieldID) throws InsightlyApiException {
		
		if(CollectionUtils.isEmpty(customFieldMetadataList)) {
			findAll(null, null);
		}
			
		return getStream(customFieldMetadataList)
				.filter(customFieldMetadata -> StringUtils.equalsIgnoreCase(customFieldMetadata.getFieldID(), customFieldID))
				.findFirst();
	}
}