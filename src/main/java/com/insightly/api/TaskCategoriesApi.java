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


@Component("com.insightly.TaskCategoriesApi")
public class TaskCategoriesApi {
    private ApiClient apiClient;

    public TaskCategoriesApi() {
        this(new ApiClient());
    }

    @Autowired
    public TaskCategoriesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Adds a Task Category
     * This endpoint is used to create a new task category. This endpoint is only accessible to users with administrator permission.
     * <p><b>201</b> - Task Category added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have permission to add Task Categories.
     * @param category The Task Category to add (just include JSON object as request body)
     * @return Category
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Category addTaskCategory(Category category) throws RestClientException {
        Object postBody = category;
        
        // verify the required parameter 'category' is set
        if (category == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'category' when calling addTaskCategory");
        }
        
        String path = UriComponentsBuilder.fromPath("/TaskCategories").build().toUriString();
        
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
     * Deactivates a Task Category
     * This endpoint is used to deactivate a task category. This endpoint is only accessible to users with administrator permission.
     * <p><b>202</b> - Deactivation succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have permission to deactivate Task Categories.
     * <p><b>404</b> - Task Category not found.
     * <p><b>409</b> - Task Category cannot be deactivated because it&#39;s in use or already deactivated.
     * <p><b>417</b> - Deactivation failed.
     * @param id A Task Category&#39;s ID
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteTaskCategory(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteTaskCategory");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/TaskCategories/{id}").buildAndExpand(uriVariables).toUriString();
        
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
     * Gets a list of Task Categories
     * This read only endpoint returns a list of the task categories set up for the Insightly instance.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * @param skip Optional, number of records to skip.
     * @param top Optional, maximum number of records to return in the response.
     * @param countTotal Optional, true if total number of records should be returned in the response headers.
     * @return List&lt;Category&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Category> getTaskCategories(Integer skip, Integer top, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/TaskCategories").build().toUriString();
        
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
     * Gets a Task Category
     * This endpoint returns the graph for a specific task category.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>404</b> - Task Category not found.
     * @param id A Task Category&#39;s ID
     * @return Category
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Category getTaskCategory(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getTaskCategory");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/TaskCategories/{id}").buildAndExpand(uriVariables).toUriString();
        
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
     * Updates a Task Category
     * This endpoint is used to update an existing task category, for example to change the background color for the task category&#39;s label in the web UI. This endpoint is only accessible to users with administrator permission.
     * <p><b>200</b> - Task Category updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have permission to edit Task Categories.
     * <p><b>404</b> - Task Category not found.
     * <p><b>409</b> - Task Category cannot be updated because it has been deactivated.
     * @param category A Task Category (just include JSON object as request body)
     * @return Category
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Category updateTaskCategory(Category category) throws RestClientException {
        Object postBody = category;
        
        // verify the required parameter 'category' is set
        if (category == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'category' when calling updateTaskCategory");
        }
        
        String path = UriComponentsBuilder.fromPath("/TaskCategories").build().toUriString();
        
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
