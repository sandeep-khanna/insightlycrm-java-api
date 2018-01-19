package com.insightly.etl.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.insightly.model.CustomFieldMetadata;

/**
 * 
 * 
 * @author Sandeep Khanna
 */
public interface ICustomFieldMetadataRepository extends CrudRepository<CustomFieldMetadata, Long> {
	public Optional<CustomFieldMetadata> findOptionalByFieldID(String customFieldID);
	public <T extends CustomFieldMetadata> T save(T customFieldMetadata);
}