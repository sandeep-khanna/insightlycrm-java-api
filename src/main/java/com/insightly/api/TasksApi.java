package com.insightly.api;

import com.insightly.api.util.ApiClient;
import com.insightly.model.Comment;
import com.insightly.model.Task;
import com.insightly.model.TaskLink;
import com.insightly.model.Comment;
import com.insightly.model.Follow;
import java.time.OffsetDateTime;
import com.insightly.model.Task;
import com.insightly.model.TaskLink;

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


@Component("com.insightly.TasksApi")
public class TasksApi {
    private ApiClient apiClient;

    public TasksApi() {
        this(new ApiClient());
    }

    @Autowired
    public TasksApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Adds a Comment to a task.
     * 
     * <p><b>201</b> - Comment added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>402</b> - Record limit reached.
     * <p><b>403</b> - API User does not have access to Task.
     * <p><b>404</b> - Task not found.
     * @param id A Task&#39;s ID (TASK_ID)
     * @param apiComment The Comment to add (just include JSON object as request body)
     * @return Comment
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Comment addComment(Long id, Comment apiComment) throws RestClientException {
        Object postBody = apiComment;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling addComment");
        }
        
        // verify the required parameter 'apiComment' is set
        if (apiComment == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiComment' when calling addComment");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Tasks/{id}/Comments").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Comment> returnType = new ParameterizedTypeReference<Comment>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Start following a Task
     * 
     * <p><b>201</b> - Follow added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Task.
     * <p><b>404</b> - Task not found.
     * @param id A Task&#39;s ID (TASK_ID)
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
        String path = UriComponentsBuilder.fromPath("/Tasks/{id}/Follow").buildAndExpand(uriVariables).toUriString();
        
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
     * Adds a Task
     * A common source of problems when creating tasks occurs when users omit required fields, or insert             invalid data into a field. A good troubleshooting technique             is to create a few tasks via the web interface, with representative data, links, etc, and then access             these tasks via the API, and inspect the returned object graph.
     * <p><b>201</b> - Task added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>402</b> - Record limit reached.
     * @param apiTask The Task to add (just include JSON object as request body)
     * @return Task
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Task addTask(Task apiTask) throws RestClientException {
        Object postBody = apiTask;
        
        // verify the required parameter 'apiTask' is set
        if (apiTask == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiTask' when calling addTask");
        }
        
        String path = UriComponentsBuilder.fromPath("/Tasks").build().toUriString();
        
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

        ParameterizedTypeReference<Task> returnType = new ParameterizedTypeReference<Task>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Adds a Task Link
     * 
     * <p><b>201</b> - Task Link added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Task.
     * <p><b>404</b> - Task not found.
     * @param id A Task&#39;s ID (TASK_ID)
     * @param apiLink The Task Link to add (just include JSON object as request body)
     * @return TaskLink
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TaskLink addTaskLink(Long id, TaskLink apiLink) throws RestClientException {
        Object postBody = apiLink;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling addTaskLink");
        }
        
        // verify the required parameter 'apiLink' is set
        if (apiLink == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiLink' when calling addTaskLink");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Tasks/{id}/TaskLinks").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<TaskLink> returnType = new ParameterizedTypeReference<TaskLink>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Stop following a Task
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Task.
     * <p><b>404</b> - Task not found.
     * <p><b>417</b> - Delete failed.
     * @param id A Task&#39;s ID (TASK_ID)
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
        String path = UriComponentsBuilder.fromPath("/Tasks/{id}/Follow").buildAndExpand(uriVariables).toUriString();
        
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
     * Deletes a Task
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Task.
     * <p><b>404</b> - Task not found.
     * <p><b>417</b> - Delete failed.
     * @param id A Task&#39;s ID
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteTask(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteTask");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Tasks/{id}").buildAndExpand(uriVariables).toUriString();
        
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
     * Deletes a Task Link
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Task.
     * <p><b>404</b> - Task or Task Link not found.
     * <p><b>417</b> - Delete failed.
     * @param id A Task&#39;s ID (TASK_ID)
     * @param linkId A Task Link&#39;s ID (TASK_LINK_ID)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteTaskLink(Long id, Long linkId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteTaskLink");
        }
        
        // verify the required parameter 'linkId' is set
        if (linkId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'linkId' when calling deleteTaskLink");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("linkId", linkId);
        String path = UriComponentsBuilder.fromPath("/Tasks/{id}/TaskLinks/{linkId}").buildAndExpand(uriVariables).toUriString();
        
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
     * Gets a Task&#39;s Comments
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Task.
     * <p><b>404</b> - Task not found.
     * @param id A Task&#39;s ID (TASK_ID)
     * @param updatedAfterUtc Optional, earliest date when comment was last updated.
     * @param skip Optional, number of comments to skip.
     * @param top Optional, maximum number of comments to return in the response.
     * @param countTotal true if total number of records should be returned in the response headers.
     * @return List&lt;Comment&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Comment> getComments(Long id, OffsetDateTime updatedAfterUtc, Integer skip, Integer top, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getComments");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Tasks/{id}/Comments").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<List<Comment>> returnType = new ParameterizedTypeReference<List<Comment>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a Follow record for the Task
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Task.
     * <p><b>404</b> - Task not found.
     * @param id A Task&#39;s ID (TASK_ID)
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
        String path = UriComponentsBuilder.fromPath("/Tasks/{id}/Follow").buildAndExpand(uriVariables).toUriString();
        
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
     * Gets a Task
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Task.
     * <p><b>404</b> - Task not found.
     * @param id A Task&#39;s ID
     * @return Task
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Task getTask(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getTask");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Tasks/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Task> returnType = new ParameterizedTypeReference<Task>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a list of Tasks.
     * Simple object graphs (excluding TASKLINKS) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * @param brief Optional, true if response should only contain top level properties of the task.
     * @param skip Optional, number of tasks to skip.
     * @param top Optional, maximum number of tasks to return in the response.
     * @param countTotal Optional, true if total number of records should be returned in the response headers.
     * @return List&lt;Task&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Task> getTasks(Boolean brief, Integer skip, Integer top, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/Tasks").build().toUriString();
        
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

        ParameterizedTypeReference<List<Task>> returnType = new ParameterizedTypeReference<List<Task>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a filtered list of Tasks.
     * Only one optional parameter (excluding brief, top, skip and count_total) can be specified. Simple object graphs (excluding TASKLINKS) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * @param title Optional, task title.
     * @param status Optional, status of the task.
     * @param categoryId Optional, category id.
     * @param ownerUserId Optional, id of the owner user.
     * @param updatedAfterUtc Optional, earliest date when task was last updated.
     * @param brief Optional, true if response should only contain top level properties of the task.
     * @param skip Optional, number of tasks to skip.
     * @param top Optional, maximum number of tasks to return in the response.
     * @param countTotal Optional, true if total number of records should be returned in the response headers.
     * @return List&lt;Task&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Task> getTasksBySearch(String title, String status, Long categoryId, Long ownerUserId, OffsetDateTime updatedAfterUtc, Boolean brief, Integer skip, Integer top, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/Tasks/Search").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "title", title));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "status", status));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "category_id", categoryId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "owner_user_id", ownerUserId));
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

        ParameterizedTypeReference<List<Task>> returnType = new ParameterizedTypeReference<List<Task>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates a Task
     * A common source of problems when updating tasks occurs when users omit required fields, or insert             invalid data into a field. A good troubleshooting technique             is to create a few tasks via the web interface, with representative data, links, etc, and then access             these tasks via the API, and inspect the returned object graph.
     * <p><b>200</b> - Task updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Task.
     * <p><b>404</b> - Task not found.
     * @param apiTask The Task to update (just include JSON object as request body)
     * @param brief Optional, true if you wish to do a partial update containing only top level properties of the Task. When true, all sub-collections are ignored.
     * @return Task
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Task updateTask(Task apiTask, Boolean brief) throws RestClientException {
        Object postBody = apiTask;
        
        // verify the required parameter 'apiTask' is set
        if (apiTask == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiTask' when calling updateTask");
        }
        
        String path = UriComponentsBuilder.fromPath("/Tasks").build().toUriString();
        
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

        ParameterizedTypeReference<Task> returnType = new ParameterizedTypeReference<Task>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
