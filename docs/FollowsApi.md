# FollowsApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getFollows**](FollowsApi.md#getFollows) | **GET** /Follows | Gets a list of followed records for the user


<a name="getFollows"></a>
# **getFollows**
> List&lt;UserFollow&gt; getFollows(recordType, skip, top, countTotal)

Gets a list of followed records for the user

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.FollowsApi;


FollowsApi apiInstance = new FollowsApi();
String recordType = "recordType_example"; // String | Optional, filters followed records by a given record type.
Integer skip = 56; // Integer | Optional, number of records to skip.
Integer top = 56; // Integer | Optional, maximum number of records to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<UserFollow> result = apiInstance.getFollows(recordType, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FollowsApi#getFollows");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **recordType** | **String**| Optional, filters followed records by a given record type. | [optional]
 **skip** | **Integer**| Optional, number of records to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of records to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;UserFollow&gt;**](UserFollow.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

