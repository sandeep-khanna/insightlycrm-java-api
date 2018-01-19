package com.insightly.api;

import com.insightly.api.util.ApiClient;
import com.insightly.model.ActivitySetAssignment;
import com.insightly.model.CustomField;
import com.insightly.model.Link;
import com.insightly.model.Note;
import com.insightly.model.Opportunity;
import com.insightly.model.PipelineChange;
import com.insightly.model.PipelineStageChange;
import com.insightly.model.Tag;
import com.insightly.model.CalendarEvent;
import com.insightly.model.CustomField;
import com.insightly.model.Email;
import com.insightly.model.FileAttachment;
import com.insightly.model.Follow;
import com.insightly.model.Link;
import com.insightly.model.LinkEmailAddress;
import com.insightly.model.Note;
import java.time.OffsetDateTime;
import com.insightly.model.Opportunity;
import com.insightly.model.OpportunityState;
import com.insightly.model.Tag;
import com.insightly.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


@Component("com.insightly.OpportunitiesApi")
public class OpportunitiesApi {
    private ApiClient apiClient;

    public OpportunitiesApi() {
        this(new ApiClient());
    }

    @Autowired
    public OpportunitiesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Adds an Activity Set to an Opportunity
     * 
     * <p><b>201</b> - Activity Set assigned.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity, Activity Set or Activities not found.
     * @param id A Opportunity&#39;s ID
     * @param apiActivitySetAssignment The Activity Set Assignment object which contains the configuration information for the Activity Set (just include JSON object as request body)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void addActivitySetAssignment(Long id, ActivitySetAssignment apiActivitySetAssignment) throws RestClientException {
        Object postBody = apiActivitySetAssignment;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling addActivitySetAssignment");
        }
        
