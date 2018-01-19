# TeamsApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addTeam**](TeamsApi.md#addTeam) | **POST** /Teams | Adds a Team
[**addTeamMember**](TeamsApi.md#addTeamMember) | **POST** /Teams/{id}/TeamMembers | Adds a Team Member
[**deleteTeam**](TeamsApi.md#deleteTeam) | **DELETE** /Teams/{id} | Deletes a Team
[**deleteTeamMember**](TeamsApi.md#deleteTeamMember) | **DELETE** /Teams/{id}/TeamMembers/{permissionId} | Deletes a Team Member
[**getTeam**](TeamsApi.md#getTeam) | **GET** /Teams/{id} | Gets a Team
[**getTeams**](TeamsApi.md#getTeams) | **GET** /Teams | Gets a list of Teams.
[**getTeamsBySearch**](TeamsApi.md#getTeamsBySearch) | **GET** /Teams/Search | Gets a filtered list of Teams.
[**updateTeam**](TeamsApi.md#updateTeam) | **PUT** /Teams | Updates a Team


<a name="addTeam"></a>
# **addTeam**
> Team addTeam(apiTeam)

Adds a Team

TEAM_NAME is required when creating a Team with ANONYMOUS_TEAM set to \&quot;false\&quot;. When creating Anonymous Teams, e.g. ANONYMOUS_TEAM&#x3D;true, you must include all the Team Members that should be part of the team. A minimum of one Team Member is required.             For more details, please refer to GET /Teams above.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TeamsApi;


TeamsApi apiInstance = new TeamsApi();
Team apiTeam = new Team(); // Team | The Team to add (just include JSON object as request body)
try {
    Team result = apiInstance.addTeam(apiTeam);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamsApi#addTeam");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiTeam** | [**Team**](Team.md)| The Team to add (just include JSON object as request body) |

### Return type

[**Team**](Team.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addTeamMember"></a>
# **addTeamMember**
> TeamMember addTeamMember(id, apiTeamMember)

Adds a Team Member

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TeamsApi;


TeamsApi apiInstance = new TeamsApi();
Long id = 789L; // Long | A Team's ID (TEAM_ID)
TeamMember apiTeamMember = new TeamMember(); // TeamMember | The Team Member to add (just include JSON object as request body)
try {
    TeamMember result = apiInstance.addTeamMember(id, apiTeamMember);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamsApi#addTeamMember");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Team&#39;s ID (TEAM_ID) |
 **apiTeamMember** | [**TeamMember**](TeamMember.md)| The Team Member to add (just include JSON object as request body) |

### Return type

[**TeamMember**](TeamMember.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteTeam"></a>
# **deleteTeam**
> deleteTeam(id)

Deletes a Team



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TeamsApi;


TeamsApi apiInstance = new TeamsApi();
Long id = 789L; // Long | A Team's ID
try {
    apiInstance.deleteTeam(id);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamsApi#deleteTeam");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Team&#39;s ID |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteTeamMember"></a>
# **deleteTeamMember**
> deleteTeamMember(id, permissionId)

Deletes a Team Member

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TeamsApi;


TeamsApi apiInstance = new TeamsApi();
Long id = 789L; // Long | A Team's ID (TEAM_ID)
Long permissionId = 789L; // Long | A Team Members's ID (PERMISSION_ID)
try {
    apiInstance.deleteTeamMember(id, permissionId);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamsApi#deleteTeamMember");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Team&#39;s ID (TEAM_ID) |
 **permissionId** | **Long**| A Team Members&#39;s ID (PERMISSION_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="getTeam"></a>
# **getTeam**
> Team getTeam(id)

Gets a Team



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TeamsApi;


TeamsApi apiInstance = new TeamsApi();
Long id = 789L; // Long | A Team's ID
try {
    Team result = apiInstance.getTeam(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamsApi#getTeam");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Team&#39;s ID |

### Return type

[**Team**](Team.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getTeams"></a>
# **getTeams**
> List&lt;Team&gt; getTeams(brief, skip, top, countTotal)

Gets a list of Teams.

Simple object graphs (excluding TEAMMEMBERS) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.            &lt;br /&gt; The API responses may contain two types of Teams: a) regular Teams configured via System Settings and b) so called Anonymous Teams which are created by the system when you set a record permission visible to Individuals.            You can differentiate these two types on Teams by the ANONYMOUS_TEAM property. Anonymous Teams are a bit more restricted when it comes to modifying them via the API, they can only be created/updated/deleted via the root /Teams endpoint.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TeamsApi;


TeamsApi apiInstance = new TeamsApi();
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the team.
Integer skip = 56; // Integer | Optional, number of teams to skip.
Integer top = 56; // Integer | Optional, maximum number of teams to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Team> result = apiInstance.getTeams(brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamsApi#getTeams");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the team. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of teams to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of teams to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Team&gt;**](Team.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getTeamsBySearch"></a>
# **getTeamsBySearch**
> List&lt;Team&gt; getTeamsBySearch(teamName, updatedAfterUtc, brief, skip, top, countTotal)

Gets a filtered list of Teams.

Only one optional parameter (excluding brief, top, skip and count_total) can be specified. Simple object graphs (excluding TEAMMEMBERS) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.             &lt;br /&gt; The API responses may contain two types of Teams: a) regular Teams configured via System Settings and b) so called Anonymous Teams which are created by the system when you set a record permission visible to Individuals.            You can differentiate these two types on Teams by the ANONYMOUS_TEAM property. Anonymous Teams are a bit more restricted when it comes to modifying them via the API, they can only be created/updated/deleted via the /Teams endpoint.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TeamsApi;


TeamsApi apiInstance = new TeamsApi();
String teamName = "teamName_example"; // String | Optional, name of the team.
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when team was last updated.
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the team.
Integer skip = 56; // Integer | Optional, number of teams to skip.
Integer top = 56; // Integer | Optional, maximum number of teams to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Team> result = apiInstance.getTeamsBySearch(teamName, updatedAfterUtc, brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamsApi#getTeamsBySearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamName** | **String**| Optional, name of the team. | [optional]
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when team was last updated. | [optional]
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the team. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of teams to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of teams to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Team&gt;**](Team.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateTeam"></a>
# **updateTeam**
> Team updateTeam(apiTeam, brief)

Updates a Team

When updating Anonymous Teams, the brief parameter has no effect and you must include all the Team Members that should be part of the team. A minimum of one Team Member is required.  For more details, please refer to GET /Teams above.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.TeamsApi;


TeamsApi apiInstance = new TeamsApi();
Team apiTeam = new Team(); // Team | The Team to update (just include JSON object as request body)
Boolean brief = false; // Boolean | Optional, true if you wish to do a partial update containing only top level properties of the Team. When true, all sub-collections are ignored.
try {
    Team result = apiInstance.updateTeam(apiTeam, brief);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TeamsApi#updateTeam");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiTeam** | [**Team**](Team.md)| The Team to update (just include JSON object as request body) |
 **brief** | **Boolean**| Optional, true if you wish to do a partial update containing only top level properties of the Team. When true, all sub-collections are ignored. | [optional] [default to false]

### Return type

[**Team**](Team.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

