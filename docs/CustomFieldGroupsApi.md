# CustomFieldGroupsApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCustomFieldGroups**](CustomFieldGroupsApi.md#getCustomFieldGroups) | **GET** /CustomFieldGroups | Gets a list of Custom Field Groups defined for your instance


<a name="getCustomFieldGroups"></a>
# **getCustomFieldGroups**
> List&lt;CustomFieldGroup&gt; getCustomFieldGroups(skip, top, countTotal)

Gets a list of Custom Field Groups defined for your instance

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.CustomFieldGroupsApi;


CustomFieldGroupsApi apiInstance = new CustomFieldGroupsApi();
Integer skip = 56; // Integer | Optional, number of custom field groups to skip.
Integer top = 56; // Integer | Optional, maximum number of custom field groups to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<CustomFieldGroup> result = apiInstance.getCustomFieldGroups(skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomFieldGroupsApi#getCustomFieldGroups");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **skip** | **Integer**| Optional, number of custom field groups to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of custom field groups to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;CustomFieldGroup&gt;**](CustomFieldGroup.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

