package com.insightly.etl;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ExitCodeGenerator;

import com.insightly.etl.service.ICustomFieldMetadataService;
import com.insightly.etl.service.ILeadService;
import com.insightly.etl.service.IOrganisationService;
import com.insightly.etl.util.AppConfig;
import com.insightly.etl.util.InsightlyApiException;

/**
 * Main class to perform Insightly CRM data extraction.
 * 
 * @author Sandeep Khanna
 * @see IInsightlyCrmDataEtl
 */
public abstract class AbstractInsightlyCrmDataEtl implements IInsightlyCrmDataEtl, ExitCodeGenerator {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private enum ExitStatus {
		SUCCESS(0),
		ERROR(1);
		
		int code;
		
		private ExitStatus(int i){
			code=i;
		}
		
		public int getCode(){
			return code;
		}
	}
	private int systemExitCode = ExitStatus.SUCCESS.getCode();

	// Application business logic specific fields
	@Autowired
	protected ICustomFieldMetadataService customFieldMetadataService;
	@Autowired
	@Qualifier("CustomFieldMetadataServiceDatabaseImpl")
	private ICustomFieldMetadataService customFieldMetadataDatabaseImpl;
	@Autowired
	@Qualifier("CustomFieldMetadataServiceRestImpl")
	private ICustomFieldMetadataService customFieldMetadataRestImpl;
	
	@Autowired
	protected ILeadService leadService;
	@Autowired
	@Qualifier("LeadServiceDatabaseImpl")
	protected ILeadService leadServiceDatabaseImpl;
	@Autowired
	@Qualifier("LeadServiceRestImpl")
	protected ILeadService leadServiceRestImpl;

	@Autowired
	protected IOrganisationService organisationService;
	@Autowired
	@Qualifier("OrganisationServiceDatabaseImpl")
	protected IOrganisationService organisationServiceDatabaseImpl;
	@Autowired
	@Qualifier("OrganisationServiceRestImpl")
	protected IOrganisationService organisationServiceRestImpl;
	
	@Autowired
	@Qualifier("InsightlyCrmEtl")
	protected AppConfig appConfig;
	
	@Override
	public int getExitCode() {
		return systemExitCode;
	}
	
	/**
	 * Method to perform initialization as required by a specific ETL extraction engine implementation 
	 */
	protected abstract void init();
	
	/**
	 * Method to perform cleanup as required by a specific ETL extraction engine implementation
	 */
	protected abstract void cleanup();
	
	@Override
	public void start() {
		init();
		
		if(appConfig.isSyncDB()) {
			syncDB();		
		}
		cleanup();
	}
	
	private void syncDB() {
		try {
			StopWatch stopWatch = new StopWatch();
			
			appConfig.getResourceTypes().forEach(resourceType -> {
				logger.info("Synchronizing {} to local database ...", resourceType);
				stopWatch.reset();
				stopWatch.start();
				
				switch(resourceType) {
				
				case CustomFields:
					try {
						customFieldMetadataService.syncDB();
					} catch (InsightlyApiException ex) {
						logger.error("Error refreshing CustomFields");
						logger.error(ex.getCause().getMessage());
						ExceptionUtils.rethrow(ex);
					}
					break;
				
				case Leads:
					try {
						leadService.syncDB();
					} catch (InsightlyApiException ex) {
						logger.error("Error refreshing Leads");
						logger.error(ex.getCause().getMessage());
						ExceptionUtils.rethrow(ex);
					}
					break;
				
				case Organisations:
					try {
						organisationService.syncDB();
					} catch (InsightlyApiException ex) {
						logger.error("Error refreshing Organisations");
						logger.error(ex.getCause().getMessage());
						ExceptionUtils.rethrow(ex);
					}
					break;
				}
				stopWatch.stop();
				logger.info("{} synchronized to local database in {} seconds.", resourceType, stopWatch.getTime()/1000);
			});
		} catch(Exception ex){
			systemExitCode = ExitStatus.ERROR.getCode();
			throw ex;
		}
	}
}