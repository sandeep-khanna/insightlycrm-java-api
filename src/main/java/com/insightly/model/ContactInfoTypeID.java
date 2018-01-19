package com.insightly.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ContactInfoTypeID {
	UNDEFINED,
	@JsonProperty("PHONE")
	PHONE,
	@JsonProperty("WEBSITE")
	WEBSITE,
	@JsonProperty("EMAILDOMAIN")
	EMAILDOMAIN;
	
	public String value() {
	    JsonProperty jsonPropertyAnnotation = null;
	    
		try {
			jsonPropertyAnnotation = getClass().getField(name()).getAnnotation(JsonProperty.class);
		} catch (NoSuchFieldException e) {
			return name();
		} catch (SecurityException e) {
			return name();
		}
		if (null != jsonPropertyAnnotation 
				&& !jsonPropertyAnnotation.value().equals(JsonProperty.USE_DEFAULT_NAME)) {
	        return jsonPropertyAnnotation.value();
	    } else {
	        return name();
	    }
	}
	
	public static ContactInfoTypeID getTypeID(String value) {
		return Arrays.stream(ContactInfoTypeID.values()).filter(ID -> ID.value().equalsIgnoreCase(value)).findFirst().get();
	}
}