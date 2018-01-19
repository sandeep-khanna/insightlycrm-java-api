package com.insightly.api;

import com.insightly.api.util.ApiClient;
import com.insightly.model.Team;
import com.insightly.model.TeamMember;
import java.time.OffsetDateTime;
import com.insightly.model.Team;
import com.insightly.model.TeamMember;

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


@Component("com.insightly.TeamsApi")
public class TeamsApi {
    private ApiClient apiClient;

    public TeamsApi() {
        this(new ApiClient());
    }

    @Autowired
    public TeamsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Adds a Team
     * TEAM_NAME is required when creating a Team with ANONYMOUS_TEAM set to \&quot;false\&quot;. When creating Anonymous Teams, e.g. ANONYMOUS_TEAM&#x3D;true, you must include all the Team Members that should be part of the team. A minimum of one Team Member is required.             For more details, please refer to GET /Teams above.
     * <p><b>201</b> - Team added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Invalid api key provided.
     * @param apiTeam The Team to add (just include JSON object as request body)
     * @return Team
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Team addTeam(Team apiTeam) throws RestClientException {
        Object postBody = apiTeam;
        
        // verify the required parameter 'apiTeam' is set
        if (apiTeam == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiTeam' when calling addTeam");
        }
        
        String path = UriComponentsBuilder.fromPath("/Teams").build().toUriString();
        
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

        ParameterizedTypeReference<Team> returnType = new ParameterizedTypeReference<Team>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Adds a Team Member
     * 
     * <p><b>201</b> - Team Member added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Invalid api key provided.
     * <p><b>404</b> - Team not found.
     * @param id A Team&#39;s ID (TEAM_ID)
     * @param apiTeamMember The Team Member to add (just include JSON object as request body)
     * @return TeamMember
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TeamMember addTeamMember(Long id, TeamMember apiTeamMember) throws RestClientException {
        Object postBody = apiTeamMember;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling addTeamMember");
        }
        
        // verify the required parameter 'apiTeamMember' is set
        if (apiTeamMember == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiTeamMember' when calling addTeamMember");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Teams/{id}/TeamMembers").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<TeamMember> returnType = new ParameterizedTypeReference<TeamMember>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Deletes a Team
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Invalid api key provided.
     * <p><b>404</b> - Team not found.
     * <p><b>417</b> - Delete failed.
     * @param id A Team&#39;s ID
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteTeam(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteTeam");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Teams/{id}").buildAndExpand(uriVariables).toUriString();
        
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
     * Deletes a Team Member
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Invalid api key provided.
     * <p><b>404</b> - Team or Team Member not found.
     * <p><b>417</b> - Delete failed.
     * @param id A Team&#39;s ID (TEAM_ID)
     * @param permissionId A Team Members&#39;s ID (PERMISSION_ID)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteTeamMember(Long id, Long permissionId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteTeamMember");
        }
        
        // verify the required parameter 'permissionId' is set
        if (permissionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'permissionId' when calling deleteTeamMember");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("permissionId", permissionId);
        String path = UriComponentsBuilder.fromPath("/Teams/{id}/TeamMembers/{permissionId}").buildAndExpand(uriVariables).toUriString();
        
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
     * Gets a Team
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Invalid api key provided.
     * <p><b>404</b> - Team not found.
     * @param id A Team&#39;s ID
     * @return Team
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Team getTeam(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getTeam");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Teams/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Team> returnType = new ParameterizedTypeReference<Team>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a list of Teams.
     * Simple object graphs (excluding TEAMMEMBERS) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.            &lt;br /&gt; The API responses may contain two types of Teams: a) regular Teams configured via System Settings and b) so called Anonymous Teams which are created by the system when you set a record permission visible to Individuals.            You can differentiate these two types on Teams by the ANONYMOUS_TEAM property. Anonymous Teams are a bit more restricted when it comes to modifying them via the API, they can only be created/updated/deleted via the root /Teams endpoint.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Invalid api key provided.
     * @param brief Optional, true if response should only contain top level properties of the team.
     * @param skip Optional, number of teams to skip.
     * @param top Optional, maximum number of teams to return in the response.
     * @param countTotal Optional, true if total number of records should be returned in the response headers.
     * @return List&lt;Team&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Team> getTeams(Boolean brief, Integer skip, Integer top, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/Teams").build().toUriString();
        
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

        ParameterizedTypeReference<List<Team>> returnType = new ParameterizedTypeReference<List<Team>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a filtered list of Teams.
     * Only one optional parameter (excluding brief, top, skip and count_total) can be specified. Simple object graphs (excluding TEAMMEMBERS) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.             &lt;br /&gt; The API responses may contain two types of Teams: a) regular Teams configured via System Settings and b) so called Anonymous Teams which are created by the system when you set a record permission visible to Individuals.            You can differentiate these two types on Teams by the ANONYMOUS_TEAM property. Anonymous Teams are a bit more restricted when it comes to modifying them via the API, they can only be created/updated/deleted via the /Teams endpoint.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Invalid api key provided.
     * @param teamName Optional, name of the team.
     * @param updatedAfterUtc Optional, earliest date when team was last updated.
     * @param brief Optional, true if response should only contain top level properties of the team.
     * @param skip Optional, number of teams to skip.
     * @param top Optional, maximum number of teams to return in the response.
     * @param countTotal Optional, true if total number of records should be returned in the response headers.
     * @return List&lt;Team&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Team> getTeamsBySearch(String teamName, OffsetDateTime updatedAfterUtc, Boolean brief, Integer skip, Integer top, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/Teams/Search").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "team_name", teamName));
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

        ParameterizedTypeReference<List<Team>> returnType = new ParameterizedTypeReference<List<Team>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates a Team
     * When updating Anonymous Teams, the brief parameter has no effect and you must include all the Team Members that should be part of the team. A minimum of one Team Member is required.  For more details, please refer to GET /Teams above.
     * <p><b>200</b> - Team updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Invalid api key provided.
     * <p><b>404</b> - Team not found.
     * @param apiTeam The Team to update (just include JSON object as request body)
     * @param brief Optional, true if you wish to do a partial update containing only top level properties of the Team. When true, all sub-collections are ignored.
     * @return Team
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Team updateTeam(Team apiTeam, Boolean brief) throws RestClientException {
        Object postBody = apiTeam;
        
        // verify the required parameter 'apiTeam' is set
        if (apiTeam == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiTeam' when calling updateTeam");
        }
        
        String path = UriComponentsBuilder.fromPath("/Teams").build().toUriString();
        
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

        ParameterizedTypeReference<Team> returnType = new ParameterizedTypeReference<Team>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
