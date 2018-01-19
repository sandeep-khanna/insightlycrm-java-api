# PermissionsApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getPermissions**](PermissionsApi.md#getPermissions) | **GET** /Permissions | Gets the Permissions for a User


<a name="getPermissions"></a>
# **getPermissions**
> Permissions getPermissions()

Gets the Permissions for a User

Permissions determine if an individual user can read, edit, delete, or create records of a given object type.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.PermissionsApi;


PermissionsApi apiInstance = new PermissionsApi();
try {
    Permissions result = apiInstance.getPermissions();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PermissionsApi#getPermissions");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Permissions**](Permissions.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

