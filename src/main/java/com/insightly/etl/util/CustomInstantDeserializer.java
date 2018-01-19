package com.insightly.etl.util;

import java.io.IOException;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

@Component
public class CustomInstantDeserializer extends StdDeserializer<Instant> {
	
	private static final long serialVersionUID = -635520247437556459L;
	private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm:ss")
																			.withZone(java.time.ZoneId.of("UTC"));
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public CustomInstantDeserializer() {
		this(null);
	}

	public CustomInstantDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public Instant deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException {
		
		try {
			return ZonedDateTime.parse(jsonparser.getText(), dateTimeFormatter).toInstant();
		} catch (DateTimeParseException e) {
			logger.error("Unable to parse the supplied date/time string. Please review the date/time format in the JSON file.");
			return Instant.now();
		}
	}
}