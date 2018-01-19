# CustomFieldsApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCustomFields**](CustomFieldsApi.md#getCustomFields) | **GET** /CustomFields | Gets a list of Custom Fields


<a name="getCustomFields"></a>
# **getCustomFields**
> List&lt;CustomFieldMetadata&gt; getCustomFields(skip, top, countTotal)

Gets a list of Custom Fields

Use this API call to get a list of custom fields metadata. The properties FIELD_FOR, GROUP_ID, and ORDER_ID can be used to determine which fields belong to a particular object. See CustomFieldGroups if more data on a custom field&#39;s group is needed. A common problem API users have is to reference an invalid CUSTOM_FIELD_ID when referencing custom fields in a newly created or updated object.            If you plan to use custom fields in your API based application, be sure you are working with valid custom field IDs. To add or update custom fields for your Insightly instance, you&#39;ll need to go to the web app to do so.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.CustomFieldsApi;


CustomFieldsApi apiInstance = new CustomFieldsApi();
Integer skip = 56; // Integer | Optional, number of custom fields to skip.
Integer top = 56; // Integer | Optional, maximum number of custom fields to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<CustomFieldMetadata> result = apiInstance.getCustomFields(skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CustomFieldsApi#getCustomFields");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **skip** | **Integer**| Optional, number of custom fields to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of custom fields to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;CustomFieldMetadata&gt;**](CustomFieldMetadata.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

