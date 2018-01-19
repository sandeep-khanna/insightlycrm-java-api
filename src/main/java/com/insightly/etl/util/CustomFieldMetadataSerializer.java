package com.insightly.etl.util;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.insightly.model.CustomFieldMetadata;

@JsonComponent
public class CustomFieldMetadataSerializer extends JsonSerializer<CustomFieldMetadata> {
	private static final long serialVersionUID = -4887653412816940086L;

	@Override
	public void serialize(CustomFieldMetadata customFieldMetadata, JsonGenerator jacksonGenerator, SerializerProvider provider) throws IOException {
		jacksonGenerator.writeString(customFieldMetadata.getFieldID());
	}
}