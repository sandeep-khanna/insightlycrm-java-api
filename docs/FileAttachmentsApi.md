# FileAttachmentsApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteFileAttachment**](FileAttachmentsApi.md#deleteFileAttachment) | **DELETE** /FileAttachments/{id} | Deletes a File Attachment
[**getFileAttachment**](FileAttachmentsApi.md#getFileAttachment) | **GET** /FileAttachments/{id} | Gets a File Attachment


<a name="deleteFileAttachment"></a>
# **deleteFileAttachment**
> deleteFileAttachment(id)

Deletes a File Attachment



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.FileAttachmentsApi;


FileAttachmentsApi apiInstance = new FileAttachmentsApi();
Long id = 789L; // Long | A File Attachment's ID
try {
    apiInstance.deleteFileAttachment(id);
} catch (ApiException e) {
    System.err.println("Exception when calling FileAttachmentsApi#deleteFileAttachment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A File Attachment&#39;s ID |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="getFileAttachment"></a>
# **getFileAttachment**
> getFileAttachment(id)

Gets a File Attachment



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.FileAttachmentsApi;


FileAttachmentsApi apiInstance = new FileAttachmentsApi();
Long id = 789L; // Long | A File Attachment's ID
try {
    apiInstance.getFileAttachment(id);
} catch (ApiException e) {
    System.err.println("Exception when calling FileAttachmentsApi#getFileAttachment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A File Attachment&#39;s ID |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

