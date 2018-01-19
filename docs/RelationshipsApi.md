# RelationshipsApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getRelationships**](RelationshipsApi.md#getRelationships) | **GET** /Relationships | Gets a list of Relationships


<a name="getRelationships"></a>
# **getRelationships**
> List&lt;Relationship&gt; getRelationships(skip, top, countTotal)

Gets a list of Relationships

This read only endpoint returns a list of the relationships that have been defined for the Insightly instance.            Relationships enable users to define how one Insightly object is related to another.            For example: contact A is a customer of contact B. The API only supports read access to relationships, to create or update            relationships, you&#39;ll need to do so via the web app.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.RelationshipsApi;


RelationshipsApi apiInstance = new RelationshipsApi();
Integer skip = 56; // Integer | Optional, number of records to skip.
Integer top = 56; // Integer | Optional, maximum number of records to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Relationship> result = apiInstance.getRelationships(skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RelationshipsApi#getRelationships");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **skip** | **Integer**| Optional, number of records to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of records to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Relationship&gt;**](Relationship.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

