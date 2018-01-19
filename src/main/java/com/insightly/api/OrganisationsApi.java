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
import com.insightly.model.Address;
import com.insightly.model.CalendarEvent;
import com.insightly.model.ContactInfo;
import com.insightly.model.CustomField;
import com.insightly.model.Email;
import com.insightly.model.FileAttachment;
import com.insightly.model.Follow;
import com.insightly.model.Link;
import com.insightly.model.Note;
import com.insightly.model.Organisation;
import com.insightly.model.OrganisationDate;
import com.insightly.model.OrganisationLink;
import com.insightly.model.Tag;
import com.insightly.model.Task;

@Component
public class OrganisationsApi {
	
	@Autowired
    private ApiClient apiClient;

    public OrganisationsApi() {
        this(new ApiClient());
    }

    @Autowired
    public OrganisationsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Adds an Activity Set to an Organisation
     * 
     * <p><b>201</b> - Activity Set assigned.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisaton.
     * <p><b>404</b> - Organisaton, Activity Set or Activities not found.
     * @param id A Organisaton&#39;s ID
     * @param apiActivitySetAssignment The Activity Set Assignment object which contains the configuration information for the Activity Set
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
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/ActivitySetAssignment").buildAndExpand(uriVariables).toUriString();
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
     * Adds an Address
     * Limited to two addresses, one Shipping Address and one Billing Address. For more information, please refer to Body Schema.
     * <p><b>201</b> - Address added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
     * @param address The Address to add (just include the JSON object in the request body)
     * @return Address
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Address addAddress(Long id, Address address) throws RestClientException {
        Object postBody = address;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling addAddress");
        }
        
