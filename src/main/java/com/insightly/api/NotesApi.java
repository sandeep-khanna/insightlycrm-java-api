package com.insightly.api;

import com.insightly.api.util.ApiClient;
import com.insightly.model.Comment;
import com.insightly.model.Note;
import com.insightly.model.NoteLink;
import com.insightly.model.Comment;
import com.insightly.model.FileAttachment;
import com.insightly.model.Follow;
import com.insightly.model.Note;
import com.insightly.model.NoteLink;
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


@Component("com.insightly.NotesApi")
public class NotesApi {
    private ApiClient apiClient;

    public NotesApi() {
        this(new ApiClient());
    }

    @Autowired
    public NotesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Adds a Comment to a Note
     * 
     * <p><b>201</b> - Comment added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>402</b> - Record limit reached.
     * <p><b>403</b> - API User does not have access to Note.
     * <p><b>404</b> - Note not found.
     * @param id A Note&#39;s ID (NOTE_ID)
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
        String path = UriComponentsBuilder.fromPath("/Notes/{id}/Comments").buildAndExpand(uriVariables).toUriString();
        
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
     * Adds a File Attachment to a Note
     * This endpoint expects multipart/form-data as the request payload. See Stack Overflow for examples of how to generate multipart requests, or see our &lt;a href&#x3D;\&quot;http://github.com/Insightly\&quot; target&#x3D;\&quot;_blank\&quot;&gt;client libraries&lt;/a&gt; for an example of how this is generated. Only one file can be added per request.
     * <p><b>201</b> - File Attachment added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>402</b> - Record or storage limit reached.
     * <p><b>403</b> - API User does not have access to Note.
     * <p><b>404</b> - Note not found.
     * <p><b>417</b> - File Attachment insert failed.
     * @param id Note ID
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
        String path = UriComponentsBuilder.fromPath("/Notes/{id}/FileAttachments").buildAndExpand(uriVariables).toUriString();
        
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
     * Start following a Note
     * 
     * <p><b>201</b> - Follow added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Note.
     * <p><b>404</b> - Note not found.
     * @param id A Note&#39;s ID (NOTE_ID)
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
        String path = UriComponentsBuilder.fromPath("/Notes/{id}/Follow").buildAndExpand(uriVariables).toUriString();
        
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
     * Adds a Note Link
     * 
     * <p><b>201</b> - Note Link added.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Note.
     * <p><b>404</b> - Note not found.
     * @param id A Note&#39;s ID (NOTE_ID)
     * @param apiLink The Note Link to add (just include JSON object as request body)
     * @return NoteLink
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public NoteLink addNoteLink(Long id, NoteLink apiLink) throws RestClientException {
        Object postBody = apiLink;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling addNoteLink");
        }
        
        // verify the required parameter 'apiLink' is set
        if (apiLink == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiLink' when calling addNoteLink");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Notes/{id}/NoteLinks").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<NoteLink> returnType = new ParameterizedTypeReference<NoteLink>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Stop following a Note
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Note.
     * <p><b>404</b> - Note not found.
     * <p><b>417</b> - Delete failed.
     * @param id A Note&#39;s ID (NOTE_ID)
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
        String path = UriComponentsBuilder.fromPath("/Notes/{id}/Follow").buildAndExpand(uriVariables).toUriString();
        
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
     * Deletes a Note
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Note.
     * <p><b>404</b> - Note not found.
     * <p><b>417</b> - Delete failed.
     * @param id A Note&#39;s ID
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteNote(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteNote");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Notes/{id}").buildAndExpand(uriVariables).toUriString();
        
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
     * Deletes a Note Link
     * 
     * <p><b>202</b> - Delete succeeded.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Note.
     * <p><b>404</b> - Note or Note Link not found.
     * <p><b>417</b> - Delete failed.
     * @param id A Note&#39;s ID (NOTE_ID)
     * @param linkId A Note Link&#39;s ID (NOTE_LINK_ID)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteNoteLink(Long id, Long linkId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling deleteNoteLink");
        }
        
