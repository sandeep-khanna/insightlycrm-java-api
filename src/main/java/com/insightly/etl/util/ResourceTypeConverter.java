package com.insightly.etl.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.insightly.etl.IInsightlyCrmDataEtl.ResourceType;

@Component
@ConfigurationPropertiesBinding
public class ResourceTypeConverter implements Converter<String, List<ResourceType>> {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public List<ResourceType> convert(String source) {
		List<ResourceType> resourceTypes = new ArrayList<ResourceType>();
		
		if (StringUtils.isBlank(source)) {
			return resourceTypes;
		}
		try {
			Stream.of(source.split(","))
					.map(resourceType -> resourceType.trim())
					.forEach(resourceType -> {
				resourceTypes.add(ResourceType.valueOf(resourceType));
			});
		} catch (IllegalArgumentException e) {
			logger.error("Unsupported resource types specified. Please review your configuration or environment parameters.");
		}
		return resourceTypes;
	}
}