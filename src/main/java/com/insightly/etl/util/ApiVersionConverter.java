package com.insightly.etl.util;

import java.util.EnumSet;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.insightly.etl.IInsightlyCrmDataEtl.ApiVersion;

@Component
@ConfigurationPropertiesBinding
public class ApiVersionConverter implements Converter<String, ApiVersion> {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public ApiVersion convert(String source) {
		ApiVersion apiVersion = ApiVersion.VERSION_2_2;
		
		if(StringUtils.isNotBlank(source)) {
			apiVersion = EnumSet.allOf(ApiVersion.class)
								.stream()
								.filter(e -> e.version.equals(source))
								.findFirst()
								.orElseThrow(() -> new UnsupportedOperationException(String.format("Unsupported version %s.", source)));
		}
		return apiVersion;
	}
}