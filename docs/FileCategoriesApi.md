# FileCategoriesApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addFileCategory**](FileCategoriesApi.md#addFileCategory) | **POST** /FileCategories | Adds a File Category
[**deleteFileCategory**](FileCategoriesApi.md#deleteFileCategory) | **DELETE** /FileCategories/{id} | Deactivates a File Category
[**getFileCategories**](FileCategoriesApi.md#getFileCategories) | **GET** /FileCategories | Gets a list of File Categories
[**getFileCategory**](FileCategoriesApi.md#getFileCategory) | **GET** /FileCategories/{id} | Gets a File Category
[**updateFileCategory**](FileCategoriesApi.md#updateFileCategory) | **PUT** /FileCategories | Updates a File Category


<a name="addFileCategory"></a>
# **addFileCategory**
> Category addFileCategory(category)

Adds a File Category

This endpoint is used to create a new File Category. This endpoint is only accessible to users with administrator permission.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.FileCategoriesApi;


FileCategoriesApi apiInstance = new FileCategoriesApi();
Category category = new Category(); // Category | The File Category to add (just include JSON object as request body)
try {
    Category result = apiInstance.addFileCategory(category);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FileCategoriesApi#addFileCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category** | [**Category**](Category.md)| The File Category to add (just include JSON object as request body) |

### Return type

[**Category**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteFileCategory"></a>
# **deleteFileCategory**
> deleteFileCategory(id)

Deactivates a File Category

This endpoint is used to deactivate an existing File Category. This endpoint is only accessible to users with administrator permission.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.FileCategoriesApi;


FileCategoriesApi apiInstance = new FileCategoriesApi();
Long id = 789L; // Long | A File Category's ID
try {
    apiInstance.deleteFileCategory(id);
} catch (ApiException e) {
    System.err.println("Exception when calling FileCategoriesApi#deleteFileCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A File Category&#39;s ID |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="getFileCategories"></a>
# **getFileCategories**
> List&lt;Category&gt; getFileCategories(skip, top, countTotal)

Gets a list of File Categories

This read only endpoint returns a list of file categories that have been set up for the Insightly instance.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.FileCategoriesApi;


FileCategoriesApi apiInstance = new FileCategoriesApi();
Integer skip = 56; // Integer | Optional, number of file categories to skip.
Integer top = 56; // Integer | Optional, maximum number of file categories to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Category> result = apiInstance.getFileCategories(skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FileCategoriesApi#getFileCategories");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **skip** | **Integer**| Optional, number of file categories to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of file categories to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Category&gt;**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFileCategory"></a>
# **getFileCategory**
> Category getFileCategory(id)

Gets a File Category

This endpoint returns the graph for a specific file category.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.FileCategoriesApi;


FileCategoriesApi apiInstance = new FileCategoriesApi();
Long id = 789L; // Long | A File Category's ID
try {
    Category result = apiInstance.getFileCategory(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FileCategoriesApi#getFileCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A File Category&#39;s ID |

### Return type

[**Category**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateFileCategory"></a>
# **updateFileCategory**
> Category updateFileCategory(category)

Updates a File Category

This endpoint is used to update an existing File Category. This endpoint is only accessible to users with administrator permission.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.FileCategoriesApi;


FileCategoriesApi apiInstance = new FileCategoriesApi();
Category category = new Category(); // Category | A File Category (just include JSON object as request body)
try {
    Category result = apiInstance.updateFileCategory(category);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FileCategoriesApi#updateFileCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category** | [**Category**](Category.md)| A File Category (just include JSON object as request body) |

### Return type

[**Category**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

