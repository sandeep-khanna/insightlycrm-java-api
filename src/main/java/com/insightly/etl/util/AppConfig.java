package com.insightly.etl.util;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.SpringHandlerInstantiator;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.insightly.etl.IInsightlyCrmDataEtl.ApiVersion;
import com.insightly.etl.IInsightlyCrmDataEtl.ResourceType;

import lombok.Data;

/**
 * 
 * 
 * @author Sandeep Khanna
 */
@Data
@Configuration("InsightlyCrmEtl")
@ComponentScan("com.insightly")
@EnableTransactionManagement
@EnableCaching
@EnableJpaRepositories(
        entityManagerFactoryRef = "InsightlyCrmEtlEntityManagerFactory", 
        transactionManagerRef = "InsightlyCrmEtlTransactionManager",
        basePackages = { "com.insightly" })
@PropertySources({
	@PropertySource(value="classpath:insightlycrmetl.properties"),
	@PropertySource(value="file:./config/insightlycrmetl.properties", ignoreResourceNotFound=true),
	@PropertySource(value="file:./insightlycrmetl.properties", ignoreResourceNotFound=true),
	@PropertySource(value="classpath:config/insightlycrmetl.properties", ignoreResourceNotFound=true),
	@PropertySource(value="classpath:insightlycrmetl.properties", ignoreResourceNotFound=true)
})
@ConfigurationProperties
public class AppConfig extends CachingConfigurerSupport {
	private Logger logger = LoggerFactory.getLogger(getClass().getName());
	private ApiVersion apiVersion = ApiVersion.VERSION_2_2;
	public String repository = "RemoteAPI";
	private boolean syncDB = false;
	private boolean recreateDatabase = false;
	private boolean showSql = false;
	private boolean showSqlFormatted = false;
	private boolean showSqlComments = false;
	private boolean showSqlParameterValues = false;
	private String databaseDialect = null;
	private String databaseUrl = null;
	private String databaseDriverClassName = null;
	private String databaseUsername = null;
	private String databasePassword = null;
	private String apiKey = null;
	private List<ResourceType> resourceTypes = null;
	private int resourceCount = 500;
	private Instant updatedAfterUtc = null; //Date format is M/d/yyyy h:mm:ss AM/PM. For example, 11/7/2015 8:07:05 AM

	@Autowired
	LoggingSystem loggingSystem;

	@Autowired	
	AppConfig(Environment environment) {
		((org.springframework.core.env.AbstractEnvironment)environment).getPropertySources().forEach(propertySource -> {

			if(propertySource.getName().contains("insightlycrmetl")) {

				if(StringUtils.isBlank(databaseDialect)) 
					setDatabaseDialect((String)propertySource.getProperty("database.dialect"));
				
				if(StringUtils.isBlank(databaseUrl)) 
					setDatabaseUrl((String)propertySource.getProperty("database.url"));
				
				if(StringUtils.isBlank(databaseDriverClassName)) 
					setDatabaseDriverClassName((String)propertySource.getProperty("database.driver-class-name"));
				
				if(StringUtils.isBlank(databaseUsername)) 
					setDatabaseUsername((String)propertySource.getProperty("database.username"));
				
				if(StringUtils.isBlank(databasePassword)) 
					setDatabasePassword((String)propertySource.getProperty("database.password"));
			}
		});
	}
	
