package com.insightly.api;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import com.insightly.api.util.ApiClient;
import com.insightly.etl.IInsightlyCrmDataEtl.ApiVersion;
import com.insightly.model.ActivitySetAssignment;
import com.insightly.model.CalendarEvent;
import com.insightly.model.CustomField;
import com.insightly.model.Email;
import com.insightly.model.FileAttachment;
import com.insightly.model.Follow;
import com.insightly.model.Lead;
import com.insightly.model.LinkEmailAddress;
import com.insightly.model.Note;
import com.insightly.model.Tag;
import com.insightly.model.Task;

@Component
public class LeadsApi {
	
	@Autowired
    private ApiClient apiClient;

    public LeadsApi() {
        this(new ApiClient());
    }

    @Autowired
    public LeadsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Adds an Activity Set to a Lead
     * 
     * <p><b>201</b> - Activity Set assigned.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead, Activity Set or Activities not found.
     * @param id A Lead&#39;s ID
     * @param activitySetAssignment The Activity Set Assignment object which contains the configuration information for the Activity Set
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void addActivitySetAssignment(Long id, ActivitySetAssignment activitySetAssignment) throws RestClientException {
        Object postBody = activitySetAssignment;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling addActivitySetAssignment");
        }
        
        // verify the required parameter 'activitySetAssignment' is set
        if (activitySetAssignment == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'activitySetAssignment' when calling addActivitySetAssignment");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}/ActivitySetAssignment").buildAndExpand(uriVariables).toUriString();
        }

        final String[] accepts = { 
            "application/json", "text/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Adds a File Attachment to a Lead
     * This endpoint expects multipart/form-data as the request payload. See Stack Overflow for examples of how to generate multipart requests, or see our &lt;a href&#x3D;\&quot;http://github.com/Insightly\&quot; target&#x3D;\&quot;_blank\&quot;&gt;client libraries&lt;/a&gt; for an example of how this is generated. Only one file can be added per request.
     * <p><b>201</b> - File Attachment added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>402</b> - Record or storage limit reached.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead not found.
     * <p><b>417</b> - File Attachment insert failed.
     * @param id A Lead&#39;s ID (LEAD_ID)
     * @param file The file part of the multipart/form-data request. Only one file can be added per request.
     * @param fileName The fileName parameter
     * @param contentType The contentType parameter
     * @param fileCategoryId The fileCategoryId parameter
     * @return FileAttachment
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public FileAttachment addFileAttachment(Long id, String file, String fileName, String contentType, Integer fileCategoryId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling addFileAttachment");
        }
        
        // verify the required parameter 'file' is set
        if (file == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'file' when calling addFileAttachment");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(apiVersion.in(ApiVersion.VERSION_2_1, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.1/Leads/{id}/FileAttachments").buildAndExpand(uriVariables).toUriString();
        	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filename", fileName));
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}/FileAttachments").buildAndExpand(uriVariables).toUriString();
        }
        
        if (file != null)
            formParams.add("file", new FileSystemResource(file));
        if (fileName != null)
            formParams.add("file_name", fileName);
        if (contentType != null)
            formParams.add("content_type", contentType);
        if (fileCategoryId != null)
            formParams.add("file_category_id", fileCategoryId);

        final String[] accepts = { 
            "application/json", "text/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "multipart/form-data"
        };
        final MediaType mediaType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<FileAttachment> returnType = new ParameterizedTypeReference<FileAttachment>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, mediaType, authNames, returnType);
    }
    /**
     * Start following a Lead
     * 
     * <p><b>201</b> - Follow added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead not found.
     * @param id A Lead&#39;s ID (LEAD_ID)
     * @return Follow
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Follow addFollow(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling addFollow");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}/Follow").buildAndExpand(uriVariables).toUriString();
        }

        final String[] accepts = { 
            "application/json", "text/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<Follow> returnType = new ParameterizedTypeReference<Follow>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Adds a Lead
     * A common source of problems when creating leads occurs when users omit required fields, or insert             invalid data into a field. A good troubleshooting technique             is to create a few leads via the web interface, with representative data, links, etc, and then access             these leads via the API, and inspect the returned object graph.
     * <p><b>201</b> - Lead added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>402</b> - Record limit reached.
     * <p><b>403</b> - Lead Management disabled.
     * @param lead The Lead to add (just include JSON object as request body)
     * @return Lead
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Lead addLead(Lead lead) throws RestClientException {
        Object postBody = lead;
        
        // verify the required parameter 'lead' is set
        if (lead == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lead' when calling addLead");
        }
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(apiVersion.in(ApiVersion.VERSION_2_1, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.1/Leads").build().toUriString();
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads").build().toUriString();
        }

        final String[] accepts = { 
            "application/json", "text/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<Lead> returnType = new ParameterizedTypeReference<Lead>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Adds a Note to a Lead.
     * 
     * <p><b>201</b> - Note added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>402</b> - Record limit reached.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead not found.
     * @param id A Lead&#39;s ID (LEAD_ID)
     * @param note The Note to add (just include JSON object as request body)
     * @return Note
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Note addNote(Long id, Note note) throws RestClientException {
        Object postBody = note;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling addNote");
        }
        
        // verify the required parameter 'note' is set
        if (note == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'note' when calling addNote");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(apiVersion.in(ApiVersion.VERSION_2_1, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.1/Leads/{id}/Notes").build().toUriString();
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}/Notes").buildAndExpand(uriVariables).toUriString();
        }

        final String[] accepts = { 
            "application/json", "text/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<Note> returnType = new ParameterizedTypeReference<Note>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Adds a Tag for a Lead
     * 
     * <p><b>201</b> - Tag added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead not found.
     * @param id A Lead&#39;s ID (LEAD_ID)
     * @param tag The Tag to add (just include the JSON object in request body.
     * @return Tag
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Tag addTag(Long id, Tag tag) throws RestClientException {
        Object postBody = tag;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling addTag");
        }
        
        // verify the required parameter 'tag' is set
        if (tag == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'tag' when calling addTag");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}/Tags").buildAndExpand(uriVariables).toUriString();
        }
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "text/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<Tag> returnType = new ParameterizedTypeReference<Tag>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Deletes a Custom Field
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead or Custom Field not found.
     * <p><b>417</b> - Delete failed.
     * @param id A Lead&#39;s ID (LEAD_ID)
     * @param customFieldId A Custom Field&#39;s ID (CUSTOM_FIELD_ID)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteCustomField(Long id, String customFieldId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteCustomField");
        }
        
        // verify the required parameter 'customFieldId' is set
        if (customFieldId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'customFieldId' when calling deleteCustomField");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("customFieldId", customFieldId);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}/CustomFields/{customFieldId}").buildAndExpand(uriVariables).toUriString();
        }

        final String[] accepts = { 
            "application/json", "text/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Stop following a Lead
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead not found.
     * <p><b>417</b> - Delete failed.
     * @param id A Lead&#39;s ID (LEAD_ID)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteFollow(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteFollow");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}/Follow").buildAndExpand(uriVariables).toUriString();
        }

        final String[] accepts = { 
            "application/json", "text/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Deletes a Lead&#39;s Image
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead not found.
     * <p><b>417</b> - Delete failed.
     * @param id A Lead&#39;s ID (LEAD_ID)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteImage(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteImage");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(apiVersion.in(ApiVersion.VERSION_2_1, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.1/Leads/{id}/Image").buildAndExpand(uriVariables).toUriString();
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}/Image").buildAndExpand(uriVariables).toUriString();
        }

        final String[] accepts = { 
            "application/json", "text/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Deletes a Lead
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead not found.
     * <p><b>417</b> - Delete failed.
     * @param id A Lead&#39;s ID
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteLead(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteLead");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(apiVersion.in(ApiVersion.VERSION_2_1, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.1/Leads/{id}").buildAndExpand(uriVariables).toUriString();
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}").buildAndExpand(uriVariables).toUriString();
        }

        final String[] accepts = { 
            "application/json", "text/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Deletes a Tag from a Lead
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead or Tag not found.
     * <p><b>417</b> - Delete failed.
     * @param id A Lead&#39;s ID (LEAD_ID)
     * @param tagName A Tag&#39;s name
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteTag(Long id, String tagName) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteTag");
        }
        
        // verify the required parameter 'tagName' is set
        if (tagName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'tagName' when calling deleteTag");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("tagName", tagName); 
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}/Tags/{tagName}").buildAndExpand(uriVariables).toUriString();
        }

        final String[] accepts = { 
            "application/json", "text/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a list of Lead&#39;s Emails
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead not found.
     * @param id A Lead&#39;s ID
     * @param updatedAfterUtc Optional, earliest date when email was last updated.
     * @param top Optional, maximum number of emails to return.
     * @param skip Optional, number of emails to skip.
     * @param brief true if only top level properties needs to be returned.
     * @param countTotal true if total number of records should be returned in the response headers.
     * @return List&lt;Email&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Email> getEmails(Long id, OffsetDateTime updatedAfterUtc, Integer top, Integer skip, Boolean brief, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getEmails");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(apiVersion.in(ApiVersion.VERSION_2_1, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.1/Leads/{id}/Emails").buildAndExpand(uriVariables).toUriString();
        	 
        	/* Including the 'Brief' query string parameter seems to be touchy, 
        	 * especially when used with the OData filters.
        	 * 
        	 * queryParams.putAll(apiClient.parameterToMultiValueMap(null, "Brief", brief));
        	 */
            
        	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$skip", skip));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$top", top));
            
            String filter = null;
            
            if(null != updatedAfterUtc) {
	            filter = "DATE_UPDATED_UTC gt DateTime'" + updatedAfterUtc + "'";
	            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", filter));
            }
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}/Emails").buildAndExpand(uriVariables).toUriString();
        	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "updated_after_utc", updatedAfterUtc));
			queryParams.putAll(apiClient.parameterToMultiValueMap(null, "top", top));
			queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip", skip));
			queryParams.putAll(apiClient.parameterToMultiValueMap(null, "brief", brief));
			queryParams.putAll(apiClient.parameterToMultiValueMap(null, "count_total", countTotal));
        }
        


        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<List<Email>> returnType = new ParameterizedTypeReference<List<Email>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a Lead&#39;s Events
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead not found.
     * @param id A Lead&#39;s ID (LEAD_ID)
     * @param updatedAfterUtc Optional, earliest date when event was last updated.
     * @param top Optional, maximum number of events to return.
     * @param skip Optional, number of events to skip.
     * @param brief true if only top level properties needs to be returned.
     * @param countTotal true if total number of records should be returned in the response headers.
     * @return List&lt;CalendarEvent&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<CalendarEvent> getEvents(Long id, OffsetDateTime updatedAfterUtc, Integer top, Integer skip, Boolean brief, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getEvents");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}/Events").buildAndExpand(uriVariables).toUriString();
        	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "updated_after_utc", updatedAfterUtc));
	        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "top", top));
	        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip", skip));
	        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "brief", brief));
	        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "count_total", countTotal));
        }
        
        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<List<CalendarEvent>> returnType = new ParameterizedTypeReference<List<CalendarEvent>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a Lead&#39;s File Attachments
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead not found.
     * @param id A Lead&#39;s ID (LEAD_ID)
     * @param updatedAfterUtc Optional, earliest date when file attachment was last updated.
     * @param skip Optional, number of file attachments to skip.
     * @param top Optional, maximum number of file attachments to return in the response.
     * @param countTotal true if total number of records should be returned in the response headers.
     * @return List&lt;FileAttachment&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<FileAttachment> getFileAttachments(Long id, OffsetDateTime updatedAfterUtc, Integer skip, Integer top, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getFileAttachments");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}/FileAttachments").buildAndExpand(uriVariables).toUriString();
        	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "updated_after_utc", updatedAfterUtc));
	        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "top", top));
	        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip", skip));
	        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "count_total", countTotal));
        }

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<List<FileAttachment>> returnType = new ParameterizedTypeReference<List<FileAttachment>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a Follow record for the Lead
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead not found.
     * @param id A Lead&#39;s ID (LEAD_ID)
     * @return Follow
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Follow getFollow(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getFollow");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}/Follow").buildAndExpand(uriVariables).toUriString();
        }

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<Follow> returnType = new ParameterizedTypeReference<Follow>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a Lead&#39;s Image
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead not found.
     * @param id A Lead&#39;s ID (LEAD_ID)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void getImage(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getImage");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(apiVersion.in(ApiVersion.VERSION_2_1, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.1/Leads/{id}/Image").buildAndExpand(uriVariables).toUriString();
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}/Image").buildAndExpand(uriVariables).toUriString();
        }

        final String[] accepts = { 
            "application/octet-stream"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a Lead
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead not found.
     * @param id A Lead&#39;s ID
     * @return Lead
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Lead getLead(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getLead");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(apiVersion.in(ApiVersion.VERSION_2_1, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.1/Leads/{id}").buildAndExpand(uriVariables).toUriString();
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}").buildAndExpand(uriVariables).toUriString();
        }

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<Lead> returnType = new ParameterizedTypeReference<Lead>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a list of Leads.
     * Simple object graphs (excluding Custom Fields, Tags, etc.) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - Lead Management disabled.
     * @param includeConverted Optional, by default converted leads are not included, pass in \&quot;true\&quot; to include them in the response
     * @param brief Optional, true if response should only contain top level properties of the lead.
     * @param skip Optional, number of lead to skip.
     * @param top Optional, maximum number of lead to return in the response.
     * @param countTotal Optional, true if total number of records should be returned in the response headers.
     * @return List&lt;Lead&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Lead> getLeads(Boolean includeConverted, Boolean brief, Integer skip, Integer top, Boolean countTotal) throws RestClientException {
    	return getLeadsBySearch(null, null, null, null, null, null, null, null, null, null, null, includeConverted, brief, skip, top, countTotal);
    }
    /**
     * Gets a filtered list of Leads.
     * Only one optional parameter (excluding include_converted, top, skip and count_total) can be specified. Simple object graphs (excluding Custom Fields, Tags, etc.) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - Lead Management disabled.
     * @param email Optional, email address.
     * @param tag Optional, a single tag.
     * @param phoneNumber Optional, phone number.
     * @param firstName Optional, first name of the contact.
     * @param lastName Optional, last name of the contact.
     * @param city Optional, name of the city from lead address.
     * @param state Optional, state from the lead address.
     * @param postcode Optional, postal code from the lead address.
     * @param country Optional, name of the country from lead address.
     * @param organisation Optional, name of the default organisation.
     * @param updatedAfterUtc Optional, earliest date when lead was last updated.
     * @param includeConverted Optional, by default converted leads are not included, pass in \&quot;true\&quot; to include them in the response
     * @param brief Optional, true if response should only contain top level properties of the lead.
     * @param skip Optional, number of lead to skip.
     * @param top Optional, maximum number of lead to return in the response.
     * @param countTotal Optional, true if total number of records should be returned in the response headers.
     * @return List&lt;Lead&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Lead> getLeadsBySearch(String email, String tag, String phoneNumber, String firstName, String lastName, String city, String state, String postcode, String country, String organisation, Instant updatedAfterUtc, Boolean includeConverted, Boolean brief, Integer skip, Integer top, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        String path = null;
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        
        if(apiVersion.in(ApiVersion.VERSION_2_1, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.1/Leads").build().toUriString();
        	
        	/* Including the 'Brief' query string parameter seems to be touchy, 
        	 * especially when used with the OData filters.
        	 * 
        	 * queryParams.putAll(apiClient.parameterToMultiValueMap(null, "Brief", brief));
        	 */
            
        	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$skip", skip));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$top", top));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "email", email));            
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "includeConverted", includeConverted));
            
            String filter = null;
            
            if(StringUtils.isNotBlank(organisation)) {
            	filter = "ORGANIZATION_NAME eq " + organisation;
            	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", filter));
            }
            
            if(StringUtils.isNotBlank(phoneNumber)) {
            	filter = "PHONE_NUMBER eq " + phoneNumber;
            	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", filter));
            }
            
            if(StringUtils.isNotBlank(firstName)) {
            	filter = "FIRST_NAME eq " + firstName;
            	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", filter));
            }
            
            if(StringUtils.isNotBlank(lastName)) {
            	filter = "LAST_NAME eq " + lastName;
            	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", filter));
            }
            
            if(StringUtils.isNotBlank(city)) {
            	filter = "ADDRESS_CITY eq " + city;
            	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", filter));
            }
            
            if(StringUtils.isNotBlank(state)) {
            	filter = "ADDRESS_STATE eq " + state;
            	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", filter));
            }
            
            if(StringUtils.isNotBlank(postcode)) {
            	filter = "ADDRESS_POSTCODE eq " + postcode;
            	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", filter));
            }
            
            if(StringUtils.isNotBlank(country)) {
            	filter = "ADDRESS_COUNTRY eq " + country;
            	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", filter));
            }
            
            if(null != updatedAfterUtc) {
	            filter = "DATE_UPDATED_UTC gt DateTime'" + updatedAfterUtc + "'";
	            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", filter));
            }
        	
        	/* v2.1 supports filtering by and ordering only for fields that are *directly* on the object
             * Unfortunately, you cannot do the following:
             *  filter by a CustomField component (CUSTOM_FIELD_ID, FIELD_VALUE) in the CUSTOMFIELDS collection
             *  
             *  queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tag", tag));
             */
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/Search").build().toUriString();
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "email", email));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tag", tag));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "phone_number", phoneNumber));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "first_name", firstName));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "last_name", lastName));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "city", city));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "state", state));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "postcode", postcode));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "country", country));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "organisation", organisation));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "updated_after_utc", updatedAfterUtc));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include_converted", includeConverted));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "brief", brief));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip", skip));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "top", top));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "count_total", countTotal));	
        }

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<List<Lead>> returnType = new ParameterizedTypeReference<List<Lead>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets the email address to use for linking with the Lead
     * An email address to use as a maildrop for the Lead.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Lead.
     * <p><b>404</b> - Lead not found.
     * @param id A Lead&#39;s ID
     * @return LinkEmailAddress
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public LinkEmailAddress getLinkEmailAddress(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getLinkEmailAddress");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}/LinkEmailAddress").buildAndExpand(uriVariables).toUriString();
        }

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<LinkEmailAddress> returnType = new ParameterizedTypeReference<LinkEmailAddress>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a Lead&#39;s Notes
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead not found.
     * @param id A Lead&#39;s ID (LEAD_ID)
     * @param updatedAfterUtc Optional, earliest date when note was last updated.
     * @param top Optional, maximum number of notes to return.
     * @param skip Optional, number of notes to skip.
     * @param brief true if only top level properties needs to be returned.
     * @param countTotal true if total number of records should be returned in the response headers.
     * @return List&lt;Note&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Note> getNotes(Long id, OffsetDateTime updatedAfterUtc, Integer top, Integer skip, Boolean brief, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getNotes");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(apiVersion.in(ApiVersion.VERSION_2_1, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.1/Leads/{id}/Notes").buildAndExpand(uriVariables).toUriString();
        	 
        	/* Including the 'Brief' query string parameter seems to be touchy, 
        	 * especially when used with the OData filters.
        	 * 
        	 * queryParams.putAll(apiClient.parameterToMultiValueMap(null, "Brief", brief));
        	 */
            
        	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$skip", skip));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$top", top));
            
            String filter = null;
            
            if(null != updatedAfterUtc) {
	            filter = "DATE_UPDATED_UTC gt DateTime'" + updatedAfterUtc + "'";
	            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", filter));
            }
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}/Notes").buildAndExpand(uriVariables).toUriString();
        	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "updated_after_utc", updatedAfterUtc));
			queryParams.putAll(apiClient.parameterToMultiValueMap(null, "top", top));
			queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip", skip));
			queryParams.putAll(apiClient.parameterToMultiValueMap(null, "brief", brief));
			queryParams.putAll(apiClient.parameterToMultiValueMap(null, "count_total", countTotal));
        }

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<List<Note>> returnType = new ParameterizedTypeReference<List<Note>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a list of Lead&#39;s Tasks
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead not found.
     * @param id A Lead&#39;s ID
     * @param updatedAfterUtc Optional, earliest date when task was last updated.
     * @param top Optional, maximum number of tasks to return.
     * @param skip Optional, number of tasks to skip.
     * @param brief true if only top level properties needs to be returned.
     * @param countTotal true if total number of records should be returned in the response headers.
     * @return List&lt;Task&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Task> getTasks(Long id, OffsetDateTime updatedAfterUtc, Integer top, Integer skip, Boolean brief, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getTasks");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(apiVersion.in(ApiVersion.VERSION_2_1, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.1/Leads/{id}/Tasks").buildAndExpand(uriVariables).toUriString();
        	 
        	/* Including the 'Brief' query string parameter seems to be touchy, 
        	 * especially when used with the OData filters.
        	 * 
        	 * queryParams.putAll(apiClient.parameterToMultiValueMap(null, "Brief", brief));
        	 */
            
        	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$skip", skip));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$top", top));
            
            String filter = null;
            
            if(null != updatedAfterUtc) {
	            filter = "DATE_UPDATED_UTC gt DateTime'" + updatedAfterUtc + "'";
	            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", filter));
            }
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}/Tasks").buildAndExpand(uriVariables).toUriString();
        	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "updated_after_utc", updatedAfterUtc));
			queryParams.putAll(apiClient.parameterToMultiValueMap(null, "top", top));
			queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip", skip));
			queryParams.putAll(apiClient.parameterToMultiValueMap(null, "brief", brief));
			queryParams.putAll(apiClient.parameterToMultiValueMap(null, "count_total", countTotal));
        }

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<List<Task>> returnType = new ParameterizedTypeReference<List<Task>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates a Custom Field
     * 
     * <p><b>200</b> - Custom Field updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead or Custom Field not found.
     * @param id A Lead&#39;s ID (LEAD_ID)
     * @param customField The Custom Field to edit (just include JSON object as request body)
     * @return CustomField
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CustomField updateCustomField(Long id, CustomField customField) throws RestClientException {
        Object postBody = customField;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateCustomField");
        }
        
        // verify the required parameter 'customField' is set
        if (customField == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'customField' when calling updateCustomField");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}/CustomFields").buildAndExpand(uriVariables).toUriString();
        }

        final String[] accepts = { 
            "application/json", "text/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<CustomField> returnType = new ParameterizedTypeReference<CustomField>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates a Lead&#39;s Image
     * This action will replace any existing Image attached to the Lead. The contents of the image file should be sent as binary data in the request payload. See our &lt;a href&#x3D;\&quot;http://github.com/Insightly\&quot; target&#x3D;\&quot;_blank\&quot;&gt;client libraries&lt;/a&gt; for an example of how this is done.
     * <p><b>201</b> - Image updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>402</b> - Storage limit reached.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead not found.
     * <p><b>417</b> - Image update failed.
     * @param id A Lead&#39;s ID (LEAD_ID)
     * @param filename Name of Image File to be attached to Lead
     * @param file File to upload
     * @return Lead
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Lead updateImage(Long id, String filename, byte[] file) throws RestClientException {
        Object postBody = file;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateImage");
        }
        
        // verify the required parameter 'filename' is set
        if (filename == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'filename' when calling updateImage");
        }
        
        // verify the required parameter 'file' is set
        if (file == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'file' when calling updateImage");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("filename", filename);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(apiVersion.in(ApiVersion.VERSION_2_1, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.1/Leads/{id}/Image/{filename}").buildAndExpand(uriVariables).toUriString();
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads/{id}/Image/{filename}").buildAndExpand(uriVariables).toUriString();
        }

        final String[] accepts = { 
            "application/json", "text/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/octet-stream"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<Lead> returnType = new ParameterizedTypeReference<Lead>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates a Lead
     * A common source of problems when updating leads occurs when users omit required fields, or insert             invalid data into a field. A good troubleshooting technique             is to create a few leads via the web interface, with representative data, links, etc, and then access             these leads via the API, and inspect the returned object graph.
     * <p><b>200</b> - Lead updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Lead or Lead Management disabled.
     * <p><b>404</b> - Lead not found.
     * @param lead A Lead (just include JSON object as request body)
     * @param brief Optional, true if you wish to do a partial update containing only top level properties of the Lead. When true, all sub-collections are ignored.
     * @return Lead
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Lead updateLead(Lead lead, Boolean brief) throws RestClientException {
        Object postBody = lead;
        
        // verify the required parameter 'lead' is set
        if (lead == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'lead' when calling updateLead");
        }
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(apiVersion.in(ApiVersion.VERSION_2_1, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.1/Leads").build().toUriString();
        	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "Brief", brief));
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Leads").build().toUriString();
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "brief", brief));
        }

        final String[] accepts = { 
            "application/json", "text/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "Basic" };

        ParameterizedTypeReference<Lead> returnType = new ParameterizedTypeReference<Lead>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
