package com.insightly.etl.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.insightly.model.AddressType;

@Component
public class AddressTypeSerializer extends StdSerializer<AddressType> {
	private static final long serialVersionUID = -4887653412816940086L;
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public AddressTypeSerializer() {
		this(null);
	}

	public AddressTypeSerializer(Class<AddressType> t) {
		super(t);
	}

	@Override
	public void serialize(AddressType value, JsonGenerator jacksonGenerator, SerializerProvider provider) throws IOException {
		jacksonGenerator.writeString(value.getName());
	}
}