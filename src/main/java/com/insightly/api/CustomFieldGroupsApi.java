package com.insightly.api;

import com.insightly.api.util.ApiClient;
import com.insightly.model.CustomFieldGroup;

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


@Component("com.insightly.CustomFieldGroupsApi")
public class CustomFieldGroupsApi {
    private ApiClient apiClient;

    public CustomFieldGroupsApi() {
        this(new ApiClient());
    }

    @Autowired
    public CustomFieldGroupsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Gets a list of Custom Field Groups defined for your instance
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * @param skip Optional, number of custom field groups to skip.
     * @param top Optional, maximum number of custom field groups to return in the response.
     * @param countTotal Optional, true if total number of records should be returned in the response headers.
     * @return List&lt;CustomFieldGroup&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<CustomFieldGroup> getCustomFieldGroups(Integer skip, Integer top, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/CustomFieldGroups").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
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

        ParameterizedTypeReference<List<CustomFieldGroup>> returnType = new ParameterizedTypeReference<List<CustomFieldGroup>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
