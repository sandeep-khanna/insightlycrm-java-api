# LeadSourcesApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addLeadSource**](LeadSourcesApi.md#addLeadSource) | **POST** /LeadSources | Adds a Lead Source
[**deleteLeadSource**](LeadSourcesApi.md#deleteLeadSource) | **DELETE** /LeadSources/{id} | Deletes a Lead Source
[**getLeadSources**](LeadSourcesApi.md#getLeadSources) | **GET** /LeadSources | Gets a list of Lead Sources
[**updateLeadSource**](LeadSourcesApi.md#updateLeadSource) | **PUT** /LeadSources | Updates a Lead Source


<a name="addLeadSource"></a>
# **addLeadSource**
> LeadSource addLeadSource(leadSource)

Adds a Lead Source

This endpoint is used to define a new lead source. This endpoint is only accessible to users with administrator access.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadSourcesApi;


LeadSourcesApi apiInstance = new LeadSourcesApi();
LeadSource leadSource = new LeadSource(); // LeadSource | The Lead Source to add
try {
    LeadSource result = apiInstance.addLeadSource(leadSource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadSourcesApi#addLeadSource");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **leadSource** | [**LeadSource**](LeadSource.md)| The Lead Source to add |

### Return type

[**LeadSource**](LeadSource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteLeadSource"></a>
# **deleteLeadSource**
> deleteLeadSource(id)

Deletes a Lead Source

This endpoint is used to delete an existing lead source.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadSourcesApi;


LeadSourcesApi apiInstance = new LeadSourcesApi();
Long id = 789L; // Long | A Lead Source's ID
try {
    apiInstance.deleteLeadSource(id);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadSourcesApi#deleteLeadSource");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead Source&#39;s ID |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="getLeadSources"></a>
# **getLeadSources**
> List&lt;LeadSource&gt; getLeadSources(skip, top, countTotal)

Gets a list of Lead Sources

This endpoint returns a list of the lead sources that have been defined on the Insightly instance.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadSourcesApi;


LeadSourcesApi apiInstance = new LeadSourcesApi();
Integer skip = 56; // Integer | Optional, number of lead sources to skip.
Integer top = 56; // Integer | Optional, maximum number of lead sources to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<LeadSource> result = apiInstance.getLeadSources(skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadSourcesApi#getLeadSources");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **skip** | **Integer**| Optional, number of lead sources to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of lead sources to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;LeadSource&gt;**](LeadSource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateLeadSource"></a>
# **updateLeadSource**
> LeadSource updateLeadSource(leadSource)

Updates a Lead Source

This endpoint is used to update an existing lead source.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadSourcesApi;


LeadSourcesApi apiInstance = new LeadSourcesApi();
LeadSource leadSource = new LeadSource(); // LeadSource | A Lead Source
try {
    LeadSource result = apiInstance.updateLeadSource(leadSource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadSourcesApi#updateLeadSource");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **leadSource** | [**LeadSource**](LeadSource.md)| A Lead Source |

### Return type

[**LeadSource**](LeadSource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

