# LeadStatusesApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addLeadStatus**](LeadStatusesApi.md#addLeadStatus) | **POST** /LeadStatuses | Adds a Lead Status
[**deleteLeadStatus**](LeadStatusesApi.md#deleteLeadStatus) | **DELETE** /LeadStatuses/{id} | Deletes a Lead Status
[**getLeadStatuses**](LeadStatusesApi.md#getLeadStatuses) | **GET** /LeadStatuses | Gets a list of Lead Statuses
[**updateLeadStatus**](LeadStatusesApi.md#updateLeadStatus) | **PUT** /LeadStatuses | Updates a Lead Status


<a name="addLeadStatus"></a>
# **addLeadStatus**
> LeadStatus addLeadStatus(leadStatus)

Adds a Lead Status

This endpoint is used to add a new lead status option to the instance. This endpoint is only accessible to users with administrator access.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadStatusesApi;


LeadStatusesApi apiInstance = new LeadStatusesApi();
LeadStatus leadStatus = new LeadStatus(); // LeadStatus | The Lead Status to add
try {
    LeadStatus result = apiInstance.addLeadStatus(leadStatus);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadStatusesApi#addLeadStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **leadStatus** | [**LeadStatus**](LeadStatus.md)| The Lead Status to add |

### Return type

[**LeadStatus**](LeadStatus.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteLeadStatus"></a>
# **deleteLeadStatus**
> deleteLeadStatus(id)

Deletes a Lead Status

This endpoint is used to delete an existing lead status.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadStatusesApi;


LeadStatusesApi apiInstance = new LeadStatusesApi();
Long id = 789L; // Long | A Lead Status's ID
try {
    apiInstance.deleteLeadStatus(id);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadStatusesApi#deleteLeadStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead Status&#39;s ID |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="getLeadStatuses"></a>
# **getLeadStatuses**
> List&lt;LeadStatus&gt; getLeadStatuses(includeConverted, skip, top, countTotal)

Gets a list of Lead Statuses

This endpoint returns a list of the possible lead statuses that have been defined for the Insightly instance.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadStatusesApi;


LeadStatusesApi apiInstance = new LeadStatusesApi();
Boolean includeConverted = false; // Boolean | Optional, by default converted status is not included, pass in \"true\" to include it in the response
Integer skip = 56; // Integer | Optional, number of lead statuses to skip.
Integer top = 56; // Integer | Optional, maximum number of lead statuses to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<LeadStatus> result = apiInstance.getLeadStatuses(includeConverted, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadStatusesApi#getLeadStatuses");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **includeConverted** | **Boolean**| Optional, by default converted status is not included, pass in \&quot;true\&quot; to include it in the response | [optional] [default to false]
 **skip** | **Integer**| Optional, number of lead statuses to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of lead statuses to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;LeadStatus&gt;**](LeadStatus.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateLeadStatus"></a>
# **updateLeadStatus**
> LeadStatus updateLeadStatus(leadStatus)

Updates a Lead Status

This endpoint is used to update an existing lead status. This endpoint is only accessible to users with administrator access.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadStatusesApi;


LeadStatusesApi apiInstance = new LeadStatusesApi();
LeadStatus leadStatus = new LeadStatus(); // LeadStatus | A Lead Status
try {
    LeadStatus result = apiInstance.updateLeadStatus(leadStatus);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadStatusesApi#updateLeadStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **leadStatus** | [**LeadStatus**](LeadStatus.md)| A Lead Status |

### Return type

[**LeadStatus**](LeadStatus.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

