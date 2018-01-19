# PipelinesApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getPipeline**](PipelinesApi.md#getPipeline) | **GET** /Pipelines/{id} | Gets a Pipeline
[**getPipelines**](PipelinesApi.md#getPipelines) | **GET** /Pipelines | Gets a list of Pipelines


<a name="getPipeline"></a>
# **getPipeline**
> getPipeline(id)

Gets a Pipeline

This endpoint returns the graph for a specific pipeline.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.PipelinesApi;


PipelinesApi apiInstance = new PipelinesApi();
Long id = 789L; // Long | A Pipeline's ID
try {
    apiInstance.getPipeline(id);
} catch (ApiException e) {
    System.err.println("Exception when calling PipelinesApi#getPipeline");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Pipeline&#39;s ID |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getPipelines"></a>
# **getPipelines**
> List&lt;Pipeline&gt; getPipelines(skip, top, countTotal)

Gets a list of Pipelines

This read only endpoint returns a list of pipelines that have been set up for the Insightly instance.            Pipelines can be defined for both projects and opportunities, and are used to track the progression of projects and opportunities.            To create and update pipelines, you&#39;ll need to go to the web app (API access is read-only).

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.PipelinesApi;


PipelinesApi apiInstance = new PipelinesApi();
Integer skip = 56; // Integer | Optional, number of pipelines to skip.
Integer top = 56; // Integer | Optional, maximum number of pipelines to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Pipeline> result = apiInstance.getPipelines(skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PipelinesApi#getPipelines");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **skip** | **Integer**| Optional, number of pipelines to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of pipelines to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Pipeline&gt;**](Pipeline.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

