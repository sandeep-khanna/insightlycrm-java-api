package com.insightly.etl.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.insightly.model.Lead;

/**
 * 
 * 
 * @author Sandeep Khanna
 */
public interface ILeadRepository extends JpaRepository<Lead, Long>, QueryByExampleExecutor<Lead> {
	public Optional<Lead> findById(Long leadId);
	public Optional<Lead> findByFirstNameAndLastNameAndOrganizationNameAndPhoneAndEmailAllIgnoreCase(
							String firstName,
							String lastName,
							String organizationName,
							String phone,
							String email);
	public List<Lead> findByEmailIgnoreCase(String email);
	public <L extends Lead> L save(L lead);
}