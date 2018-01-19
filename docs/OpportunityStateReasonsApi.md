# OpportunityStateReasonsApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getOpportunityStateReasons**](OpportunityStateReasonsApi.md#getOpportunityStateReasons) | **GET** /OpportunityStateReasons | Gets a list of Opportunity State Reasons


<a name="getOpportunityStateReasons"></a>
# **getOpportunityStateReasons**
> List&lt;OpportunityStateReason&gt; getOpportunityStateReasons(skip, top, countTotal)

Gets a list of Opportunity State Reasons

This endpoint returns a list of opportunity state reasons set up for the Insightly instance.            This is a read only endpoint, so to add or update opportunity state reasons, you will need to do that via the web app.            Opportunity state reasons are used to indicate why the opportunity state was set to its current value.            For example, you can use this to indicate why you lost a particular sale.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunityStateReasonsApi;


OpportunityStateReasonsApi apiInstance = new OpportunityStateReasonsApi();
Integer skip = 56; // Integer | Optional, number of states to skip.
Integer top = 56; // Integer | Optional, maximum number of states to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<OpportunityStateReason> result = apiInstance.getOpportunityStateReasons(skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunityStateReasonsApi#getOpportunityStateReasons");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **skip** | **Integer**| Optional, number of states to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of states to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;OpportunityStateReason&gt;**](OpportunityStateReason.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