	@Bean(name = "InsightlyCrmEtlDataSource")
//	@ConfigurationProperties(prefix="datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create()
								.driverClassName(getDatabaseDriverClassName())
								.url(getDatabaseUrl())
								.username(getDatabaseUsername())
								.password(getDatabasePassword())
								.build();
	}
	
    @Bean(name = "InsightlyCrmEtlEntityManagerFactory")
    @Autowired
    @DependsOn({"InsightlyCrmEtlDataSource"})
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder emfb) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] {"com.insightly"});
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(hibernateProperties());
        return em;
    }
	
    private Properties hibernateProperties() {
		Properties properties = new Properties();
		
		if(StringUtils.isNotEmpty(getDatabaseDialect())) {
			properties.put("hibernate.dialect", getDatabaseDialect());
		}
		
		if(isRecreateDatabase()) {
			properties.put("hibernate.hbm2ddl.auto", "create");
		} else {
			properties.put("hibernate.hbm2ddl.auto", "update");
		}
		
		if(isShowSql()) {
			loggingSystem.setLogLevel("org.hibernate.SQL", LogLevel.DEBUG);
			
			if(isShowSqlFormatted()) {
				properties.put("hibernate.format_sql", true);
			}
			
			if(isShowSqlParameterValues()) {
				loggingSystem.setLogLevel("org.hibernate.type.descriptor.sql", LogLevel.TRACE);
			}
			
			if(isShowSqlComments()) {
				properties.put("hibernate.use_sql_comments", true);
			}			
		}
		return properties;
	}
    
    @Bean(name = "InsightlyCrmEtlTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("InsightlyCrmEtlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
	
	@Bean
	@Primary
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder, MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter){        
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(mappingJackson2HttpMessageConverter);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        messageConverters.add(new MappingJackson2XmlHttpMessageConverter(xmlMapper));
	    RestTemplate restTemplate = restTemplateBuilder.requestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
	                                                .messageConverters(messageConverters)
	                                                .build();
	    return restTemplate;
	}
	
    @Bean
    @Autowired
    public HandlerInstantiator handlerInstantiator(ApplicationContext applicationContext) {
        return new SpringHandlerInstantiator(applicationContext.getAutowireCapableBeanFactory());
    }

    @Bean
    public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder(HandlerInstantiator handlerInstantiator) {
        Jackson2ObjectMapperBuilder result = new Jackson2ObjectMapperBuilder();
        result.handlerInstantiator(handlerInstantiator);
        return result;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(Jackson2ObjectMapperBuilder objectMapperBuilder) {
        return new MappingJackson2HttpMessageConverter(objectMapperBuilder.build());
    }

    @Bean
    @Override
    public CacheManager cacheManager() {
    	SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("insightlyCustomFieldMetadataCache"),
        									new ConcurrentMapCache("insightlyLeadsCache"),
        									new ConcurrentMapCache("insightlyOrganisationsCache")));
        return cacheManager;
    }
    
    @Bean
    @Override
    public KeyGenerator keyGenerator() {
    	return new SimpleKeyGenerator();
    }
    
    public String toString() {
    	StringBuilder stringBuilder = new StringBuilder();
    	stringBuilder.append("*********** Insightly CRM ETL Application Configuration ***********").append(System.lineSeparator());
    	stringBuilder.append("apiVersion: ").append(apiVersion.version).append(System.lineSeparator());
    	stringBuilder.append("repository: ").append(repository).append(System.lineSeparator());
    	stringBuilder.append("recreateDatabase: ").append(recreateDatabase).append(System.lineSeparator());
    	stringBuilder.append("databaseDialect: ").append(databaseDialect).append(System.lineSeparator());
    	stringBuilder.append("databaseUrl: ").append(databaseUrl).append(System.lineSeparator());
    	stringBuilder.append("databaseDriverClassName: ").append(databaseDriverClassName).append(System.lineSeparator());
    	stringBuilder.append("databaseUsername: ").append(databaseUsername).append(System.lineSeparator());
    	stringBuilder.append("resourceTypes: ").append(resourceTypes).append(System.lineSeparator());
    	stringBuilder.append("resourceCount: ").append(resourceCount).append(System.lineSeparator());
    	stringBuilder.append("updatedAfterUtc: ").append(updatedAfterUtc).append(System.lineSeparator());
    	stringBuilder.append("*******************************************************************").append(System.lineSeparator());
    	return stringBuilder.toString();
    }

}