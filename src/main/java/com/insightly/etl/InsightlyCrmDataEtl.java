package com.insightly.etl;

import java.lang.management.ManagementFactory;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.Banner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.insightly.etl.util.AppConfig;

/**
 * Main class to perform Vertex CRM data extraction.
 * 
 * @author Sandeep Khanna
 */
@SpringBootApplication(scanBasePackages = "com.insightly")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@EntityScan(basePackages = "com.insightly")
@EnableTransactionManagement
public class InsightlyCrmDataEtl implements ExitCodeGenerator {
	public static final String BLANK_STRING = " ";
	private static Logger logger;
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
	private static int systemExitCode = ExitStatus.SUCCESS.getCode();
	
	@Autowired
	@Qualifier("InsightlyCrmEtl")
	private static AppConfig appConfig;
	
	static {
		logger = LoggerFactory.getLogger(InsightlyCrmDataEtl.class.getName());
	}
	
	@Autowired
	public InsightlyCrmDataEtl(ApplicationContext applicationContext, @Qualifier("InsightlyCrmEtl") AppConfig appConfig){
		InsightlyCrmDataEtl.appConfig = appConfig;
	}
	
	/**
	 * Entry point for this Java program
	 * 
	 * Currently the command-line arguments are not used. Instead a 
	 * config.properties properties file is used.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MDC.put("process_id", ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
//		ConfigurableApplicationContext applicationContext = SpringApplication.run(InsightlyCrmDataEtl.class, args);
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder()
															    .bannerMode(Banner.Mode.OFF)
															    .web(false)
															    .sources(InsightlyCrmDataEtl.class)
															    .properties("spring.application.name:insightlycrmetl")
															    .properties("spring.config.name:insightlycrmetl")
															    .run(args);
		logger.info("Starting Insightly CRM data extraction...");
		logger.info(System.lineSeparator() + appConfig);
		StopWatch stopWatch = new StopWatch();
	
		try{
			stopWatch.start();
			IInsightlyCrmDataEtl etl = applicationContext.getBean(IInsightlyCrmDataEtl.class);
			etl.start();
			stopWatch.stop();
			logger.info("Data extraction completed successfully in {} minutes({} seconds)", ((stopWatch.getTime()/1000)/60), stopWatch.getTime()/1000);
		} catch(Exception ex) {
			stopWatch.stop();
			logger.error("Error occurred during data extraction: {}", ex.getMessage());
			logger.error("Data extraction failed to complete successfully. And took {} minutes({} seconds)", ((stopWatch.getTime()/1000)/60), stopWatch.getTime()/1000);
			logger.error("##### Listed below is the program stack trace for further debugging purpose #####");
			logger.error(ExceptionUtils.getStackTrace(ex));
			systemExitCode = ExitStatus.ERROR.getCode();
		} finally {
			System.exit(SpringApplication.exit(applicationContext));
		}
	}

	@Override
	public int getExitCode() {
		return systemExitCode;
	}	
}