package com.insightly.etl.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.insightly.model.AddressType;

/**
 * 
 * 
 * @author Sandeep Khanna
 */
public interface IAddressTypeRepository extends CrudRepository<AddressType, Long> {
	public Optional<AddressType> findOptionalByName(String name);
	public <T extends AddressType> T save(T addressType);
}