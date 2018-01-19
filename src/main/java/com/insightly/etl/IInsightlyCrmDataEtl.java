package com.insightly.etl;

import java.util.Arrays;

/**
 * 
 * @author Sandeep Khanna
 */
public interface IInsightlyCrmDataEtl {
	
	public enum ApiVersion {
		VERSION_2_1("2.1"),
		VERSION_2_2("2.2"),
		VERSION_2_2_1("2.2_1");
		
		public String version;
		
		private ApiVersion(String version) {
			this.version = version;
		}
		
		public boolean in(ApiVersion... apiVersions) {
			return Arrays.stream(apiVersions).anyMatch(apiVersion -> apiVersion == this);
		}
	}
	
	public enum ResourceType {
		CustomFields("CustomFields"),
		Leads("Leads"),
		Organisations("Organisations");
		
		String resourceType;
		
		private ResourceType(String resourceType) {
			this.resourceType = resourceType;
		}
	}
	/**
	 * Core processing logic
	 */
	public void start();
}