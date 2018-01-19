# TagsApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getTags**](TagsApi.md#getTags) | **GET** /Tags | Gets a list of Tags used for a record type


<a name="getTags"></a>
# **getTags**
> List&lt;Tag&gt; getTags(recordType, skip, top, countTotal)

Gets a list of Tags used for a record type

This endpoint returns a list of tags associated with a record type. The endpoint expects the query parameter            record_type&#x3D;contacts|leads|opportunities|organisations|projects|emails, so to fetch a list of tags associated with contacts, your query would be            /Tags?record_type&#x3D;contacts

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TagsApi;


TagsApi apiInstance = new TagsApi();
String recordType = "recordType_example"; // String | Required, filters tags by a given record type.
Integer skip = 56; // Integer | Optional, number of records to skip.
Integer top = 56; // Integer | Optional, maximum number of records to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Tag> result = apiInstance.getTags(recordType, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TagsApi#getTags");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **recordType** | **String**| Required, filters tags by a given record type. |
 **skip** | **Integer**| Optional, number of records to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of records to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Tag&gt;**](Tag.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

