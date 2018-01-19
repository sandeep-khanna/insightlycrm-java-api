package com.insightly.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AddressTypeID {
	UNDEFINED,
	@JsonProperty("POSTAL")
	BILLING_ADDRESS,
	@JsonProperty("PRIMARY")
	SHIPPING_ADDRESS;
	
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
	
	public static AddressTypeID getTypeID(String value) {
		return Arrays.stream(AddressTypeID.values()).filter(ID -> ID.value().equalsIgnoreCase(value)).findFirst().get();
	}
}