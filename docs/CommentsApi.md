# CommentsApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addFileAttachment**](CommentsApi.md#addFileAttachment) | **POST** /Comments/{id}/FileAttachments | Adds a File Attachment to a Comment
[**deleteComment**](CommentsApi.md#deleteComment) | **DELETE** /Comments/{id} | Deletes a Comment
[**getComment**](CommentsApi.md#getComment) | **GET** /Comments/{id} | Gets a Comment
[**getFileAttachments**](CommentsApi.md#getFileAttachments) | **GET** /Comments/{id}/FileAttachments | Gets a Comments&#39;s File Attachments
[**updateComment**](CommentsApi.md#updateComment) | **PUT** /Comments | Updates a Comment


<a name="addFileAttachment"></a>
# **addFileAttachment**
> FileAttachment addFileAttachment(id, file, fileName, contentType, fileCategoryId)

Adds a File Attachment to a Comment

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.CommentsApi;


CommentsApi apiInstance = new CommentsApi();
Long id = 789L; // Long | Comment ID
File file = new File("/path/to/file.txt"); // File | File and metadata to be attached to Comment
String fileName = "fileName_example"; // String | 
String contentType = "contentType_example"; // String | 
Integer fileCategoryId = 56; // Integer | 
try {
    FileAttachment result = apiInstance.addFileAttachment(id, file, fileName, contentType, fileCategoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommentsApi#addFileAttachment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| Comment ID |
 **file** | **File**| File and metadata to be attached to Comment |
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

<a name="deleteComment"></a>
# **deleteComment**
> deleteComment(id)

Deletes a Comment

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.CommentsApi;


CommentsApi apiInstance = new CommentsApi();
Long id = 789L; // Long | A Comment's ID
try {
    apiInstance.deleteComment(id);
} catch (ApiException e) {
    System.err.println("Exception when calling CommentsApi#deleteComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Comment&#39;s ID |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="getComment"></a>
# **getComment**
> Comment getComment(id)

Gets a Comment

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.CommentsApi;


CommentsApi apiInstance = new CommentsApi();
Long id = 789L; // Long | A Comments's ID
try {
    Comment result = apiInstance.getComment(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommentsApi#getComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Comments&#39;s ID |

### Return type

[**Comment**](Comment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFileAttachments"></a>
# **getFileAttachments**
> List&lt;FileAttachment&gt; getFileAttachments(id, updatedAfterUtc, skip, top, countTotal)

Gets a Comments&#39;s File Attachments

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.CommentsApi;


CommentsApi apiInstance = new CommentsApi();
Long id = 789L; // Long | A Comments's ID (COMMENT_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when file attachment was last updated.
Integer skip = 56; // Integer | Optional, number of file attachments to skip.
Integer top = 56; // Integer | Optional, maximum number of file attachments to return in the response.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<FileAttachment> result = apiInstance.getFileAttachments(id, updatedAfterUtc, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommentsApi#getFileAttachments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Comments&#39;s ID (COMMENT_ID) |
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

<a name="updateComment"></a>
# **updateComment**
> Comment updateComment(apiComment)

Updates a Comment

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.CommentsApi;


CommentsApi apiInstance = new CommentsApi();
Comment apiComment = new Comment(); // Comment | The Comment to add
try {
    Comment result = apiInstance.updateComment(apiComment);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CommentsApi#updateComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiComment** | [**Comment**](Comment.md)| The Comment to add |

### Return type

[**Comment**](Comment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

