package com.insightly.etl.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.insightly.model.ContactInfoType;
import com.insightly.model.ContactInfoTypeID;

@Component
public class ContactInfoTypeDeserializer extends StdDeserializer<ContactInfoType> {	
	private static final long serialVersionUID = -635520247437556459L;
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public ContactInfoTypeDeserializer() {
		this(null);
	}

	public ContactInfoTypeDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public ContactInfoType deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        String customFieldIDValue = jsonParser.getText();
        ContactInfoTypeID customFieldTypeID = ContactInfoTypeID.getTypeID(customFieldIDValue);
		return ContactInfoType.of(customFieldTypeID);		
	}
}