# ProjectCategoriesApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addProjectCategory**](ProjectCategoriesApi.md#addProjectCategory) | **POST** /ProjectCategories | Adds a Project Category
[**deleteProjectCategory**](ProjectCategoriesApi.md#deleteProjectCategory) | **DELETE** /ProjectCategories/{id} | Deactivates a Project Category
[**getProjectCategories**](ProjectCategoriesApi.md#getProjectCategories) | **GET** /ProjectCategories | Gets a list of Project Categories
[**getProjectCategory**](ProjectCategoriesApi.md#getProjectCategory) | **GET** /ProjectCategories/{id} | Gets a Project Category
[**updateProjectCategory**](ProjectCategoriesApi.md#updateProjectCategory) | **PUT** /ProjectCategories | Updates a Project Category


<a name="addProjectCategory"></a>
# **addProjectCategory**
> Category addProjectCategory(category)

Adds a Project Category

This endpoint is used to create a new project category. This endpoint is only accessible to users with administrator permission.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectCategoriesApi;


ProjectCategoriesApi apiInstance = new ProjectCategoriesApi();
Category category = new Category(); // Category | The Project Category to add (just include JSON object as request body)
try {
    Category result = apiInstance.addProjectCategory(category);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectCategoriesApi#addProjectCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category** | [**Category**](Category.md)| The Project Category to add (just include JSON object as request body) |

### Return type

[**Category**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteProjectCategory"></a>
# **deleteProjectCategory**
> deleteProjectCategory(id)

Deactivates a Project Category

This endpoint is used to deactivate an existing project category. This endpoint is only accessible to users with administrator permission.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectCategoriesApi;


ProjectCategoriesApi apiInstance = new ProjectCategoriesApi();
Long id = 789L; // Long | A Project Category's ID
try {
    apiInstance.deleteProjectCategory(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectCategoriesApi#deleteProjectCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project Category&#39;s ID |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="getProjectCategories"></a>
# **getProjectCategories**
> List&lt;Category&gt; getProjectCategories(skip, top, countTotal)

Gets a list of Project Categories

This read only endpoint returns a list of the project categories that have been configured for the Insightly instance.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectCategoriesApi;


ProjectCategoriesApi apiInstance = new ProjectCategoriesApi();
Integer skip = 56; // Integer | Optional, number of categories to skip.
Integer top = 56; // Integer | Optional, maximum number of categories to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Category> result = apiInstance.getProjectCategories(skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectCategoriesApi#getProjectCategories");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **skip** | **Integer**| Optional, number of categories to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of categories to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Category&gt;**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getProjectCategory"></a>
# **getProjectCategory**
> Category getProjectCategory(id)

Gets a Project Category

This endpoint is used to retrieve the graph for a specific project category.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectCategoriesApi;


ProjectCategoriesApi apiInstance = new ProjectCategoriesApi();
Long id = 789L; // Long | A Project Category's ID
try {
    Category result = apiInstance.getProjectCategory(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectCategoriesApi#getProjectCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project Category&#39;s ID |

### Return type

[**Category**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateProjectCategory"></a>
# **updateProjectCategory**
> Category updateProjectCategory(category)

Updates a Project Category

This endpoint is used to update an existing project category. This endpoint is only accessible to users with administrator permission.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectCategoriesApi;


ProjectCategoriesApi apiInstance = new ProjectCategoriesApi();
Category category = new Category(); // Category | A Project Category (just include JSON object as request body)
try {
    Category result = apiInstance.updateProjectCategory(category);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectCategoriesApi#updateProjectCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category** | [**Category**](Category.md)| A Project Category (just include JSON object as request body) |

### Return type

[**Category**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

