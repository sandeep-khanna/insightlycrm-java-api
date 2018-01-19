package com.insightly.etl.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.insightly.model.AddressType;
import com.insightly.model.AddressTypeID;

@Component
public class AddressTypeDeserializer extends StdDeserializer<AddressType> {	
	private static final long serialVersionUID = -635520247437556459L;
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public AddressTypeDeserializer() {
		this(null);
	}

	public AddressTypeDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public AddressType deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        String customFieldIDValue = jsonParser.getText();
        AddressTypeID customFieldTypeID = AddressTypeID.getTypeID(customFieldIDValue);
		return AddressType.of(customFieldTypeID);		
	}
}