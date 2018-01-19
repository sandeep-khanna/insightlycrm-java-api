# NotesApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addComment**](NotesApi.md#addComment) | **POST** /Notes/{id}/Comments | Adds a Comment to a Note
[**addFileAttachment**](NotesApi.md#addFileAttachment) | **POST** /Notes/{id}/FileAttachments | Adds a File Attachment to a Note
[**addFollow**](NotesApi.md#addFollow) | **POST** /Notes/{id}/Follow | Start following a Note
[**addNoteLink**](NotesApi.md#addNoteLink) | **POST** /Notes/{id}/NoteLinks | Adds a Note Link
[**deleteFollow**](NotesApi.md#deleteFollow) | **DELETE** /Notes/{id}/Follow | Stop following a Note
[**deleteNote**](NotesApi.md#deleteNote) | **DELETE** /Notes/{id} | Deletes a Note
[**deleteNoteLink**](NotesApi.md#deleteNoteLink) | **DELETE** /Notes/{id}/NoteLinks/{linkId} | Deletes a Note Link
[**getComments**](NotesApi.md#getComments) | **GET** /Notes/{id}/Comments | Gets a Note&#39;s Comments
[**getFileAttachments**](NotesApi.md#getFileAttachments) | **GET** /Notes/{id}/FileAttachments | Gets a Note&#39;s File Attachments
[**getFollow**](NotesApi.md#getFollow) | **GET** /Notes/{id}/Follow | Gets a Follow record for the Note
[**getNote**](NotesApi.md#getNote) | **GET** /Notes/{id} | Gets a Note
[**getNotes**](NotesApi.md#getNotes) | **GET** /Notes | Gets a list of Notes.
[**getNotesBySearch**](NotesApi.md#getNotesBySearch) | **GET** /Notes/Search | Gets a filtered list of Notes.
[**updateNote**](NotesApi.md#updateNote) | **PUT** /Notes | Updates a Note


<a name="addComment"></a>
# **addComment**
> Comment addComment(id, apiComment)

Adds a Comment to a Note

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.NotesApi;


NotesApi apiInstance = new NotesApi();
Long id = 789L; // Long | A Note's ID (NOTE_ID)
Comment apiComment = new Comment(); // Comment | The Comment to add (just include JSON object as request body)
try {
    Comment result = apiInstance.addComment(id, apiComment);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotesApi#addComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Note&#39;s ID (NOTE_ID) |
 **apiComment** | [**Comment**](Comment.md)| The Comment to add (just include JSON object as request body) |

### Return type

[**Comment**](Comment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addFileAttachment"></a>
# **addFileAttachment**
> FileAttachment addFileAttachment(id, file, fileName, contentType, fileCategoryId)

Adds a File Attachment to a Note

This endpoint expects multipart/form-data as the request payload. See Stack Overflow for examples of how to generate multipart requests, or see our &lt;a href&#x3D;\&quot;http://github.com/Insightly\&quot; target&#x3D;\&quot;_blank\&quot;&gt;client libraries&lt;/a&gt; for an example of how this is generated. Only one file can be added per request.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.NotesApi;


NotesApi apiInstance = new NotesApi();
Long id = 789L; // Long | Note ID
String file = "/path/to/file.txt"; // String | The file part of the multipart/form-data request. Only one file can be added per request.
String fileName = "fileName_example"; // String | 
String contentType = "contentType_example"; // String | 
Integer fileCategoryId = 56; // Integer | 
try {
    FileAttachment result = apiInstance.addFileAttachment(id, file, fileName, contentType, fileCategoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotesApi#addFileAttachment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| Note ID |
 **file** | **String**| The file part of the multipart/form-data request. Only one file can be added per request. |
 **fileName** | **String**|  | [optional]
 **contentType** | **String**|  | [optional]
 **fileCategoryId** | **Integer**|  | [optional]

### Return type

[**FileAttachment**](FileAttachment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json, text/json

<a name="addFollow"></a>
# **addFollow**
> Follow addFollow(id)

Start following a Note

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.NotesApi;


NotesApi apiInstance = new NotesApi();
Long id = 789L; // Long | A Note's ID (NOTE_ID)
try {
    Follow result = apiInstance.addFollow(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotesApi#addFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Note&#39;s ID (NOTE_ID) |

### Return type

[**Follow**](Follow.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addNoteLink"></a>
# **addNoteLink**
> NoteLink addNoteLink(id, apiLink)

Adds a Note Link

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.NotesApi;


NotesApi apiInstance = new NotesApi();
Long id = 789L; // Long | A Note's ID (NOTE_ID)
NoteLink apiLink = new NoteLink(); // NoteLink | The Note Link to add (just include JSON object as request body)
try {
    NoteLink result = apiInstance.addNoteLink(id, apiLink);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotesApi#addNoteLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Note&#39;s ID (NOTE_ID) |
 **apiLink** | [**NoteLink**](NoteLink.md)| The Note Link to add (just include JSON object as request body) |

### Return type

[**NoteLink**](NoteLink.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteFollow"></a>
# **deleteFollow**
> deleteFollow(id)

Stop following a Note

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.NotesApi;


NotesApi apiInstance = new NotesApi();
Long id = 789L; // Long | A Note's ID (NOTE_ID)
try {
    apiInstance.deleteFollow(id);
} catch (ApiException e) {
    System.err.println("Exception when calling NotesApi#deleteFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Note&#39;s ID (NOTE_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteNote"></a>
# **deleteNote**
> deleteNote(id)

Deletes a Note



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.NotesApi;


NotesApi apiInstance = new NotesApi();
Long id = 789L; // Long | A Note's ID
try {
    apiInstance.deleteNote(id);
} catch (ApiException e) {
    System.err.println("Exception when calling NotesApi#deleteNote");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Note&#39;s ID |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteNoteLink"></a>
# **deleteNoteLink**
> deleteNoteLink(id, linkId)

Deletes a Note Link

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.NotesApi;


NotesApi apiInstance = new NotesApi();
Long id = 789L; // Long | A Note's ID (NOTE_ID)
Long linkId = 789L; // Long | A Note Link's ID (NOTE_LINK_ID)
try {
    apiInstance.deleteNoteLink(id, linkId);
} catch (ApiException e) {
    System.err.println("Exception when calling NotesApi#deleteNoteLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Note&#39;s ID (NOTE_ID) |
 **linkId** | **Long**| A Note Link&#39;s ID (NOTE_LINK_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="getComments"></a>
# **getComments**
> List&lt;Comment&gt; getComments(id, updatedAfterUtc, skip, top, countTotal)

Gets a Note&#39;s Comments

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.NotesApi;


NotesApi apiInstance = new NotesApi();
Long id = 789L; // Long | A Note's ID (NOTE_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when comment was last updated.
Integer skip = 56; // Integer | Optional, number of comments to skip.
Integer top = 56; // Integer | Optional, maximum number of comments to return in the response.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<Comment> result = apiInstance.getComments(id, updatedAfterUtc, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotesApi#getComments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Note&#39;s ID (NOTE_ID) |
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when comment was last updated. | [optional]
 **skip** | **Integer**| Optional, number of comments to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of comments to return in the response. | [optional]
 **countTotal** | **Boolean**| true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Comment&gt;**](Comment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFileAttachments"></a>
# **getFileAttachments**
> List&lt;FileAttachment&gt; getFileAttachments(id, updatedAfterUtc, skip, top, countTotal)

Gets a Note&#39;s File Attachments

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.NotesApi;


NotesApi apiInstance = new NotesApi();
Long id = 789L; // Long | A Note's ID (NOTE_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when file attachment was last updated.
Integer skip = 56; // Integer | Optional, number of file attachments to skip.
Integer top = 56; // Integer | Optional, maximum number of file attachments to return in the response.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<FileAttachment> result = apiInstance.getFileAttachments(id, updatedAfterUtc, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotesApi#getFileAttachments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Note&#39;s ID (NOTE_ID) |
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when file attachment was last updated. | [optional]
 **skip** | **Integer**| Optional, number of file attachments to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of file attachments to return in the response. | [optional]
 **countTotal** | **Boolean**| true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;FileAttachment&gt;**](FileAttachment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFollow"></a>
# **getFollow**
> Follow getFollow(id)

Gets a Follow record for the Note

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.NotesApi;


NotesApi apiInstance = new NotesApi();
Long id = 789L; // Long | A Note's ID (NOTE_ID)
try {
    Follow result = apiInstance.getFollow(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotesApi#getFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Note&#39;s ID (NOTE_ID) |

### Return type

[**Follow**](Follow.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getNote"></a>
# **getNote**
> Note getNote(id)

Gets a Note

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.NotesApi;


NotesApi apiInstance = new NotesApi();
Long id = 789L; // Long | A Note's ID
try {
    Note result = apiInstance.getNote(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotesApi#getNote");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Note&#39;s ID |

### Return type

[**Note**](Note.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getNotes"></a>
# **getNotes**
> List&lt;Note&gt; getNotes(brief, skip, top, countTotal)

Gets a list of Notes.

Simple object graphs (excluding NOTELINKS) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.NotesApi;


NotesApi apiInstance = new NotesApi();
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the note.
Integer skip = 56; // Integer | Optional, number of notes to skip.
Integer top = 56; // Integer | Optional, maximum number of notes to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Note> result = apiInstance.getNotes(brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotesApi#getNotes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the note. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of notes to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of notes to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Note&gt;**](Note.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getNotesBySearch"></a>
# **getNotesBySearch**
> List&lt;Note&gt; getNotesBySearch(title, ownerUserId, updatedAfterUtc, brief, skip, top, countTotal)

Gets a filtered list of Notes.

Only one optional parameter (excluding top, skip and count_total) can be specified. Simple object graphs (excluding NOTELINKS) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.NotesApi;


NotesApi apiInstance = new NotesApi();
String title = "title_example"; // String | Optional, note title.
Long ownerUserId = 789L; // Long | Optional, id of the owner user.
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when note was last updated.
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the note.
Integer skip = 56; // Integer | Optional, number of notes to skip.
Integer top = 56; // Integer | Optional, maximum number of notes to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Note> result = apiInstance.getNotesBySearch(title, ownerUserId, updatedAfterUtc, brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotesApi#getNotesBySearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **title** | **String**| Optional, note title. | [optional]
 **ownerUserId** | **Long**| Optional, id of the owner user. | [optional]
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when note was last updated. | [optional]
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the note. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of notes to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of notes to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Note&gt;**](Note.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateNote"></a>
# **updateNote**
> Note updateNote(apiNote, brief)

Updates a Note

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.NotesApi;


NotesApi apiInstance = new NotesApi();
Note apiNote = new Note(); // Note | The Note to add (just include JSON object as request body)
Boolean brief = false; // Boolean | Optional, true if you wish to do a partial update containing only top level properties of the Note. When true, all sub-collections are ignored.
try {
    Note result = apiInstance.updateNote(apiNote, brief);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotesApi#updateNote");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiNote** | [**Note**](Note.md)| The Note to add (just include JSON object as request body) |
 **brief** | **Boolean**| Optional, true if you wish to do a partial update containing only top level properties of the Note. When true, all sub-collections are ignored. | [optional] [default to false]

### Return type

[**Note**](Note.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

