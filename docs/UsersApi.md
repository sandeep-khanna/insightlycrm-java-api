# UsersApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getUser**](UsersApi.md#getUser) | **GET** /Users/{id} | Gets a User
[**getUserMe**](UsersApi.md#getUserMe) | **GET** /Users/Me | Gets the User object for the calling user.
[**getUsers**](UsersApi.md#getUsers) | **GET** /Users | Gets a list of Users
[**getUsersBySearch**](UsersApi.md#getUsersBySearch) | **GET** /Users/Search | Gets a filtered list of Users


<a name="getUser"></a>
# **getUser**
> User getUser(id)

Gets a User

This read only endpoint returns the details for a specific user on an Insightly instance, same fields as            returned by the /Users endpoint, but only for a single identified user.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.UsersApi;


UsersApi apiInstance = new UsersApi();
Long id = 789L; // Long | A User's ID
try {
    User result = apiInstance.getUser(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#getUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A User&#39;s ID |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUserMe"></a>
# **getUserMe**
> User getUserMe()

Gets the User object for the calling user.

This read only endpoint returns the details for the currently authenticated user on an Insightly instance, same fields as            returned by the /Users endpoint, but only for a single identified user.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.UsersApi;


UsersApi apiInstance = new UsersApi();
try {
    User result = apiInstance.getUserMe();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#getUserMe");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUsers"></a>
# **getUsers**
> List&lt;User&gt; getUsers(skip, top, countTotal)

Gets a list of Users

This is a read only endpoint that returns a list of users associated with an Insightly instance.            Use this endpoint when you need to obtain a list of valid USER_IDs, for example, when you want to assign            a task to a specific user (do not confuse the USER_ID with their CONTACT_ID).

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.UsersApi;


UsersApi apiInstance = new UsersApi();
Integer skip = 56; // Integer | Optional, number of users to skip.
Integer top = 56; // Integer | Optional, maximum number of users to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<User> result = apiInstance.getUsers(skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#getUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **skip** | **Integer**| Optional, number of users to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of users to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;User&gt;**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUsersBySearch"></a>
# **getUsersBySearch**
> List&lt;User&gt; getUsersBySearch(firstName, lastName, email, updatedAfterUtc, skip, top, countTotal)

Gets a filtered list of Users

This is a read only endpoint that returns a list of users associated with an Insightly instance.            Use this endpoint when you need to obtain a list of valid USER_IDs, for example, when you want to assign            a task to a specific user (do not confuse the USER_ID with their CONTACT_ID). Only one optional parameter (excluding top, skip and count_total) can be specified.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.UsersApi;


UsersApi apiInstance = new UsersApi();
String firstName = "firstName_example"; // String | Optional, first name.
String lastName = "lastName_example"; // String | Optional, last name.
String email = "email_example"; // String | Optional, user's email address.
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when note was last updated.
Integer skip = 56; // Integer | Optional, number of users to skip.
Integer top = 56; // Integer | Optional, maximum number of users to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<User> result = apiInstance.getUsersBySearch(firstName, lastName, email, updatedAfterUtc, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#getUsersBySearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **firstName** | **String**| Optional, first name. | [optional]
 **lastName** | **String**| Optional, last name. | [optional]
 **email** | **String**| Optional, user&#39;s email address. | [optional]
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when note was last updated. | [optional]
 **skip** | **Integer**| Optional, number of users to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of users to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;User&gt;**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

