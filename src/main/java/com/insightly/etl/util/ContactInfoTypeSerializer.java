package com.insightly.etl.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.insightly.model.ContactInfoType;

@Component
public class ContactInfoTypeSerializer extends StdSerializer<ContactInfoType> {
	private static final long serialVersionUID = -4887653412816940086L;
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public ContactInfoTypeSerializer() {
		this(null);
	}

	public ContactInfoTypeSerializer(Class<ContactInfoType> t) {
		super(t);
	}

	@Override
	public void serialize(ContactInfoType value, JsonGenerator jacksonGenerator, SerializerProvider provider) throws IOException {
		jacksonGenerator.writeString(value.getName());
	}
}