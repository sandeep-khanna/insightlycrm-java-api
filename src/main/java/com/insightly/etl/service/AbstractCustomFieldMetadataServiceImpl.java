package com.insightly.etl.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.insightly.etl.util.AppConfig;
import com.insightly.etl.util.InsightlyApiException;
import com.insightly.model.CustomFieldMetadata;

public abstract class AbstractCustomFieldMetadataServiceImpl implements ICustomFieldMetadataService {

	protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	public AppConfig appConfig;
	
	protected <T> Stream<T> getStream(List<T> list) {
	    return Optional.ofNullable(list).map(List::stream).orElseGet(Stream::empty);
	}
	
	@Override
	public <T extends CustomFieldMetadata> T save(T customFieldMetadata) {
		 throw new NotImplementedException(getClass() + " does not implement " + new Object() {}
																				      .getClass()
																				      .getEnclosingMethod()
																				      .getName());
	}

	@Override
	public void save(List<CustomFieldMetadata> customFieldMetadata) {
		 throw new NotImplementedException(getClass() + " does not implement " + new Object() {}
																				      .getClass()
																				      .getEnclosingMethod()
																				      .getName());
	}
	
	@Override
	public void syncDB() throws InsightlyApiException {
		 throw new NotImplementedException(getClass() + " does not implement " + new Object() {}
																				      .getClass()
																				      .getEnclosingMethod()
																				      .getName());
	}
}