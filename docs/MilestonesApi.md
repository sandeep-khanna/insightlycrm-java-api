# MilestonesApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMilestones**](MilestonesApi.md#getMilestones) | **GET** /Milestones | Gets a list of Milestones.
[**getMilestonesBySearch**](MilestonesApi.md#getMilestonesBySearch) | **GET** /Milestones/Search | Gets a filtered list of Milestones.


<a name="getMilestones"></a>
# **getMilestones**
> List&lt;Milestone&gt; getMilestones(skip, top, countTotal)

Gets a list of Milestones.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.MilestonesApi;


MilestonesApi apiInstance = new MilestonesApi();
Integer skip = 56; // Integer | Optional, number of milestones to skip.
Integer top = 56; // Integer | Optional, maximum number of milestones to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Milestone> result = apiInstance.getMilestones(skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MilestonesApi#getMilestones");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **skip** | **Integer**| Optional, number of milestones to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of milestones to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Milestone&gt;**](Milestone.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getMilestonesBySearch"></a>
# **getMilestonesBySearch**
> List&lt;Milestone&gt; getMilestonesBySearch(updatedAfterUtc, skip, top, countTotal)

Gets a filtered list of Milestones.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.MilestonesApi;


MilestonesApi apiInstance = new MilestonesApi();
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when milestone was last updated.
Integer skip = 56; // Integer | Optional, number of milestones to skip.
Integer top = 56; // Integer | Optional, maximum number of milestones to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Milestone> result = apiInstance.getMilestonesBySearch(updatedAfterUtc, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MilestonesApi#getMilestonesBySearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when milestone was last updated. | [optional]
 **skip** | **Integer**| Optional, number of milestones to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of milestones to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Milestone&gt;**](Milestone.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

