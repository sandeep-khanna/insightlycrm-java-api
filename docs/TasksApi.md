# TasksApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addComment**](TasksApi.md#addComment) | **POST** /Tasks/{id}/Comments | Adds a Comment to a task.
[**addFollow**](TasksApi.md#addFollow) | **POST** /Tasks/{id}/Follow | Start following a Task
[**addTask**](TasksApi.md#addTask) | **POST** /Tasks | Adds a Task
[**addTaskLink**](TasksApi.md#addTaskLink) | **POST** /Tasks/{id}/TaskLinks | Adds a Task Link
[**deleteFollow**](TasksApi.md#deleteFollow) | **DELETE** /Tasks/{id}/Follow | Stop following a Task
[**deleteTask**](TasksApi.md#deleteTask) | **DELETE** /Tasks/{id} | Deletes a Task
[**deleteTaskLink**](TasksApi.md#deleteTaskLink) | **DELETE** /Tasks/{id}/TaskLinks/{linkId} | Deletes a Task Link
[**getComments**](TasksApi.md#getComments) | **GET** /Tasks/{id}/Comments | Gets a Task&#39;s Comments
[**getFollow**](TasksApi.md#getFollow) | **GET** /Tasks/{id}/Follow | Gets a Follow record for the Task
[**getTask**](TasksApi.md#getTask) | **GET** /Tasks/{id} | Gets a Task
[**getTasks**](TasksApi.md#getTasks) | **GET** /Tasks | Gets a list of Tasks.
[**getTasksBySearch**](TasksApi.md#getTasksBySearch) | **GET** /Tasks/Search | Gets a filtered list of Tasks.
[**updateTask**](TasksApi.md#updateTask) | **PUT** /Tasks | Updates a Task


<a name="addComment"></a>
# **addComment**
> Comment addComment(id, apiComment)

Adds a Comment to a task.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TasksApi;


TasksApi apiInstance = new TasksApi();
Long id = 789L; // Long | A Task's ID (TASK_ID)
Comment apiComment = new Comment(); // Comment | The Comment to add (just include JSON object as request body)
try {
    Comment result = apiInstance.addComment(id, apiComment);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#addComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Task&#39;s ID (TASK_ID) |
 **apiComment** | [**Comment**](Comment.md)| The Comment to add (just include JSON object as request body) |

### Return type

[**Comment**](Comment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addFollow"></a>
# **addFollow**
> Follow addFollow(id)

Start following a Task

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TasksApi;


TasksApi apiInstance = new TasksApi();
Long id = 789L; // Long | A Task's ID (TASK_ID)
try {
    Follow result = apiInstance.addFollow(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#addFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Task&#39;s ID (TASK_ID) |

### Return type

[**Follow**](Follow.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addTask"></a>
# **addTask**
> Task addTask(apiTask)

Adds a Task

A common source of problems when creating tasks occurs when users omit required fields, or insert             invalid data into a field. A good troubleshooting technique             is to create a few tasks via the web interface, with representative data, links, etc, and then access             these tasks via the API, and inspect the returned object graph.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TasksApi;


TasksApi apiInstance = new TasksApi();
Task apiTask = new Task(); // Task | The Task to add (just include JSON object as request body)
try {
    Task result = apiInstance.addTask(apiTask);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#addTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiTask** | [**Task**](Task.md)| The Task to add (just include JSON object as request body) |

### Return type

[**Task**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addTaskLink"></a>
# **addTaskLink**
> TaskLink addTaskLink(id, apiLink)

Adds a Task Link

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TasksApi;


TasksApi apiInstance = new TasksApi();
Long id = 789L; // Long | A Task's ID (TASK_ID)
TaskLink apiLink = new TaskLink(); // TaskLink | The Task Link to add (just include JSON object as request body)
try {
    TaskLink result = apiInstance.addTaskLink(id, apiLink);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#addTaskLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Task&#39;s ID (TASK_ID) |
 **apiLink** | [**TaskLink**](TaskLink.md)| The Task Link to add (just include JSON object as request body) |

### Return type

[**TaskLink**](TaskLink.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteFollow"></a>
# **deleteFollow**
> deleteFollow(id)

Stop following a Task

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TasksApi;


TasksApi apiInstance = new TasksApi();
Long id = 789L; // Long | A Task's ID (TASK_ID)
try {
    apiInstance.deleteFollow(id);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#deleteFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Task&#39;s ID (TASK_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteTask"></a>
# **deleteTask**
> deleteTask(id)

Deletes a Task



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TasksApi;


TasksApi apiInstance = new TasksApi();
Long id = 789L; // Long | A Task's ID
try {
    apiInstance.deleteTask(id);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#deleteTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Task&#39;s ID |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteTaskLink"></a>
# **deleteTaskLink**
> deleteTaskLink(id, linkId)

Deletes a Task Link

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TasksApi;


TasksApi apiInstance = new TasksApi();
Long id = 789L; // Long | A Task's ID (TASK_ID)
Long linkId = 789L; // Long | A Task Link's ID (TASK_LINK_ID)
try {
    apiInstance.deleteTaskLink(id, linkId);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#deleteTaskLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Task&#39;s ID (TASK_ID) |
 **linkId** | **Long**| A Task Link&#39;s ID (TASK_LINK_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="getComments"></a>
# **getComments**
> List&lt;Comment&gt; getComments(id, updatedAfterUtc, skip, top, countTotal)

Gets a Task&#39;s Comments

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TasksApi;


TasksApi apiInstance = new TasksApi();
Long id = 789L; // Long | A Task's ID (TASK_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when comment was last updated.
Integer skip = 56; // Integer | Optional, number of comments to skip.
Integer top = 56; // Integer | Optional, maximum number of comments to return in the response.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<Comment> result = apiInstance.getComments(id, updatedAfterUtc, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#getComments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Task&#39;s ID (TASK_ID) |
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when comment was last updated. | [optional]
 **skip** | **Integer**| Optional, number of comments to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of comments to return in the response. | [optional]
 **countTotal** | **Boolean**| true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Comment&gt;**](Comment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFollow"></a>
# **getFollow**
> Follow getFollow(id)

Gets a Follow record for the Task

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TasksApi;


TasksApi apiInstance = new TasksApi();
Long id = 789L; // Long | A Task's ID (TASK_ID)
try {
    Follow result = apiInstance.getFollow(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#getFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Task&#39;s ID (TASK_ID) |

### Return type

[**Follow**](Follow.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getTask"></a>
# **getTask**
> Task getTask(id)

Gets a Task



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TasksApi;


TasksApi apiInstance = new TasksApi();
Long id = 789L; // Long | A Task's ID
try {
    Task result = apiInstance.getTask(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#getTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Task&#39;s ID |

### Return type

[**Task**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getTasks"></a>
# **getTasks**
> List&lt;Task&gt; getTasks(brief, skip, top, countTotal)

Gets a list of Tasks.

Simple object graphs (excluding TASKLINKS) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TasksApi;


TasksApi apiInstance = new TasksApi();
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the task.
Integer skip = 56; // Integer | Optional, number of tasks to skip.
Integer top = 56; // Integer | Optional, maximum number of tasks to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Task> result = apiInstance.getTasks(brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#getTasks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the task. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of tasks to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of tasks to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Task&gt;**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getTasksBySearch"></a>
# **getTasksBySearch**
> List&lt;Task&gt; getTasksBySearch(title, status, categoryId, ownerUserId, updatedAfterUtc, brief, skip, top, countTotal)

Gets a filtered list of Tasks.

Only one optional parameter (excluding brief, top, skip and count_total) can be specified. Simple object graphs (excluding TASKLINKS) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TasksApi;


TasksApi apiInstance = new TasksApi();
String title = "title_example"; // String | Optional, task title.
String status = "status_example"; // String | Optional, status of the task.
Long categoryId = 789L; // Long | Optional, category id.
Long ownerUserId = 789L; // Long | Optional, id of the owner user.
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when task was last updated.
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the task.
Integer skip = 56; // Integer | Optional, number of tasks to skip.
Integer top = 56; // Integer | Optional, maximum number of tasks to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Task> result = apiInstance.getTasksBySearch(title, status, categoryId, ownerUserId, updatedAfterUtc, brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#getTasksBySearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **title** | **String**| Optional, task title. | [optional]
 **status** | **String**| Optional, status of the task. | [optional]
 **categoryId** | **Long**| Optional, category id. | [optional]
 **ownerUserId** | **Long**| Optional, id of the owner user. | [optional]
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when task was last updated. | [optional]
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the task. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of tasks to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of tasks to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Task&gt;**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateTask"></a>
# **updateTask**
> Task updateTask(apiTask, brief)

Updates a Task

A common source of problems when updating tasks occurs when users omit required fields, or insert             invalid data into a field. A good troubleshooting technique             is to create a few tasks via the web interface, with representative data, links, etc, and then access             these tasks via the API, and inspect the returned object graph.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TasksApi;


TasksApi apiInstance = new TasksApi();
Task apiTask = new Task(); // Task | The Task to update (just include JSON object as request body)
Boolean brief = false; // Boolean | Optional, true if you wish to do a partial update containing only top level properties of the Task. When true, all sub-collections are ignored.
try {
    Task result = apiInstance.updateTask(apiTask, brief);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TasksApi#updateTask");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiTask** | [**Task**](Task.md)| The Task to update (just include JSON object as request body) |
 **brief** | **Boolean**| Optional, true if you wish to do a partial update containing only top level properties of the Task. When true, all sub-collections are ignored. | [optional] [default to false]

### Return type

[**Task**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