        // verify the required parameter 'address' is set
        if (address == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'address' when calling addAddress");
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
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Addresses").buildAndExpand(uriVariables).toUriString();
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

        ParameterizedTypeReference<Address> returnType = new ParameterizedTypeReference<Address>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Adds a Contact Info
     * Limited to two Phone Numbers and one Website. For more information, please refer to Body Schema.
     * <p><b>201</b> - Contact Info added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
     * @param contactInfo The Contact Info to add (just include the JSON object in the request body)
     * @return ContactInfo
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ContactInfo addContactInfo(Long id, ContactInfo contactInfo) throws RestClientException {
        Object postBody = contactInfo;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling addContactInfo");
        }
        
        // verify the required parameter 'contactInfo' is set
        if (contactInfo == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contactInfo' when calling addContactInfo");
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
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/ContactInfos").buildAndExpand(uriVariables).toUriString();
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

        ParameterizedTypeReference<ContactInfo> returnType = new ParameterizedTypeReference<ContactInfo>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Adds an Organisation Date
     * 
     * <p><b>201</b> - Date added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
     * @param date The Organisation Date to add (just include the JSON object in the request body)
     * @return OrganisationDate
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public OrganisationDate addDate(Long id, OrganisationDate date) throws RestClientException {
        Object postBody = date;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling addDate");
        }
        
        // verify the required parameter 'date' is set
        if (date == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'date' when calling addDate");
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
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Dates").buildAndExpand(uriVariables).toUriString();
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

        ParameterizedTypeReference<OrganisationDate> returnType = new ParameterizedTypeReference<OrganisationDate>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Adds a File Attachment to an Organisation
     * This endpoint expects multipart/form-data as the request payload. See Stack Overflow for examples of how to generate multipart requests, or see our &lt;a href&#x3D;\&quot;http://github.com/Insightly\&quot; target&#x3D;\&quot;_blank\&quot;&gt;client libraries&lt;/a&gt; for an example of how this is generated. Only one file can be added per request.
     * <p><b>201</b> - File Attachment added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>402</b> - Record or storage limit reached.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * <p><b>417</b> - File Attachment insert failed.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
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
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/FileAttachments").buildAndExpand(uriVariables).toUriString();
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
     * Start following an Organisation
     * 
     * <p><b>201</b> - Follow added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
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
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Follow").buildAndExpand(uriVariables).toUriString();
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
     * Adds a Link
     * 
     * <p><b>201</b> - Link added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
     * @param link The Link to add (just include the JSON object in the request body)
     * @return Link
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Link addLink(Long id, Link link) throws RestClientException {
        Object postBody = link;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling addLink");
        }
        
        // verify the required parameter 'link' is set
        if (link == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'link' when calling addLink");
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
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Links").buildAndExpand(uriVariables).toUriString();
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

        ParameterizedTypeReference<Link> returnType = new ParameterizedTypeReference<Link>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Adds a Note to an Organisation
     * 
     * <p><b>201</b> - Note added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>402</b> - Record limit reached.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
     * @param note The Note to add (just include the JSON object in the request body)
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
        	path = UriComponentsBuilder.fromPath("/v2.1/Organisations/{id}/Notes").buildAndExpand(uriVariables).toUriString();
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Notes").buildAndExpand(uriVariables).toUriString();
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
     * Adds an Organisation
     * If you have trouble with creating an organisation, try creating organisations via the web interface, and then access those organisations via the API. This way you            can see examples of the fields and sub-elements attached to the object. A common source of problems during write/update request is caused when users omit            required fields, or insert invalid data in a field (e.g. reference a CATEGORY_ID that does not exist in the user&#39;s Insightly instance.
     * <p><b>201</b> - Organisation added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>402</b> - Record limit reached.
     * @param organisation The Organisation to add (just include JSON object as request body)
     * @return Organisation
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Organisation addOrganisation(Organisation organisation) throws RestClientException {
        Object postBody = organisation;
        
        // verify the required parameter 'apiOrganisation' is set
        if (organisation == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiOrganisation' when calling addOrganisation");
        }
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(apiVersion.in(ApiVersion.VERSION_2_1, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.1/Organisations").build().toUriString();
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations").build().toUriString();
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

        ParameterizedTypeReference<Organisation> returnType = new ParameterizedTypeReference<Organisation>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Adds an Organisation Link
     * 
     * <p><b>201</b> - Organisation Link added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
     * @param link The Organisation Link to add (just include the JSON object in the request body)
     * @return OrganisationLink
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public OrganisationLink addOrganisationLink(Long id, OrganisationLink link) throws RestClientException {
        Object postBody = link;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling addOrganisationLink");
        }
        
        // verify the required parameter 'link' is set
        if (link == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'link' when calling addOrganisationLink");
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
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/OrganisationLinks").buildAndExpand(uriVariables).toUriString();
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

        ParameterizedTypeReference<OrganisationLink> returnType = new ParameterizedTypeReference<OrganisationLink>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Adds a Tag
     * 
     * <p><b>201</b> - Tag added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
     * @param tag The Tag to add (just include the JSON object in the request body)
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
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Tags").buildAndExpand(uriVariables).toUriString();
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

        ParameterizedTypeReference<Tag> returnType = new ParameterizedTypeReference<Tag>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Deletes an Address
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation or Address not found.
     * <p><b>417</b> - Delete failed.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
     * @param addressId An Address&#39; ID (ADDRESS_ID)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteAddress(Long id, Long addressId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteAddress");
        }
        
        // verify the required parameter 'addressId' is set
        if (addressId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'addressId' when calling deleteAddress");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("addressId", addressId);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Addresses/{addressId}").buildAndExpand(uriVariables).toUriString();
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
     * Deletes a Contact Info
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation or Contact Info not found.
     * <p><b>417</b> - Delete failed.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
     * @param contactInfoId A Contact Info&#39;s ID (CONTACT_INFO_ID)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteContactInfo(Long id, Long contactInfoId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteContactInfo");
        }
        
        // verify the required parameter 'contactInfoId' is set
        if (contactInfoId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contactInfoId' when calling deleteContactInfo");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("contactInfoId", contactInfoId);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/ContactInfos/{contactInfoId}").buildAndExpand(uriVariables).toUriString();
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
     * Deletes a Custom Field
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation or Custom Field not found.
     * <p><b>417</b> - Delete failed.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
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
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/CustomFields/{customFieldId}").buildAndExpand(uriVariables).toUriString();
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
     * Deletes an Organisation Date
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation or Date not found.
     * <p><b>417</b> - Delete failed.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
     * @param dateId An Organisation Date&#39;s ID (DATE_ID)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteDate(Long id, Long dateId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteDate");
        }
        
        // verify the required parameter 'dateId' is set
        if (dateId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'dateId' when calling deleteDate");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("dateId", dateId);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Dates/{dateId}").buildAndExpand(uriVariables).toUriString();
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
     * Stop following an Organisation
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * <p><b>417</b> - Delete failed.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
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
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Follow").buildAndExpand(uriVariables).toUriString();
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
     * Deletes an Organisation&#39;s Image
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * <p><b>417</b> - Delete failed.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
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
        	path = UriComponentsBuilder.fromPath("/v2.1/Organisations/{id}/Image").buildAndExpand(uriVariables).toUriString();
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Image").buildAndExpand(uriVariables).toUriString();
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
     * Deletes a Link
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation or Link not found.
     * <p><b>417</b> - Delete failed.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
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
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Links/{linkId}").buildAndExpand(uriVariables).toUriString();
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
     * Deletes an Organisation
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * <p><b>417</b> - Delete failed.
     * @param id An Organisation&#39;s ID
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteOrganisation(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteOrganisation");
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
        	path = UriComponentsBuilder.fromPath("/v2.1/Organisations/{id}").buildAndExpand(uriVariables).toUriString();
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}").buildAndExpand(uriVariables).toUriString();
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
     * Deletes an Organisation Link
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation or Organisation Link not found.
     * <p><b>417</b> - Delete failed.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
     * @param linkId An Organisation Link&#39;s ID (ORG_LINK_ID)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteOrganisationLink(Long id, Long linkId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteOrganisationLink");
        }
        
        // verify the required parameter 'linkId' is set
        if (linkId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'linkId' when calling deleteOrganisationLink");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("linkId", linkId);
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/OrganisationLinks/{linkId}").buildAndExpand(uriVariables).toUriString();
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
     * Deletes a Tag
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation or Tag not found.
     * <p><b>417</b> - Delete failed.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
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
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Tags/{tagName}").buildAndExpand(uriVariables).toUriString();
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
     * Gets a list of Organisation&#39;s Emails
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * @param id An Organisation&#39;s ID
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
        	path = UriComponentsBuilder.fromPath("/v2.1/Organisations/{id}/Emails").buildAndExpand(uriVariables).toUriString();

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
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Emails").buildAndExpand(uriVariables).toUriString();
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
     * Gets an Organisation&#39;s Events
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
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
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Events").buildAndExpand(uriVariables).toUriString();
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
     * Gets an Organisation&#39;s File Attachments
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
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
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	throw new UnsupportedOperationException("Insightly API v2.1 does not support " 
        											+ new Object() {}.getClass().getEnclosingMethod().getName());
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/FileAttachments").buildAndExpand(uriVariables).toUriString();
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
     * Gets a Follow record for the Organisation
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
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
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Follow").buildAndExpand(uriVariables).toUriString();
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
     * Gets an Organisations&#39;s Image
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
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
        	path = UriComponentsBuilder.fromPath("/v2.1/Organisations/{id}/Image").buildAndExpand(uriVariables).toUriString();
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Image").buildAndExpand(uriVariables).toUriString();
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
     * Gets an Organisation&#39;s Notes
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
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
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(apiVersion.in(ApiVersion.VERSION_2_1, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.1/Organisations/{id}/Notes").buildAndExpand(uriVariables).toUriString();

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
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Notes").buildAndExpand(uriVariables).toUriString();
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
     * Gets an Organisation
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * @param id An Organisation&#39;s ID
     * @return Organisation
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Organisation getOrganisation(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getOrganisation");
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
        	path = UriComponentsBuilder.fromPath("/v2.1/Organisations/{id}").buildAndExpand(uriVariables).toUriString();
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}").buildAndExpand(uriVariables).toUriString();
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

        ParameterizedTypeReference<Organisation> returnType = new ParameterizedTypeReference<Organisation>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a list of Organisations.
     * Simple object graphs (excluding ADDRESSES, CONTACTINFOS, etc.) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * @param brief Optional, true if response should only contain top level properties of the organisation.
     * @param skip Optional, number of organisations to skip.
     * @param top Optional, maximum number of organisations to return in the response.
     * @param countTotal Optional, true if total number of records should be returned in the response headers.
     * @return List&lt;Organisation&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Organisation> getOrganisations(Boolean brief, Integer skip, Integer top, Boolean countTotal) throws RestClientException {    	
    	return getOrganisationsBySearch(null, null, null, null, null, null, null, null, null, null, brief, skip, top, countTotal);
    }
    /**
     * Gets a filtered list of Organisations.
     * Only one optional parameter (excluding brief, top, skip and count_total) can be specified. Simple object graphs (excluding ADDRESSES, CONTACTINFOS, etc.) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * @param email Optional, email address.
     * @param emailDomain Optional, email domain.
     * @param tag Optional, a single tag.
     * @param phoneNumber Optional, phone number.
     * @param organisationName Optional, name of the organisation.
     * @param city Optional, name of the city from organisation address.
     * @param state Optional, state from the organisation address.
     * @param postcode Optional, postal code from the organisation address.
     * @param country Optional, name of the country from organisation address.
     * @param updatedAfterUtc Optional, earliest date when organisation was last updated.
     * @param brief Optional, true if response should only contain top level properties of the organisation.
     * @param skip Optional, number of organisations to skip.
     * @param top Optional, maximum number of organisations to return in the response.
     * @param countTotal Optional, true if total number of records should be returned in the response headers.
     * @return List&lt;Organisation&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Organisation> getOrganisationsBySearch(String email, String emailDomain, String tag, String phoneNumber, String organisationName, String city, String state, String postcode, String country, Instant updatedAfterUtc, Boolean brief, Integer skip, Integer top, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        String path = null;
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        
        if(apiVersion.in(ApiVersion.VERSION_2_1, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.1/Organisations").build().toUriString();
            
        	/* Including the 'Brief' query string parameter seems to be touchy, 
        	 * especially when used with the OData filters.
        	 * 
        	 * queryParams.putAll(apiClient.parameterToMultiValueMap(null, "Brief", brief));
        	 */
            
        	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$skip", skip));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$top", top));
            
            String filter = null;
            
            if(StringUtils.isNotBlank(organisationName)) {
            	// Replace single quote with *two* single quotes for Odata queries to work
            	filter = "ORGANISATION_NAME eq '" + organisationName.replace("'", "''") + "'";
            	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", filter));
            }
            
            if(null != updatedAfterUtc) {
	            filter = "DATE_UPDATED_UTC gt DateTime'" + updatedAfterUtc + "'";
	            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", filter));
            }
            
            /* v2.1 supports filtering by and ordering only for fields that are *directly* on the object
             * Unfortunately, you cannot do the following:
             *  filter by an Address component (STREET, CITY, etc.) in the ADDRESSES collection
             *  filter by a ContactInfo component (TYPE, DETAIL, etc.) in the CONTACTINFOS collection
             *  filter by a CustomField component (CUSTOM_FIELD_ID, FIELD_VALUE) in the CUSTOMFIELDS collection
             *  
             *  queryParams.putAll(apiClient.parameterToMultiValueMap(null, "email", email));
             *  queryParams.putAll(apiClient.parameterToMultiValueMap(null, "email_domain", emailDomain));
             *  queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tag", tag));
             *  queryParams.putAll(apiClient.parameterToMultiValueMap(null, "phone_number", phoneNumber));
             *  queryParams.putAll(apiClient.parameterToMultiValueMap(null, "city", city));
             *  queryParams.putAll(apiClient.parameterToMultiValueMap(null, "state", state));
             *  queryParams.putAll(apiClient.parameterToMultiValueMap(null, "postcode", postcode));
             *  queryParams.putAll(apiClient.parameterToMultiValueMap(null, "country", country));
             */
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/Search").build().toUriString();
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "brief", brief));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skip", skip));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "top", top));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "count_total", countTotal));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "email", email));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "email_domain", emailDomain));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tag", tag));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "phone_number", phoneNumber));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "organisation_name", organisationName));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "city", city));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "state", state));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "postcode", postcode));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "country", country));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "updated_after_utc", updatedAfterUtc));
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

        ParameterizedTypeReference<List<Organisation>> returnType = new ParameterizedTypeReference<List<Organisation>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a list of Organisation&#39;s Tasks
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * @param id An Organisation&#39;s ID
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
        String path = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getTasks");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);        
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        
        if(apiVersion.in(ApiVersion.VERSION_2_1, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.1/Organisations/{id}/Tasks").buildAndExpand(uriVariables).toUriString();
            
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
            
            /* v2.1 supports filtering by and ordering only for fields that are *directly* on the object
             * Unfortunately, you cannot do the following:
             *  filter by an Address component (STREET, CITY, etc.) in the ADDRESSES collection
             *  filter by a ContactInfo component (TYPE, DETAIL, etc.) in the CONTACTINFOS collection
             *  filter by a CustomField component (CUSTOM_FIELD_ID, FIELD_VALUE) in the CUSTOMFIELDS collection
             *  
             *  queryParams.putAll(apiClient.parameterToMultiValueMap(null, "email", email));
             *  queryParams.putAll(apiClient.parameterToMultiValueMap(null, "email_domain", emailDomain));
             *  queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tag", tag));
             *  queryParams.putAll(apiClient.parameterToMultiValueMap(null, "phone_number", phoneNumber));
             *  queryParams.putAll(apiClient.parameterToMultiValueMap(null, "city", city));
             *  queryParams.putAll(apiClient.parameterToMultiValueMap(null, "state", state));
             *  queryParams.putAll(apiClient.parameterToMultiValueMap(null, "postcode", postcode));
             *  queryParams.putAll(apiClient.parameterToMultiValueMap(null, "country", country));
             */
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Tasks").buildAndExpand(uriVariables).toUriString();
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
     * Updates an Address
     * 
     * <p><b>200</b> - Address updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation or Address not found.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
     * @param address The Address to update (just include the JSON object in the request body)
     * @return Address
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Address updateAddress(Long id, Address address) throws RestClientException {
        Object postBody = address;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateAddress");
        }
        
        // verify the required parameter 'address' is set
        if (address == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'address' when calling updateAddress");
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
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Addresses").buildAndExpand(uriVariables).toUriString();
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

        ParameterizedTypeReference<Address> returnType = new ParameterizedTypeReference<Address>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates a Contact Info
     * 
     * <p><b>200</b> - Organisation Info updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation or Contact Info not found.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
     * @param contactInfo The Contact Info to add (just include the JSON object in the request body)
     * @return ContactInfo
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ContactInfo updateContactInfo(Long id, ContactInfo contactInfo) throws RestClientException {
        Object postBody = contactInfo;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateContactInfo");
        }
        
        // verify the required parameter 'contactInfo' is set
        if (contactInfo == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contactInfo' when calling updateContactInfo");
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
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/ContactInfos").buildAndExpand(uriVariables).toUriString();
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

        ParameterizedTypeReference<ContactInfo> returnType = new ParameterizedTypeReference<ContactInfo>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates a Custom Field
     * 
     * <p><b>200</b> - Custom Field updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation or Custom Field not found.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
     * @param customField The Custom Field to edit (just include the JSON object in the request body)
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
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/CustomFields").buildAndExpand(uriVariables).toUriString();
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
     * Updates an Organisation Date
     * 
     * <p><b>200</b> - Date updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation or Date not found.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
     * @param date The Organisation Date to add (just include the JSON object in the request body)
     * @return OrganisationDate
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public OrganisationDate updateDate(Long id, OrganisationDate date) throws RestClientException {
        Object postBody = date;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateDate");
        }
        
        // verify the required parameter 'date' is set
        if (date == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'date' when calling updateDate");
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
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Dates").buildAndExpand(uriVariables).toUriString();
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

        ParameterizedTypeReference<OrganisationDate> returnType = new ParameterizedTypeReference<OrganisationDate>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates an Organisation&#39;s Image
     * This action will replace any existing Image attached to the Organisation. Image file contents should be sent as binary data in request payload. See our &lt;a href&#x3D;\&quot;http://github.com/Insightly\&quot; target&#x3D;\&quot;_blank\&quot;&gt;client libraries&lt;/a&gt; for an example of how this is done.
     * <p><b>201</b> - Image updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>402</b> - Storage limit reached.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Contact not found.
     * <p><b>417</b> - Image update failed.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
     * @param filename Name of Image File to be attached to Organisation
     * @param file File to upload
     * @return Organisation
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Organisation updateImage(Long id, String filename, byte[] file) throws RestClientException {
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
        	path = UriComponentsBuilder.fromPath("/v2.1/Organisations/{id}/Image/{filename}").buildAndExpand(uriVariables).toUriString();
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Image/{filename}").buildAndExpand(uriVariables).toUriString();
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

        ParameterizedTypeReference<Organisation> returnType = new ParameterizedTypeReference<Organisation>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates a Link
     * 
     * <p><b>200</b> - Link updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation or Link not found.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
     * @param link The Link to add (just include the JSON object in the request body)
     * @return Link
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Link updateLink(Long id, Link link) throws RestClientException {
        Object postBody = link;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateLink");
        }
        
        // verify the required parameter 'link' is set
        if (link == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'link' when calling updateLink");
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
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/Links").buildAndExpand(uriVariables).toUriString();
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

        ParameterizedTypeReference<Link> returnType = new ParameterizedTypeReference<Link>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates an Organisation
     * If you have trouble updating an organisation, try accessing the organisation via the GET request to inspect its fields and sub-elements. A common source of            problems with write/update requests occurs when users either omit required fields, or insert invalid data into a field (for example, by referring a            CATEGORY_ID or LINK_ID which does not exist.
     * <p><b>200</b> - Organisation updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation not found.
     * @param organisation An Organisation (just include JSON object as request body)
     * @param brief Optional, true if you wish to do a partial update containing only top level properties of the Organisation. When true, all sub-collections are ignored.
     * @return Organisation
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Organisation updateOrganisation(Organisation organisation, Boolean brief) throws RestClientException {
        Object postBody = organisation;
        
        // verify the required parameter 'apiOrganisation' is set
        if (organisation == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiOrganisation' when calling updateOrganisation");
        }
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        String path = null;
        
        if(ApiVersion.VERSION_2_1 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.1/Organisations").build().toUriString();
        	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "Brief", brief));
        } else if(apiVersion.in(ApiVersion.VERSION_2_2, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations").build().toUriString();
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

        ParameterizedTypeReference<Organisation> returnType = new ParameterizedTypeReference<Organisation>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates an Organisation Link
     * 
     * <p><b>200</b> - Organisation Link updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Organisation.
     * <p><b>404</b> - Organisation or Organisation Link not found.
     * @param id An Organisation&#39;s ID (ORGANISATION_ID)
     * @param link The Organisation Link to add (just include the JSON object in the request body)
     * @return OrganisationLink
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public OrganisationLink updateOrganisationLink(Long id, OrganisationLink link) throws RestClientException {
        Object postBody = link;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling updateOrganisationLink");
        }
        
        // verify the required parameter 'link' is set
        if (link == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'link' when calling updateOrganisationLink");
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
        	path = UriComponentsBuilder.fromPath("/v2.2/Organisations/{id}/OrganisationLinks").buildAndExpand(uriVariables).toUriString();
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

        ParameterizedTypeReference<OrganisationLink> returnType = new ParameterizedTypeReference<OrganisationLink>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
