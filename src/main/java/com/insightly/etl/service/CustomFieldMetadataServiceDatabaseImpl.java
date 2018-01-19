package com.insightly.etl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insightly.etl.dao.ICustomFieldMetadataRepository;
import com.insightly.etl.util.InsightlyApiException;
import com.insightly.model.CustomFieldMetadata;

/**
 * 
 * 
 * @author Sandeep Khanna
 */
@Service("CustomFieldMetadataServiceDatabaseImpl")
@Transactional("InsightlyCrmEtlTransactionManager")
@ConditionalOnExpression("'${repository}'=='LocalDB' or '${repository}'=='Hybrid'")
public class CustomFieldMetadataServiceDatabaseImpl extends AbstractCustomFieldMetadataServiceImpl implements ICustomFieldMetadataService {

	@Autowired
	ICustomFieldMetadataRepository customFieldMetadataRespository;
	
	@Override
	public List<CustomFieldMetadata> findAll(Integer skip, Integer top) throws InsightlyApiException {
		return (List<CustomFieldMetadata>) customFieldMetadataRespository.findAll();
	}
	
	@Override
	public Optional<CustomFieldMetadata> findOptionalByFieldID(String customFieldID) throws InsightlyApiException {
		return customFieldMetadataRespository.findOptionalByFieldID(customFieldID);
	}

	@Override
	public <T extends CustomFieldMetadata> T save(T customFieldMetadata) {
		return customFieldMetadataRespository.save(customFieldMetadata);
	}

	@Override
	public void save(List<CustomFieldMetadata> customFieldMetadata) {
		customFieldMetadataRespository.save(customFieldMetadata);
	}
}