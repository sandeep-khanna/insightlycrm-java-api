package com.insightly.etl.util;

/**
 * Thrown when a user for given userId does not exist.
 * 
 * @author Sandeep Khanna
 */
public class InsightlyApiException extends Exception {
	private static final long serialVersionUID = 1L;

	public InsightlyApiException(String message) {
		super(message);
	}
	
	public InsightlyApiException(Throwable cause) {
        super(cause);
	}
	
	public InsightlyApiException(String message, Throwable cause) {
        super(message, cause);
	}
}
