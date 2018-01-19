package com.insightly.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import com.insightly.api.util.ApiClient;
import com.insightly.etl.IInsightlyCrmDataEtl.ApiVersion;
import com.insightly.model.CustomFieldMetadata;


@Component("com.insightly.CustomFieldsApi")
public class CustomFieldsApi {
    private ApiClient apiClient;

    public CustomFieldsApi() {
        this(new ApiClient());
    }

    @Autowired
    public CustomFieldsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Gets a list of Custom Fields
     * Use this API call to get a list of custom fields metadata. The properties FIELD_FOR, GROUP_ID, and ORDER_ID can be used to determine which fields belong to a particular object. See CustomFieldGroups if more data on a custom field&#39;s group is needed. A common problem API users have is to reference an invalid CUSTOM_FIELD_ID when referencing custom fields in a newly created or updated object.            If you plan to use custom fields in your API based application, be sure you are working with valid custom field IDs. To add or update custom fields for your Insightly instance, you&#39;ll need to go to the web app to do so.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * @param skip Optional, number of custom fields to skip.
     * @param top Optional, maximum number of custom fields to return in the response.
     * @param countTotal Optional, true if total number of records should be returned in the response headers.
     * @return List&lt;CustomFieldMetadata&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<CustomFieldMetadata> getCustomFields(Integer skip, Integer top, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/CustomFields").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        final ApiVersion apiVersion = apiClient.getAppConfig().getApiVersion();
        
        if(apiVersion.in(ApiVersion.VERSION_2_1, ApiVersion.VERSION_2_2_1)) {
        	path = UriComponentsBuilder.fromPath("/v2.1/CustomFields").build().toUriString();
        	
        	/* Including the 'Brief' query string parameter seems to be touchy, 
        	 * especially when used with the OData filters.
        	 * 
        	 * queryParams.putAll(apiClient.parameterToMultiValueMap(null, "Brief", brief));
        	 */
            
        	queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$skip", skip));
            queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$top", top));
        	/* v2.1 supports filtering by and ordering only for fields that are *directly* on the object
             * Unfortunately, you cannot do the following:
             *  filter by a CustomField component (CUSTOM_FIELD_ID, FIELD_VALUE) in the CUSTOMFIELDS collection
             *  
             *  queryParams.putAll(apiClient.parameterToMultiValueMap(null, "tag", tag));
             */
        } else if(ApiVersion.VERSION_2_2 == apiVersion) {
        	path = UriComponentsBuilder.fromPath("/v2.2/CustomFields").build().toUriString();
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

        ParameterizedTypeReference<List<CustomFieldMetadata>> returnType = new ParameterizedTypeReference<List<CustomFieldMetadata>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
