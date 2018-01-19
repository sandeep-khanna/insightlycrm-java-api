package com.insightly.etl.service;

import java.util.Arrays;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insightly.etl.dao.IAddressTypeRepository;
import com.insightly.model.AddressType;
import com.insightly.model.AddressTypeID;

/**
 * 
 * 
 * @author Sandeep Khanna
 */
@Service
@Transactional("InsightlyCrmEtlTransactionManager")
public class AddressTypeServiceImpl implements IAddressTypeService {
	private Logger logger = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	public AddressTypeServiceImpl(IAddressTypeRepository addressTypeRepository) {
		
		Arrays.stream(AddressTypeID.values()).forEach(ID -> {
			Optional<AddressType> addressType = addressTypeRepository.findOptionalByName(ID.value());
			
			if(!addressType.isPresent()) {
				addressType = Optional.of(AddressType.of(ID));
				logger.trace("Saving new AddressType: {}", addressType.get());
				addressTypeRepository.save(addressType.get());
			}
		});
	}
}