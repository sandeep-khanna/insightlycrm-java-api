package com.insightly.api;

import com.insightly.api.util.ApiClient;
import com.insightly.model.Category;
import com.insightly.model.Category;

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


@Component("com.insightly.OpportunityCategoriesApi")
public class OpportunityCategoriesApi {
    private ApiClient apiClient;

    public OpportunityCategoriesApi() {
        this(new ApiClient());
    }

    @Autowired
    public OpportunityCategoriesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Adds an Opportunity Category
     * This endpoint is used to create a new opportunity category. This endpoint is only accessible to users with administrator permission.
     * <p><b>201</b> - Opportunity Category added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have permission to add Opportunity Categories.
     * @param category The Opportunity Category to add (just include JSON object as request body)
     * @return Category
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Category addOpportunityCategory(Category category) throws RestClientException {
        Object postBody = category;
        
        // verify the required parameter 'category' is set
        if (category == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'category' when calling addOpportunityCategory");
        }
        
        String path = UriComponentsBuilder.fromPath("/OpportunityCategories").build().toUriString();
        
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

        ParameterizedTypeReference<Category> returnType = new ParameterizedTypeReference<Category>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Deactivates an Opportunity Category
     * The endpoint is used to deactivate an existing opportunity category. This endpoint is only accessible to users with administrator permission.
     * <p><b>202</b> - Deactivation succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have permission to deactivate Opportunity Categories.
     * <p><b>404</b> - Opportunity Category not found.
     * <p><b>409</b> - Opportunity Category cannot be deactivated because it&#39;s in use or already deactivated.
     * <p><b>417</b> - Deactivation failed.
     * @param id An Opportunity Category&#39;s ID
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteOpportunityCategory(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteOpportunityCategory");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/OpportunityCategories/{id}").buildAndExpand(uriVariables).toUriString();
        
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
     * Gets a list of Opportunity Categories
     * This read only endpoint returns a list of opportunity categories set up for the Insightly instance.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * @param skip Optional, number of categories to skip.
     * @param top Optional, maximum number of categories to return in the response.
     * @param countTotal Optional, true if total number of records should be returned in the response headers.
     * @return List&lt;Category&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Category> getOpportunityCategories(Integer skip, Integer top, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/OpportunityCategories").build().toUriString();
        
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

        ParameterizedTypeReference<List<Category>> returnType = new ParameterizedTypeReference<List<Category>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets an Opportunity Category
     * This endpoint returns the graph for a specific opportunity category
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>404</b> - Opportunity Category not found.
     * @param id An Opportunity Category&#39;s ID
     * @return Category
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Category getOpportunityCategory(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getOpportunityCategory");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/OpportunityCategories/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Category> returnType = new ParameterizedTypeReference<Category>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates an Opportunity Category
     * This endpoint is used to update an existing opportunity category (for example, to change the background color for its label in the user interace). This endpoint is only accessible to users with administrator permission.
     * <p><b>200</b> - Opportunity Category updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have permission to edit Opportunity Categories.
     * <p><b>404</b> - Opportunity Category not found.
     * <p><b>409</b> - Opportunity Category cannot be updated because it has been deactivated.
     * @param category An Opportunity Category (just include JSON object as request body)
     * @return Category
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Category updateOpportunityCategory(Category category) throws RestClientException {
        Object postBody = category;
        
        // verify the required parameter 'category' is set
        if (category == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'category' when calling updateOpportunityCategory");
        }
        
        String path = UriComponentsBuilder.fromPath("/OpportunityCategories").build().toUriString();
        
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

        ParameterizedTypeReference<Category> returnType = new ParameterizedTypeReference<Category>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
