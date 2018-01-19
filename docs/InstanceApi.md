# InstanceApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getInstance**](InstanceApi.md#getInstance) | **GET** /Instance | Gets the Instance


<a name="getInstance"></a>
# **getInstance**
> Instance getInstance()

Gets the Instance

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.InstanceApi;


InstanceApi apiInstance = new InstanceApi();
try {
    Instance result = apiInstance.getInstance();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InstanceApi#getInstance");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Instance**](Instance.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

