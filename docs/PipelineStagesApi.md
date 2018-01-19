# PipelineStagesApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getPipelineStage**](PipelineStagesApi.md#getPipelineStage) | **GET** /PipelineStages/{id} | Gets a Pipeline Stage
[**getPipelineStages**](PipelineStagesApi.md#getPipelineStages) | **GET** /PipelineStages | Gets a list of Pipeline Stages


<a name="getPipelineStage"></a>
# **getPipelineStage**
> PipelineStage getPipelineStage(id)

Gets a Pipeline Stage

This endpoint returns the graph for a specific pipeline stage.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.PipelineStagesApi;


PipelineStagesApi apiInstance = new PipelineStagesApi();
Long id = 789L; // Long | A Pipeline Stage's ID
try {
    PipelineStage result = apiInstance.getPipelineStage(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PipelineStagesApi#getPipelineStage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Pipeline Stage&#39;s ID |

### Return type

[**PipelineStage**](PipelineStage.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getPipelineStages"></a>
# **getPipelineStages**
> List&lt;PipelineStage&gt; getPipelineStages(skip, top, countTotal)

Gets a list of Pipeline Stages

This read only endpoint returns a list of the pipeline stages that have been set up for the Insightly instance.            Pipeline stages are used to indicate where a project or opportunity is in terms of its progression.            For example, stage 1 for the sales pipeline might be \&quot;initial contact\&quot;, while stage 4 might be \&quot;generating quote\&quot;.            The API for pipeline stages is read only, so to create or update pipeline stages, you&#39;ll need to use the web app to do so.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.PipelineStagesApi;


PipelineStagesApi apiInstance = new PipelineStagesApi();
Integer skip = 56; // Integer | Optional, number of stages to skip.
Integer top = 56; // Integer | Optional, maximum number of stages to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<PipelineStage> result = apiInstance.getPipelineStages(skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PipelineStagesApi#getPipelineStages");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **skip** | **Integer**| Optional, number of stages to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of stages to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;PipelineStage&gt;**](PipelineStage.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