        // verify the required parameter 'linkId' is set
        if (linkId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'linkId' when calling deleteNoteLink");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("linkId", linkId);
        String path = UriComponentsBuilder.fromPath("/Notes/{id}/NoteLinks/{linkId}").buildAndExpand(uriVariables).toUriString();
        
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
     * Gets a Note&#39;s Comments
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Note.
     * <p><b>404</b> - Note not found.
     * @param id A Note&#39;s ID (NOTE_ID)
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
        String path = UriComponentsBuilder.fromPath("/Notes/{id}/Comments").buildAndExpand(uriVariables).toUriString();
        
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
     * Gets a Note&#39;s File Attachments
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Note.
     * <p><b>404</b> - Note not found.
     * @param id A Note&#39;s ID (NOTE_ID)
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
        String path = UriComponentsBuilder.fromPath("/Notes/{id}/FileAttachments").buildAndExpand(uriVariables).toUriString();
        
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
     * Gets a Follow record for the Note
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Note.
     * <p><b>404</b> - Note not found.
     * @param id A Note&#39;s ID (NOTE_ID)
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
        String path = UriComponentsBuilder.fromPath("/Notes/{id}/Follow").buildAndExpand(uriVariables).toUriString();
        
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
     * Gets a Note
     * 
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Note.
     * <p><b>404</b> - Note not found.
     * @param id A Note&#39;s ID
     * @return Note
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Note getNote(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getNote");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/Notes/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Note> returnType = new ParameterizedTypeReference<Note>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a list of Notes.
     * Simple object graphs (excluding NOTELINKS) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * @param brief Optional, true if response should only contain top level properties of the note.
     * @param skip Optional, number of notes to skip.
     * @param top Optional, maximum number of notes to return in the response.
     * @param countTotal Optional, true if total number of records should be returned in the response headers.
     * @return List&lt;Note&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Note> getNotes(Boolean brief, Integer skip, Integer top, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/Notes").build().toUriString();
        
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

        ParameterizedTypeReference<List<Note>> returnType = new ParameterizedTypeReference<List<Note>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a filtered list of Notes.
     * Only one optional parameter (excluding top, skip and count_total) can be specified. Simple object graphs (excluding NOTELINKS) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.
     * <p><b>200</b> - Request succeeded.
     * <p><b>400</b> - Often missing or invalid parameter.
     * <p><b>401</b> - Authentication failed.
     * @param title Optional, note title.
     * @param ownerUserId Optional, id of the owner user.
     * @param updatedAfterUtc Optional, earliest date when note was last updated.
     * @param brief Optional, true if response should only contain top level properties of the note.
     * @param skip Optional, number of notes to skip.
     * @param top Optional, maximum number of notes to return in the response.
     * @param countTotal Optional, true if total number of records should be returned in the response headers.
     * @return List&lt;Note&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Note> getNotesBySearch(String title, Long ownerUserId, OffsetDateTime updatedAfterUtc, Boolean brief, Integer skip, Integer top, Boolean countTotal) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/Notes/Search").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "title", title));
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

        ParameterizedTypeReference<List<Note>> returnType = new ParameterizedTypeReference<List<Note>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Updates a Note
     * 
     * <p><b>200</b> - Note updated.
     * <p><b>400</b> - Data validation error.
     * <p><b>401</b> - Authentication failed.
     * <p><b>403</b> - API User does not have access to Note.
     * <p><b>404</b> - Note not found.
     * @param apiNote The Note to add (just include JSON object as request body)
     * @param brief Optional, true if you wish to do a partial update containing only top level properties of the Note. When true, all sub-collections are ignored.
     * @return Note
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Note updateNote(Note apiNote, Boolean brief) throws RestClientException {
        Object postBody = apiNote;
        
        // verify the required parameter 'apiNote' is set
        if (apiNote == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'apiNote' when calling updateNote");
        }
        
        String path = UriComponentsBuilder.fromPath("/Notes").build().toUriString();
        
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

        ParameterizedTypeReference<Note> returnType = new ParameterizedTypeReference<Note>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
