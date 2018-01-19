# TeamMembersApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addTeamMember**](TeamMembersApi.md#addTeamMember) | **POST** /TeamMembers | Adds a new Team Member
[**deleteTeamMember**](TeamMembersApi.md#deleteTeamMember) | **DELETE** /TeamMembers/{id} | Deletes a Team Member
[**getTeamMember**](TeamMembersApi.md#getTeamMember) | **GET** /TeamMembers/{id} | Gets a Team Member
[**getTeamMembers**](TeamMembersApi.md#getTeamMembers) | **GET** /TeamMembers | Gets a list of Team Members


<a name="addTeamMember"></a>
# **addTeamMember**
> TeamMember addTeamMember(apiTeamMember)

Adds a new Team Member

Note: Team Members of Anonymous Teams can only be created via the /Teams endpoint.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TeamMembersApi;


TeamMembersApi apiInstance = new TeamMembersApi();
TeamMember apiTeamMember = new TeamMember(); // TeamMember | The Team Member to add (just include JSON object as request body)
try {
    TeamMember result = apiInstance.addTeamMember(apiTeamMember);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamMembersApi#addTeamMember");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiTeamMember** | [**TeamMember**](TeamMember.md)| The Team Member to add (just include JSON object as request body) |

### Return type

[**TeamMember**](TeamMember.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteTeamMember"></a>
# **deleteTeamMember**
> deleteTeamMember(id)

Deletes a Team Member

Note: Team Members of Anonymous Teams can only be deleted via the /Teams endpoint.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TeamMembersApi;


TeamMembersApi apiInstance = new TeamMembersApi();
Long id = 789L; // Long | A Team Member's ID (PERMISSION_ID)
try {
    apiInstance.deleteTeamMember(id);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamMembersApi#deleteTeamMember");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Team Member&#39;s ID (PERMISSION_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="getTeamMember"></a>
# **getTeamMember**
> TeamMember getTeamMember(id)

Gets a Team Member



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TeamMembersApi;


TeamMembersApi apiInstance = new TeamMembersApi();
Long id = 789L; // Long | A Team Member's ID (PERMISSION_ID)
try {
    TeamMember result = apiInstance.getTeamMember(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamMembersApi#getTeamMember");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Team Member&#39;s ID (PERMISSION_ID) |

### Return type

[**TeamMember**](TeamMember.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getTeamMembers"></a>
# **getTeamMembers**
> List&lt;TeamMember&gt; getTeamMembers(skip, top, countTotal)

Gets a list of Team Members

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TeamMembersApi;


TeamMembersApi apiInstance = new TeamMembersApi();
Integer skip = 56; // Integer | Optional, number of team members to skip.
Integer top = 56; // Integer | Optional, maximum number of team members to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<TeamMember> result = apiInstance.getTeamMembers(skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamMembersApi#getTeamMembers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **skip** | **Integer**| Optional, number of team members to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of team members to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;TeamMember&gt;**](TeamMember.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

