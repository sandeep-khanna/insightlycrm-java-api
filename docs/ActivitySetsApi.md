# ActivitySetsApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getActivitySet**](ActivitySetsApi.md#getActivitySet) | **GET** /ActivitySets/{id} | Gets a single Activity Set
[**getActivitySets**](ActivitySetsApi.md#getActivitySets) | **GET** /ActivitySets | Gets a list of Activity Sets


<a name="getActivitySet"></a>
# **getActivitySet**
> ActivitySet getActivitySet(id)

Gets a single Activity Set

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ActivitySetsApi;


ActivitySetsApi apiInstance = new ActivitySetsApi();
Long id = 789L; // Long | An Activity Set's ID
try {
    ActivitySet result = apiInstance.getActivitySet(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActivitySetsApi#getActivitySet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Activity Set&#39;s ID |

### Return type

[**ActivitySet**](ActivitySet.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getActivitySets"></a>
# **getActivitySets**
> List&lt;ActivitySet&gt; getActivitySets(brief, skip, top, countTotal)

Gets a list of Activity Sets

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ActivitySetsApi;


ActivitySetsApi apiInstance = new ActivitySetsApi();
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the activity set.
Integer skip = 56; // Integer | Optional, number of activity sets to skip.
Integer top = 56; // Integer | Optional, maximum number of activity sets to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<ActivitySet> result = apiInstance.getActivitySets(brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ActivitySetsApi#getActivitySets");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the activity set. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of activity sets to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of activity sets to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;ActivitySet&gt;**](ActivitySet.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

