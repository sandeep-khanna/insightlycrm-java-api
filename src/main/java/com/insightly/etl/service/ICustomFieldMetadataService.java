package com.insightly.etl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;

import com.insightly.etl.util.InsightlyApiException;
import com.insightly.model.CustomFieldMetadata;

/**
 * 
 * 
 * @author Sandeep Khanna
 */
@NoRepositoryBean
public interface ICustomFieldMetadataService {
	public List<CustomFieldMetadata> findAll(Integer skip, Integer top) throws InsightlyApiException;
	public Optional<CustomFieldMetadata> findOptionalByFieldID(String customFieldID) throws InsightlyApiException;
	public <T extends CustomFieldMetadata> T save(T customFieldMetadata);
	public void save(List<CustomFieldMetadata> customFieldMetadata);
	public void syncDB() throws InsightlyApiException;
}