        // verify the required parameter 'apiActivitySetAssignment' is set
        if (apiActivitySetAssignment == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiActivitySetAssignment' when calling addActivitySetAssignment");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/ActivitySetAssignment").buildAndExpand(uriVariables).toUriString();
        
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

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Adds a File Attachment to an Opportunity
     * This endpoint expects multipart/form-data as the request payload. See Stack Overflow for examples of how to generate multipart requests, or see our &lt;a href&#x3D;\&quot;http://github.com/Insightly\&quot; target&#x3D;\&quot;_blank\&quot;&gt;client libraries&lt;/a&gt; for an example of how this is generated. Only one file can be added per request.
     * <p><b>201</b> - File Attachment added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>402</b> - Record or storage limit reached.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * <p><b>417</b> - File Attachment insert failed.
     * @param id An Opportunity&#39;s ID (OPPORTUNITY_ID)
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
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/FileAttachments").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
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

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<FileAttachment> returnType = new ParameterizedTypeReference<FileAttachment>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, mediaType, authNames, returnType);
    }
    /**
     * Start following an Opportunity
     * 
     * <p><b>201</b> - Follow added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * @param id An Opportunity&#39;s ID (OPPORTUNITY_ID)
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
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/Follow").buildAndExpand(uriVariables).toUriString();
        
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

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Follow> returnType = new ParameterizedTypeReference<Follow>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Adds a Link
     * 
     * <p><b>201</b> - Link added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * @param id An Opportunity&#39;s ID (OPPORTUNITY_ID)
     * @param apiLink The Link to add (just include JSON object as request body)
     * @return Link
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Link addLink(Long id, Link apiLink) throws RestClientException {
        Object postBody = apiLink;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling addLink");
        }
        
        // verify the required parameter 'apiLink' is set
        if (apiLink == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiLink' when calling addLink");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/Links").buildAndExpand(uriVariables).toUriString();
        
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

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Link> returnType = new ParameterizedTypeReference<Link>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Adds a Note to an Opportunity.
     * 
     * <p><b>201</b> - Note added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>402</b> - Record limit reached.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * @param id An Opportunity&#39;s ID (OPPORTUNITY_ID)
     * @param apiNote The Note to add (just include JSON object as request body)
     * @return Note
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Note addNote(Long id, Note apiNote) throws RestClientException {
        Object postBody = apiNote;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling addNote");
        }
        
        // verify the required parameter 'apiNote' is set
        if (apiNote == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiNote' when calling addNote");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/Notes").buildAndExpand(uriVariables).toUriString();
        
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

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Note> returnType = new ParameterizedTypeReference<Note>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Adds an Opportunity
     * A common source of problems when creating opportunities occurs when users omit required fields, or insert             invalid data into a field (for example by referencing an invalid CATEGORY_ID). A good troubleshooting technique             is to create a few opportunities via the web interface, with representative data, links, etc, and then access             these opportunities via the GET method, and inspect the returned object graph. Also, note: The STAGE_ID and             PIPELINE_ID properties of opportunities are read-only. (There are separate endpoints to update pipelines/stages.)
     * <p><b>201</b> - Opportunity added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>402</b> - Record limit reached.
     * @param apiOpportunity The Opportunity to add (just include JSON object as request body)
     * @return Opportunity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Opportunity addOpportunity(Opportunity apiOpportunity) throws RestClientException {
        Object postBody = apiOpportunity;
        
        // verify the required parameter 'apiOpportunity' is set
        if (apiOpportunity == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiOpportunity' when calling addOpportunity");
        }
        
        String path = UriComponentsBuilder.fromPath("/Opportunities").build().toUriString();
        
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

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Opportunity> returnType = new ParameterizedTypeReference<Opportunity>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Adds a Tag for an Opportunity
     * 
     * <p><b>201</b> - Tag added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * @param id An Opportunity&#39;s ID (OPPORTUNITY_ID)
     * @param apiTag The Tag to add (just include JSON object as request body)
     * @return Tag
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Tag addTag(Long id, Tag apiTag) throws RestClientException {
        Object postBody = apiTag;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling addTag");
        }
        
        // verify the required parameter 'apiTag' is set
        if (apiTag == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiTag' when calling addTag");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/Tags").buildAndExpand(uriVariables).toUriString();
        
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

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Tag> returnType = new ParameterizedTypeReference<Tag>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Deletes a Custom Field
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity or Custom Field not found.
     * <p><b>417</b> - Delete failed.
     * @param id An Opportunity&#39;s ID (OPPORTUNITY_ID)
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
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/CustomFields/{customFieldId}").buildAndExpand(uriVariables).toUriString();
        
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

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Stop following an Opportunity
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * <p><b>417</b> - Delete failed.
     * @param id An Opportunity&#39;s ID (OPPORTUNITY_ID)
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
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/Follow").buildAndExpand(uriVariables).toUriString();
        
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

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Deletes an Opportunity&#39;s Image
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * <p><b>417</b> - Delete failed.
     * @param id An Opportunity&#39;s ID (OPPORTUNITY_ID)
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
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/Image").buildAndExpand(uriVariables).toUriString();
        
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

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Deletes a Link
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity or Link not found.
     * <p><b>417</b> - Delete failed.
     * @param id An Opportunity&#39;s ID (OPPORTUNITY_ID)
     * @param linkId A Link&#39;s ID (LINK_ID)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteLink(Long id, Long linkId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteLink");
        }
        
        // verify the required parameter 'linkId' is set
        if (linkId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'linkId' when calling deleteLink");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("linkId", linkId);
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/Links/{linkId}").buildAndExpand(uriVariables).toUriString();
        
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

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Deletes an Opportunity
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * <p><b>417</b> - Delete failed.
     * @param id An Opportunity&#39;s ID
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteOpportunity(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteOpportunity");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Clears pipeline for the opportunity.
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * <p><b>417</b> - Delete failed.
     * @param id An Opportunity&#39;s ID
     * @return Opportunity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Opportunity deletePipeline(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deletePipeline");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/Pipeline").buildAndExpand(uriVariables).toUriString();
        
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

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Opportunity> returnType = new ParameterizedTypeReference<Opportunity>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Deletes a Tag from an Opportunity
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity or Tag not found.
     * <p><b>417</b> - Delete failed.
     * @param id An Opportunity&#39;s ID (OPPORTUNITY_ID)
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
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/Tags/{tagName}").buildAndExpand(uriVariables).toUriString();
        
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

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a list of Opportunity&#39;s Emails
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * @param id An Opportunity&#39;s ID
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
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/Emails").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "updated_after_utc", updatedAfterUtc));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "top", top));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip", skip));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "brief", brief));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "count_total", countTotal));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<Email>> returnType = new ParameterizedTypeReference<List<Email>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets an Opportunity&#39;s Events
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * @param id An Opportunity&#39;s ID (OPPORTUNITY_ID)
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
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/Events").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "updated_after_utc", updatedAfterUtc));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "top", top));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip", skip));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "brief", brief));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "count_total", countTotal));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<CalendarEvent>> returnType = new ParameterizedTypeReference<List<CalendarEvent>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets an Opportunity&#39;s File Attachments
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * @param id An Opportunity&#39;s ID (OPPORTUNITY_ID)
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
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/FileAttachments").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "updated_after_utc", updatedAfterUtc));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip", skip));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "top", top));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "count_total", countTotal));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<FileAttachment>> returnType = new ParameterizedTypeReference<List<FileAttachment>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a Follow record for the Opportunity
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * @param id An Opportunity&#39;s ID (OPPORTUNITY_ID)
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
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/Follow").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Follow> returnType = new ParameterizedTypeReference<Follow>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets an Opportunity&#39;s Image
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * @param id An Opportunity&#39;s ID (OPPORTUNITY_ID)
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
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/Image").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/octet-stream"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets the email address to use for linking with the opportunity
     * An email address to use as a maildrop for the Opportunity.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * @param id An Opportunity&#39;s ID
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
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/LinkEmailAddress").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<LinkEmailAddress> returnType = new ParameterizedTypeReference<LinkEmailAddress>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets an Opportunity&#39;s Notes
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * @param id An Opportunity&#39;s ID (OPPORRTUNITY_ID)
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
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/Notes").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "updated_after_utc", updatedAfterUtc));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "top", top));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip", skip));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "brief", brief));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "count_total", countTotal));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<Note>> returnType = new ParameterizedTypeReference<List<Note>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a list of Opportunities.
     * Simple object graphs (excluding Custom Fields, Tags, etc.) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * @param brief Optional, true if response should only contain top level properties of the opportunity.
     * @param skip Optional, number of opportunities to skip.
     * @param top Optional, maximum number of opportunities to return in the response.
     * @param countTotal Optional, true if total number of records should be returned in the response headers.
     * @return List&lt;Opportunity&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Opportunity> getOpportunities(Boolean brief, Integer skip, Integer top, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/Opportunities").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "brief", brief));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip", skip));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "top", top));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "count_total", countTotal));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<Opportunity>> returnType = new ParameterizedTypeReference<List<Opportunity>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a filtered list of Opportunities.
     * Only one optional parameter (excluding brief, top, skip and count_total) can be specified. Simple object graphs (excluding Custom Fields, Tags, etc.) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * @param tag Optional, a single tag.
     * @param opportunityName Optional, opportuinty name.
     * @param opportunityState Optional, opportunity state.
     * @param categoryId Optional, category id.
     * @param pipelineId Optional, pipeline id.
     * @param stageId Optional, stage id.
     * @param responsibleUserId Optional, responsible user id.
     * @param ownerUserId Optional, owner user id.
     * @param forecastCloseDate Optional, forecast close date.
     * @param actualCloseDate Optional, actual close date.
     * @param updatedAfterUtc Optional, earliest date when opportunity was last updated.
     * @param brief Optional, true if response should only contain top level properties of the opportunity.
     * @param skip Optional, number of opportunities to skip.
     * @param top Optional, maximum number of opportunities to return in the response.
     * @param countTotal Optional, true if total number of records should be returned in the response headers.
     * @return List&lt;Opportunity&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Opportunity> getOpportunitiesBySearch(String tag, String opportunityName, String opportunityState, Long categoryId, Long pipelineId, Long stageId, Long responsibleUserId, Long ownerUserId, OffsetDateTime forecastCloseDate, OffsetDateTime actualCloseDate, OffsetDateTime updatedAfterUtc, Boolean brief, Integer skip, Integer top, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/Opportunities/Search").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tag", tag));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "opportunity_name", opportunityName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "opportunity_state", opportunityState));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "category_id", categoryId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "pipeline_id", pipelineId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "stage_id", stageId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "responsible_user_id", responsibleUserId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "owner_user_id", ownerUserId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "forecast_close_date", forecastCloseDate));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "actual_close_date", actualCloseDate));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "updated_after_utc", updatedAfterUtc));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "brief", brief));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip", skip));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "top", top));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "count_total", countTotal));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<Opportunity>> returnType = new ParameterizedTypeReference<List<Opportunity>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets an Opportunity
     * Returns the Opportunity object&#39;s full graph. Prior to attempting POST and PUT operations,             we recommend using this method to fetch an existing object and make incremental changes to it.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * @param id An Opportunity&#39;s ID
     * @return Opportunity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Opportunity getOpportunity(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getOpportunity");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Opportunity> returnType = new ParameterizedTypeReference<Opportunity>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets the history of States and Reasons for an Opportunity.
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * @param id An Opportunity&#39;s ID
     * @return List&lt;OpportunityState&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<OpportunityState> getStateHistory(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getStateHistory");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/StateHistory").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<OpportunityState>> returnType = new ParameterizedTypeReference<List<OpportunityState>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a list of Opportunity&#39;s Tasks
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * @param id An Opportunity&#39;s ID
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
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/Tasks").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "updated_after_utc", updatedAfterUtc));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "top", top));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip", skip));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "brief", brief));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "count_total", countTotal));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<Task>> returnType = new ParameterizedTypeReference<List<Task>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates a Custom Field
     * 
     * <p><b>200</b> - Custom Field updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity or Custom Field not found.
     * @param id An Opportunity&#39;s ID (OPPORTUNITY_ID)
     * @param apiCustomField The Custom Field to edit (just include JSON object as request body)
     * @return CustomField
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CustomField updateCustomField(Long id, CustomField apiCustomField) throws RestClientException {
        Object postBody = apiCustomField;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateCustomField");
        }
        
        // verify the required parameter 'apiCustomField' is set
        if (apiCustomField == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiCustomField' when calling updateCustomField");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/CustomFields").buildAndExpand(uriVariables).toUriString();
        
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

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<CustomField> returnType = new ParameterizedTypeReference<CustomField>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates an Opportunity&#39;s Image
     * This action will replace any existing Image attached to the Opportunity. Image file contents should be sent as binary data in request payload. See our &lt;a href&#x3D;\&quot;http://github.com/Insightly\&quot; target&#x3D;\&quot;_blank\&quot;&gt;client libraries&lt;/a&gt; for an example of how this is done.
     * <p><b>201</b> - Image updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>402</b> - Storage limit reached.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * <p><b>417</b> - Image update failed.
     * @param id An Opportunity&#39;s ID (OPPORTUNITY_ID)
     * @param filename Name of Image File to be attached to Opportunity
     * @param file File to upload
     * @return Opportunity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Opportunity updateImage(Long id, String filename, byte[] file) throws RestClientException {
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
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/Image/{filename}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json", "text/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/octet-stream"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Opportunity> returnType = new ParameterizedTypeReference<Opportunity>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates a Link
     * 
     * <p><b>200</b> - Link updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity or Link not found.
     * @param id An Opportunity&#39;s ID (OPPORTUNITY_ID)
     * @param apiLink The Link to add (just include JSON object as request body)
     * @return Link
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Link updateLink(Long id, Link apiLink) throws RestClientException {
        Object postBody = apiLink;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateLink");
        }
        
        // verify the required parameter 'apiLink' is set
        if (apiLink == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiLink' when calling updateLink");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/Links").buildAndExpand(uriVariables).toUriString();
        
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

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Link> returnType = new ParameterizedTypeReference<Link>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates an Opportunity
     * A common source of problems when updating opportunities occurs when users omit required fields, or insert             invalid data into a field (for example by referencing an invalid CATEGORY_ID). A good troubleshooting technique             is to create a few opportunities via the web interface, with representative data, links, etc, and then access             these opportunities via the GET method, and inspect the returned object graph. Also, note: The STAGE_ID and             PIPELINE_ID properties of opportunities are read-only. (There are separate endpoints to update pipelines/stages.)
     * <p><b>200</b> - Opportunity updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity not found.
     * @param apiOpportunity An Opportunity (just include JSON object as request body)
     * @param brief Optional, true if you wish to do a partial update containing only top level properties of the Opportunity. When true, all sub-collections are ignored.
     * @return Opportunity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Opportunity updateOpportunity(Opportunity apiOpportunity, Boolean brief) throws RestClientException {
        Object postBody = apiOpportunity;
        
        // verify the required parameter 'apiOpportunity' is set
        if (apiOpportunity == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiOpportunity' when calling updateOpportunity");
        }
        
        String path = UriComponentsBuilder.fromPath("/Opportunities").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "brief", brief));

        final String[] accepts = { 
            "application/json", "text/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Opportunity> returnType = new ParameterizedTypeReference<Opportunity>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Changes current pipeline for the opportunity.
     * 
     * <p><b>200</b> - Opportunity updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity, Pipeline or Pipeline Stage not found.
     * @param id An Opportunity&#39;s ID
     * @param apiPipelineChange Pipeline change parameters (just include JSON object as request body)
     * @return Opportunity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Opportunity updatePipeline(Long id, PipelineChange apiPipelineChange) throws RestClientException {
        Object postBody = apiPipelineChange;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updatePipeline");
        }
        
        // verify the required parameter 'apiPipelineChange' is set
        if (apiPipelineChange == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiPipelineChange' when calling updatePipeline");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/Pipeline").buildAndExpand(uriVariables).toUriString();
        
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

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Opportunity> returnType = new ParameterizedTypeReference<Opportunity>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Changes current pipeline stage for the opportunity.
     * 
     * <p><b>200</b> - Opportunity updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Opportunity.
     * <p><b>404</b> - Opportunity, Pipeline or Pipeline Stage not found.
     * @param id An Opportunity&#39;s ID
     * @param apiStageChange Pipeline stage change parameters (just include JSON object as request body)
     * @return Opportunity
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Opportunity updatePipelineStage(Long id, PipelineStageChange apiStageChange) throws RestClientException {
        Object postBody = apiStageChange;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updatePipelineStage");
        }
        
        // verify the required parameter 'apiStageChange' is set
        if (apiStageChange == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiStageChange' when calling updatePipelineStage");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Opportunities/{id}/PipelineStage").buildAndExpand(uriVariables).toUriString();
        
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

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Opportunity> returnType = new ParameterizedTypeReference<Opportunity>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
