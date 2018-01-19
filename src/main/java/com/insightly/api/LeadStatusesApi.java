package com.insightly.api;

import com.insightly.api.util.ApiClient;
import com.insightly.model.LeadStatus;
import com.insightly.model.LeadStatus;

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


@Component("com.insightly.LeadStatusesApi")
public class LeadStatusesApi {
    private ApiClient apiClient;

    public LeadStatusesApi() {
        this(new ApiClient());
    }

    @Autowired
    public LeadStatusesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Adds a Lead Status
     * This endpoint is used to add a new lead status option to the instance. This endpoint is only accessible to users with administrator access.
     * <p><b>201</b> - Lead Status added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have permission to add Lead Statuses or Lead Management disabled.
     * @param leadStatus The Lead Status to add
     * @return LeadStatus
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public LeadStatus addLeadStatus(LeadStatus leadStatus) throws RestClientException {
        Object postBody = leadStatus;
        
        // verify the required parameter 'leadStatus' is set
        if (leadStatus == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'leadStatus' when calling addLeadStatus");
        }
        
        String path = UriComponentsBuilder.fromPath("/LeadStatuses").build().toUriString();
        
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

        ParameterizedTypeReference<LeadStatus> returnType = new ParameterizedTypeReference<LeadStatus>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Deletes a Lead Status
     * This endpoint is used to delete an existing lead status.
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have permission to delete Lead Statuses or Lead Management disabled.
     * <p><b>404</b> - Lead Status not found.
     * <p><b>409</b> - Lead Status cannot be deleted because it&#39;s in use or if you only have one OPEN and one CLOSED Lead Status in your instance.
     * <p><b>417</b> - Delete failed.
     * @param id A Lead Status&#39;s ID
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteLeadStatus(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteLeadStatus");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/LeadStatuses/{id}").buildAndExpand(uriVariables).toUriString();
        
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
     * Gets a list of Lead Statuses
     * This endpoint returns a list of the possible lead statuses that have been defined for the Insightly instance.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - Lead Management disabled.
     * @param includeConverted Optional, by default converted status is not included, pass in \&quot;true\&quot; to include it in the response
     * @param skip Optional, number of lead statuses to skip.
     * @param top Optional, maximum number of lead statuses to return in the response.
     * @param countTotal Optional, true if total number of records should be returned in the response headers.
     * @return List&lt;LeadStatus&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<LeadStatus> getLeadStatuses(Boolean includeConverted, Integer skip, Integer top, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/LeadStatuses").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include_converted", includeConverted));
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

        ParameterizedTypeReference<List<LeadStatus>> returnType = new ParameterizedTypeReference<List<LeadStatus>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates a Lead Status
     * This endpoint is used to update an existing lead status. This endpoint is only accessible to users with administrator access.
     * <p><b>200</b> - Lead Status updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have permission to edit Lead Statuses or Lead Management disabled.
     * <p><b>404</b> - Lead Status not found.
     * @param leadStatus A Lead Status
     * @return LeadStatus
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public LeadStatus updateLeadStatus(LeadStatus leadStatus) throws RestClientException {
        Object postBody = leadStatus;
        
        // verify the required parameter 'leadStatus' is set
        if (leadStatus == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'leadStatus' when calling updateLeadStatus");
        }
        
        String path = UriComponentsBuilder.fromPath("/LeadStatuses").build().toUriString();
        
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

        ParameterizedTypeReference<LeadStatus> returnType = new ParameterizedTypeReference<LeadStatus>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
