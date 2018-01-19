package com.insightly.api;

import com.insightly.api.util.ApiClient;
import com.insightly.model.CalendarEvent;
import com.insightly.model.EventLink;
import com.insightly.model.CalendarEvent;
import com.insightly.model.EventLink;
import java.time.OffsetDateTime;

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


@Component("com.insightly.EventsApi")
public class EventsApi {
    private ApiClient apiClient;

    public EventsApi() {
        this(new ApiClient());
    }

    @Autowired
    public EventsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Adds a Calendar Event
     * 
     * <p><b>201</b> - Event added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>402</b> - Record limit reached.
     * @param apiEvent The Event to add (just include JSON object as request body)
     * @return CalendarEvent
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CalendarEvent addEvent(CalendarEvent apiEvent) throws RestClientException {
        Object postBody = apiEvent;
        
        // verify the required parameter 'apiEvent' is set
        if (apiEvent == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiEvent' when calling addEvent");
        }
        
        String path = UriComponentsBuilder.fromPath("/Events").build().toUriString();
        
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

        ParameterizedTypeReference<CalendarEvent> returnType = new ParameterizedTypeReference<CalendarEvent>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Adds an Event Link
     * 
     * <p><b>201</b> - Event Link added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Event.
     * <p><b>404</b> - Event not found.
     * @param id An Event&#39;s ID (EVENT_ID)
     * @param apiLink The Event Link to add (just include JSON object as request body)
     * @return EventLink
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public EventLink addEventLink(Long id, EventLink apiLink) throws RestClientException {
        Object postBody = apiLink;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling addEventLink");
        }
        
        // verify the required parameter 'apiLink' is set
        if (apiLink == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiLink' when calling addEventLink");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Events/{id}/EventLinks").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<EventLink> returnType = new ParameterizedTypeReference<EventLink>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Deletes a Calendar Event
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Event.
     * <p><b>404</b> - Event not found.
     * <p><b>417</b> - Delete failed.
     * @param id An Event&#39;s ID
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteEvent(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteEvent");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Events/{id}").buildAndExpand(uriVariables).toUriString();
        
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
     * Deletes an Event Link
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Event.
     * <p><b>404</b> - Event or Event Link not found.
     * <p><b>417</b> - Delete failed.
     * @param id An Event&#39;s ID (EVENT_ID)
     * @param linkId A EVENT Link&#39;s ID (EVENT_LINK_ID)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteEventLink(Long id, Long linkId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteEventLink");
        }
        
        // verify the required parameter 'linkId' is set
        if (linkId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'linkId' when calling deleteEventLink");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("linkId", linkId);
        String path = UriComponentsBuilder.fromPath("/Events/{id}/EventLinks/{linkId}").buildAndExpand(uriVariables).toUriString();
        
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
     * Gets a Calendar Event
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Event.
     * <p><b>404</b> - Event not found.
     * @param id An Event&#39;s ID
     * @return CalendarEvent
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CalendarEvent getEvent(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getEvent");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Events/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<CalendarEvent> returnType = new ParameterizedTypeReference<CalendarEvent>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a list of Calendar Events.
     * Simple object graphs (excluding EVENTLINKS) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * @param brief Optional, true if response should only contain top level properties of the event.
     * @param skip Optional, number of events to skip.
     * @param top Optional, maximum number of events to return in the response.
     * @param countTotal Optional, true if total number of records should be returned in the response headers.
     * @return List&lt;CalendarEvent&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<CalendarEvent> getEvents(Boolean brief, Integer skip, Integer top, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/Events").build().toUriString();
        
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

        ParameterizedTypeReference<List<CalendarEvent>> returnType = new ParameterizedTypeReference<List<CalendarEvent>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a filtered list of Calendar Events.
     * Only one optional parameter (excluding top, skip and count_total) can be specified. Simple object graphs (excluding EVENTLINKS) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * @param title Optional, event title.
     * @param ownerUserId Optional, id of the owner user.
     * @param startDateUtc Optional, start date of the event. Only the date is considered, not the time.
     * @param endDateUtc Optional, end date of the event. Only the date is considered, not the time.
     * @param updatedAfterUtc Optional, earliest date when event was last updated. Date and time are considered.
     * @param brief Optional, true if response should only contain top level properties of the event.
     * @param skip Optional, number of events to skip.
     * @param top Optional, maximum number of events to return in the response.
     * @param countTotal Optional, true if total number of records should be returned in the response headers.
     * @return List&lt;CalendarEvent&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<CalendarEvent> getEventsBySearch(String title, Long ownerUserId, OffsetDateTime startDateUtc, OffsetDateTime endDateUtc, OffsetDateTime updatedAfterUtc, Boolean brief, Integer skip, Integer top, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/Events/Search").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "title", title));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "owner_user_id", ownerUserId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "start_date_utc", startDateUtc));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "end_date_utc", endDateUtc));
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

        ParameterizedTypeReference<List<CalendarEvent>> returnType = new ParameterizedTypeReference<List<CalendarEvent>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates a Calendar Event
     * 
     * <p><b>200</b> - Event updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Event.
     * <p><b>404</b> - Event not found.
     * @param apiEvent The Event to update (just include JSON object as request body)
     * @param brief Optional, true if you wish to do a partial update containing only top level properties of the Event. When true, all sub-collections are ignored.
     * @return CalendarEvent
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CalendarEvent updateEvent(CalendarEvent apiEvent, Boolean brief) throws RestClientException {
        Object postBody = apiEvent;
        
        // verify the required parameter 'apiEvent' is set
        if (apiEvent == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiEvent' when calling updateEvent");
        }
        
        String path = UriComponentsBuilder.fromPath("/Events").build().toUriString();
        
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

        ParameterizedTypeReference<CalendarEvent> returnType = new ParameterizedTypeReference<CalendarEvent>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
