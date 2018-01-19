package com.insightly.etl.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.insightly.model.ContactInfoType;

/**
 * 
 * 
 * @author Sandeep Khanna
 */
public interface IContactInfoTypeRepository extends CrudRepository<ContactInfoType, Long> {
	public Optional<ContactInfoType> findOptionalByName(String name);
	public <T extends ContactInfoType> T save(T contactInfoType);
}