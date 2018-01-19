package com.insightly.etl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class InstantTimeConverter implements Converter<String, Instant> {

	private final SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("M/d/yyyy h:mm:ss a");
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public Instant convert(String source) {
		
		if (source == null) {
			return null;
		}
		try {
			return simpleDateFormat.parse(source).toInstant();
		} catch (ParseException e) {
			logger.error("Unable to parse the supplied date/time string. Please review your configuration or environment parameters.");
			return Instant.now();
		}
	}
}