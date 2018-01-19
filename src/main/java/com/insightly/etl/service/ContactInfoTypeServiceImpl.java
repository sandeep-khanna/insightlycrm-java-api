package com.insightly.etl.service;

import java.util.Arrays;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insightly.etl.dao.IContactInfoTypeRepository;
import com.insightly.model.ContactInfoType;
import com.insightly.model.ContactInfoTypeID;

/**
 * 
 * 
 * @author Sandeep Khanna
 */
@Service
@Transactional("InsightlyCrmEtlTransactionManager")
public class ContactInfoTypeServiceImpl implements IContactInfoTypeService {
	private Logger logger = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	public ContactInfoTypeServiceImpl(IContactInfoTypeRepository contactInfoTypeRepository) {
		
		Arrays.stream(ContactInfoTypeID.values()).forEach(ID -> {
			Optional<ContactInfoType> contactInfoType = contactInfoTypeRepository.findOptionalByName(ID.value());
			
			if(!contactInfoType.isPresent()) {
				contactInfoType = Optional.of(ContactInfoType.of(ID));
				logger.trace("Saving new ContactInfoType: {}", contactInfoType.get());
				contactInfoTypeRepository.save(contactInfoType.get());
			}
		});
	}
}