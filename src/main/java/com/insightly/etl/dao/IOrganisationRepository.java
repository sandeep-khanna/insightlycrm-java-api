package com.insightly.etl.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.insightly.model.Organisation;

/**
 * 
 * 
 * @author Sandeep Khanna
 */
public interface IOrganisationRepository extends Repository<Organisation, Long> {
	public Optional<Organisation> findOne(Long id);
	public List<Organisation> findByName(String companyName);
	public <O extends Organisation> O save(O organisation);
}