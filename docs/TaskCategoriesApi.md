# TaskCategoriesApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addTaskCategory**](TaskCategoriesApi.md#addTaskCategory) | **POST** /TaskCategories | Adds a Task Category
[**deleteTaskCategory**](TaskCategoriesApi.md#deleteTaskCategory) | **DELETE** /TaskCategories/{id} | Deactivates a Task Category
[**getTaskCategories**](TaskCategoriesApi.md#getTaskCategories) | **GET** /TaskCategories | Gets a list of Task Categories
[**getTaskCategory**](TaskCategoriesApi.md#getTaskCategory) | **GET** /TaskCategories/{id} | Gets a Task Category
[**updateTaskCategory**](TaskCategoriesApi.md#updateTaskCategory) | **PUT** /TaskCategories | Updates a Task Category


<a name="addTaskCategory"></a>
# **addTaskCategory**
> Category addTaskCategory(category)

Adds a Task Category

This endpoint is used to create a new task category. This endpoint is only accessible to users with administrator permission.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TaskCategoriesApi;


TaskCategoriesApi apiInstance = new TaskCategoriesApi();
Category category = new Category(); // Category | The Task Category to add (just include JSON object as request body)
try {
    Category result = apiInstance.addTaskCategory(category);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaskCategoriesApi#addTaskCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category** | [**Category**](Category.md)| The Task Category to add (just include JSON object as request body) |

### Return type

[**Category**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteTaskCategory"></a>
# **deleteTaskCategory**
> deleteTaskCategory(id)

Deactivates a Task Category

This endpoint is used to deactivate a task category. This endpoint is only accessible to users with administrator permission.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TaskCategoriesApi;


TaskCategoriesApi apiInstance = new TaskCategoriesApi();
Long id = 789L; // Long | A Task Category's ID
try {
    apiInstance.deleteTaskCategory(id);
} catch (ApiException e) {
    System.err.println("Exception when calling TaskCategoriesApi#deleteTaskCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Task Category&#39;s ID |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="getTaskCategories"></a>
# **getTaskCategories**
> List&lt;Category&gt; getTaskCategories(skip, top, countTotal)

Gets a list of Task Categories

This read only endpoint returns a list of the task categories set up for the Insightly instance.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TaskCategoriesApi;


TaskCategoriesApi apiInstance = new TaskCategoriesApi();
Integer skip = 56; // Integer | Optional, number of records to skip.
Integer top = 56; // Integer | Optional, maximum number of records to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Category> result = apiInstance.getTaskCategories(skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaskCategoriesApi#getTaskCategories");
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

[**List&lt;Category&gt;**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getTaskCategory"></a>
# **getTaskCategory**
> Category getTaskCategory(id)

Gets a Task Category

This endpoint returns the graph for a specific task category.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TaskCategoriesApi;


TaskCategoriesApi apiInstance = new TaskCategoriesApi();
Long id = 789L; // Long | A Task Category's ID
try {
    Category result = apiInstance.getTaskCategory(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaskCategoriesApi#getTaskCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Task Category&#39;s ID |

### Return type

[**Category**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateTaskCategory"></a>
# **updateTaskCategory**
> Category updateTaskCategory(category)

Updates a Task Category

This endpoint is used to update an existing task category, for example to change the background color for the task category&#39;s label in the web UI. This endpoint is only accessible to users with administrator permission.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TaskCategoriesApi;


TaskCategoriesApi apiInstance = new TaskCategoriesApi();
Category category = new Category(); // Category | A Task Category (just include JSON object as request body)
try {
    Category result = apiInstance.updateTaskCategory(category);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaskCategoriesApi#updateTaskCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category** | [**Category**](Category.md)| A Task Category (just include JSON object as request body) |

### Return type

[**Category**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

