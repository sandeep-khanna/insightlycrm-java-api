package com.insightly.etl.util;

import java.io.IOException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.insightly.etl.service.ICustomFieldMetadataService;
import com.insightly.model.CustomFieldMetadata;

@JsonComponent
public class CustomFieldMetadataDeserializer extends JsonDeserializer<CustomFieldMetadata> {	
	private static final long serialVersionUID = -635520247437556459L;
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private ICustomFieldMetadataService customFieldMetadataService;
	
	public CustomFieldMetadataDeserializer() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	@Override
	public CustomFieldMetadata deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
		CustomFieldMetadata customFieldMetadata = null;
		String customFieldID = jsonParser.getText();
        
		try {
			customFieldMetadata = customFieldMetadataService.findOptionalByFieldID(customFieldID)
															.orElseThrow(() -> new IOException(String.format("Unknown CUSTOM_FIELD_ID %s.", customFieldID)));
		} catch (InsightlyApiException ex) {
			logger.error("Unable to look up CUSTOM_FIELD_ID {}", customFieldID);
			ExceptionUtils.rethrow(ex);
		}
		return customFieldMetadata;
	}
}