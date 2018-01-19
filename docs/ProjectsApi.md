# ProjectsApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addActivitySetAssignment**](ProjectsApi.md#addActivitySetAssignment) | **POST** /Projects/{id}/ActivitySetAssignment | Adds an Activity Set to a Project
[**addFileAttachment**](ProjectsApi.md#addFileAttachment) | **POST** /Projects/{id}/FileAttachments | Adds a File Attachment to a Project
[**addFollow**](ProjectsApi.md#addFollow) | **POST** /Projects/{id}/Follow | Start following a Project
[**addLink**](ProjectsApi.md#addLink) | **POST** /Projects/{id}/Links | Adds a Link to a project
[**addMilestone**](ProjectsApi.md#addMilestone) | **POST** /Projects/{id}/Milestones | Adds a Milestone to a Project
[**addNote**](ProjectsApi.md#addNote) | **POST** /Projects/{id}/Notes | Adds a Note to a Project.
[**addProject**](ProjectsApi.md#addProject) | **POST** /Projects | Adds a Project
[**addTag**](ProjectsApi.md#addTag) | **POST** /Projects/{id}/Tags | Adds a Tag for a Project
[**deleteCustomField**](ProjectsApi.md#deleteCustomField) | **DELETE** /Projects/{id}/CustomFields/{customFieldId} | Deletes a Custom Field
[**deleteFollow**](ProjectsApi.md#deleteFollow) | **DELETE** /Projects/{id}/Follow | Stop following a Project
[**deleteImage**](ProjectsApi.md#deleteImage) | **DELETE** /Projects/{id}/Image | Deletes a Project&#39;s Image
[**deleteLink**](ProjectsApi.md#deleteLink) | **DELETE** /Projects/{id}/Links/{linkId} | Deletes a Link from a project
[**deleteMilestone**](ProjectsApi.md#deleteMilestone) | **DELETE** /Projects/{id}/Milestones/{milestoneId} | Deletes a Milestone from a Project
[**deletePipeline**](ProjectsApi.md#deletePipeline) | **DELETE** /Projects/{id}/Pipeline | Clears pipeline for the Project.
[**deleteProject**](ProjectsApi.md#deleteProject) | **DELETE** /Projects/{id} | Deletes a Project
[**deleteTag**](ProjectsApi.md#deleteTag) | **DELETE** /Projects/{id}/Tags/{tagName} | Deletes a Tag from a Project
[**getEmails**](ProjectsApi.md#getEmails) | **GET** /Projects/{id}/Emails | Gets a list of Project&#39;s Emails
[**getEvents**](ProjectsApi.md#getEvents) | **GET** /Projects/{id}/Events | Gets a Project&#39;s Events
[**getFileAttachments**](ProjectsApi.md#getFileAttachments) | **GET** /Projects/{id}/FileAttachments | Gets a Project&#39;s File Attachments
[**getFollow**](ProjectsApi.md#getFollow) | **GET** /Projects/{id}/Follow | Gets a Follow record for the Project
[**getImage**](ProjectsApi.md#getImage) | **GET** /Projects/{id}/Image | Gets a Project&#39;s Image
[**getLinkEmailAddress**](ProjectsApi.md#getLinkEmailAddress) | **GET** /Projects/{id}/LinkEmailAddress | Gets the email address to use for linking with the Project
[**getMilestones**](ProjectsApi.md#getMilestones) | **GET** /Projects/{id}/Milestones | Gets a list of Milestones for a Project
[**getNotes**](ProjectsApi.md#getNotes) | **GET** /Projects/{id}/Notes | Gets a Project&#39;s Notes
[**getProject**](ProjectsApi.md#getProject) | **GET** /Projects/{id} | Gets a Project
[**getProjects**](ProjectsApi.md#getProjects) | **GET** /Projects | Gets a list of Projects.
[**getProjectsBySearch**](ProjectsApi.md#getProjectsBySearch) | **GET** /Projects/Search | Gets a filtered list of Projects.
[**getTasks**](ProjectsApi.md#getTasks) | **GET** /Projects/{id}/Tasks | Gets a list of Project&#39;s Tasks
[**updateCustomField**](ProjectsApi.md#updateCustomField) | **PUT** /Projects/{id}/CustomFields | Updates a Custom Field
[**updateImage**](ProjectsApi.md#updateImage) | **PUT** /Projects/{id}/Image/{filename} | Updates a Project&#39;s Image
[**updateLink**](ProjectsApi.md#updateLink) | **PUT** /Projects/{id}/Links | Updates a Link for a project
[**updateMilestone**](ProjectsApi.md#updateMilestone) | **PUT** /Projects/{id}/Milestones | Updates a Milestone for a Project
[**updatePipeline**](ProjectsApi.md#updatePipeline) | **PUT** /Projects/{id}/Pipeline | Changes current pipeline for the project.
[**updatePipelineStage**](ProjectsApi.md#updatePipelineStage) | **PUT** /Projects/{id}/PipelineStage | Changes current pipeline stage for the project.
[**updateProject**](ProjectsApi.md#updateProject) | **PUT** /Projects | Updates a Project


<a name="addActivitySetAssignment"></a>
# **addActivitySetAssignment**
> addActivitySetAssignment(id, apiActivitySetAssignment)

Adds an Activity Set to a Project

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID
ActivitySetAssignment apiActivitySetAssignment = new ActivitySetAssignment(); // ActivitySetAssignment | The Activity Set Assignment object which contains the configuration information for the Activity Set (just include JSON object as request body)
try {
    apiInstance.addActivitySetAssignment(id, apiActivitySetAssignment);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#addActivitySetAssignment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID |
 **apiActivitySetAssignment** | [**ActivitySetAssignment**](ActivitySetAssignment.md)| The Activity Set Assignment object which contains the configuration information for the Activity Set (just include JSON object as request body) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addFileAttachment"></a>
# **addFileAttachment**
> FileAttachment addFileAttachment(id, file, fileName, contentType, fileCategoryId)

Adds a File Attachment to a Project

This endpoint expects multipart/form-data as the request payload. See Stack Overflow for examples of how to generate multipart requests, or see our &lt;a href&#x3D;\&quot;http://github.com/Insightly\&quot; target&#x3D;\&quot;_blank\&quot;&gt;client libraries&lt;/a&gt; for an example of how this is generated. Only one file can be added per request.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
String file = "/path/to/file.txt"; // String | The file part of the multipart/form-data request. Only one file can be added per request.
String fileName = "fileName_example"; // String | 
String contentType = "contentType_example"; // String | 
Integer fileCategoryId = 56; // Integer | 
try {
    FileAttachment result = apiInstance.addFileAttachment(id, file, fileName, contentType, fileCategoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#addFileAttachment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |
 **file** | **String**| The file part of the multipart/form-data request. Only one file can be added per request. |
 **fileName** | **String**|  | [optional]
 **contentType** | **String**|  | [optional]
 **fileCategoryId** | **Integer**|  | [optional]

### Return type

[**FileAttachment**](FileAttachment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json, text/json

<a name="addFollow"></a>
# **addFollow**
> Follow addFollow(id)

Start following a Project

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
try {
    Follow result = apiInstance.addFollow(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#addFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |

### Return type

[**Follow**](Follow.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addLink"></a>
# **addLink**
> Link addLink(id, apiLink)

Adds a Link to a project

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
Link apiLink = new Link(); // Link | The Link to add (just include JSON object as request body)
try {
    Link result = apiInstance.addLink(id, apiLink);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#addLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |
 **apiLink** | [**Link**](Link.md)| The Link to add (just include JSON object as request body) |

### Return type

[**Link**](Link.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addMilestone"></a>
# **addMilestone**
> Milestone addMilestone(id, apiMilestone)

Adds a Milestone to a Project

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
Milestone apiMilestone = new Milestone(); // Milestone | The Milestone to add (just include JSON object as request body)
try {
    Milestone result = apiInstance.addMilestone(id, apiMilestone);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#addMilestone");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |
 **apiMilestone** | [**Milestone**](Milestone.md)| The Milestone to add (just include JSON object as request body) |

### Return type

[**Milestone**](Milestone.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addNote"></a>
# **addNote**
> Note addNote(id, apiNote)

Adds a Note to a Project.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
Note apiNote = new Note(); // Note | The Note to add (just include JSON object as request body)
try {
    Note result = apiInstance.addNote(id, apiNote);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#addNote");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |
 **apiNote** | [**Note**](Note.md)| The Note to add (just include JSON object as request body) |

### Return type

[**Note**](Note.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addProject"></a>
# **addProject**
> Project addProject(apiProject)

Adds a Project

A common source of problems when creating projects occurs when users omit required fields, or insert             invalid data into a field (for example by referencing an invalid CATEGORY_ID). A good troubleshooting technique             is to create a few projects via the web interface, with representative data, links, etc, and then access             these projects via the API, and inspect the returned object graph. Also, note: The STAGE_ID and PIPELINE_ID             properties of projects are read-only. (There are separate endpoints to update pipelines/stages.)

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Project apiProject = new Project(); // Project | The Project to add (just include JSON object as request body)
try {
    Project result = apiInstance.addProject(apiProject);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#addProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiProject** | [**Project**](Project.md)| The Project to add (just include JSON object as request body) |

### Return type

[**Project**](Project.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addTag"></a>
# **addTag**
> Tag addTag(id, apiTag)

Adds a Tag for a Project

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
Tag apiTag = new Tag(); // Tag | The Tag to add (just include JSON object as request body)
try {
    Tag result = apiInstance.addTag(id, apiTag);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#addTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |
 **apiTag** | [**Tag**](Tag.md)| The Tag to add (just include JSON object as request body) |

### Return type

[**Tag**](Tag.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteCustomField"></a>
# **deleteCustomField**
> deleteCustomField(id, customFieldId)

Deletes a Custom Field

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (Project_ID)
String customFieldId = "customFieldId_example"; // String | A Custom Field's ID (CUSTOM_FIELD_ID)
try {
    apiInstance.deleteCustomField(id, customFieldId);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#deleteCustomField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (Project_ID) |
 **customFieldId** | **String**| A Custom Field&#39;s ID (CUSTOM_FIELD_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteFollow"></a>
# **deleteFollow**
> deleteFollow(id)

Stop following a Project

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
try {
    apiInstance.deleteFollow(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#deleteFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteImage"></a>
# **deleteImage**
> deleteImage(id)

Deletes a Project&#39;s Image



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
try {
    apiInstance.deleteImage(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#deleteImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteLink"></a>
# **deleteLink**
> deleteLink(id, linkId)

Deletes a Link from a project

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
Long linkId = 789L; // Long | A Link's ID (LINK_ID)
try {
    apiInstance.deleteLink(id, linkId);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#deleteLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |
 **linkId** | **Long**| A Link&#39;s ID (LINK_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteMilestone"></a>
# **deleteMilestone**
> deleteMilestone(id, milestoneId)

Deletes a Milestone from a Project

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
Long milestoneId = 789L; // Long | A Milestone's ID (MILESTONE_ID)
try {
    apiInstance.deleteMilestone(id, milestoneId);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#deleteMilestone");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |
 **milestoneId** | **Long**| A Milestone&#39;s ID (MILESTONE_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deletePipeline"></a>
# **deletePipeline**
> Project deletePipeline(id)

Clears pipeline for the Project.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID
try {
    Project result = apiInstance.deletePipeline(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#deletePipeline");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID |

### Return type

[**Project**](Project.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteProject"></a>
# **deleteProject**
> deleteProject(id)

Deletes a Project



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID
try {
    apiInstance.deleteProject(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#deleteProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteTag"></a>
# **deleteTag**
> deleteTag(id, tagName)

Deletes a Tag from a Project

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
String tagName = "tagName_example"; // String | A Tag's name
try {
    apiInstance.deleteTag(id, tagName);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#deleteTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |
 **tagName** | **String**| A Tag&#39;s name |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="getEmails"></a>
# **getEmails**
> List&lt;Email&gt; getEmails(id, updatedAfterUtc, top, skip, brief, countTotal)

Gets a list of Project&#39;s Emails

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when email was last updated.
Integer top = 56; // Integer | Optional, maximum number of emails to return.
Integer skip = 56; // Integer | Optional, number of emails to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<Email> result = apiInstance.getEmails(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#getEmails");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID |
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when email was last updated. | [optional]
 **top** | **Integer**| Optional, maximum number of emails to return. | [optional]
 **skip** | **Integer**| Optional, number of emails to skip. | [optional]
 **brief** | **Boolean**| true if only top level properties needs to be returned. | [optional] [default to false]
 **countTotal** | **Boolean**| true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Email&gt;**](Email.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getEvents"></a>
# **getEvents**
> List&lt;CalendarEvent&gt; getEvents(id, updatedAfterUtc, top, skip, brief, countTotal)

Gets a Project&#39;s Events

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when event was last updated.
Integer top = 56; // Integer | Optional, maximum number of events to return.
Integer skip = 56; // Integer | Optional, number of events to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<CalendarEvent> result = apiInstance.getEvents(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#getEvents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when event was last updated. | [optional]
 **top** | **Integer**| Optional, maximum number of events to return. | [optional]
 **skip** | **Integer**| Optional, number of events to skip. | [optional]
 **brief** | **Boolean**| true if only top level properties needs to be returned. | [optional] [default to false]
 **countTotal** | **Boolean**| true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;CalendarEvent&gt;**](CalendarEvent.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFileAttachments"></a>
# **getFileAttachments**
> List&lt;FileAttachment&gt; getFileAttachments(id, updatedAfterUtc, skip, top, countTotal)

Gets a Project&#39;s File Attachments

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when file attachment was last updated.
Integer skip = 56; // Integer | Optional, number of file attachments to skip.
Integer top = 56; // Integer | Optional, maximum number of file attachments to return in the response.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<FileAttachment> result = apiInstance.getFileAttachments(id, updatedAfterUtc, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#getFileAttachments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when file attachment was last updated. | [optional]
 **skip** | **Integer**| Optional, number of file attachments to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of file attachments to return in the response. | [optional]
 **countTotal** | **Boolean**| true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;FileAttachment&gt;**](FileAttachment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFollow"></a>
# **getFollow**
> Follow getFollow(id)

Gets a Follow record for the Project

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
try {
    Follow result = apiInstance.getFollow(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#getFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |

### Return type

[**Follow**](Follow.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getImage"></a>
# **getImage**
> getImage(id)

Gets a Project&#39;s Image



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
try {
    apiInstance.getImage(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#getImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

<a name="getLinkEmailAddress"></a>
# **getLinkEmailAddress**
> LinkEmailAddress getLinkEmailAddress(id)

Gets the email address to use for linking with the Project

An email address to use as a maildrop for the Project.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID
try {
    LinkEmailAddress result = apiInstance.getLinkEmailAddress(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#getLinkEmailAddress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID |

### Return type

[**LinkEmailAddress**](LinkEmailAddress.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getMilestones"></a>
# **getMilestones**
> List&lt;Milestone&gt; getMilestones(id)

Gets a list of Milestones for a Project

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
try {
    List<Milestone> result = apiInstance.getMilestones(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#getMilestones");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |

### Return type

[**List&lt;Milestone&gt;**](Milestone.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getNotes"></a>
# **getNotes**
> List&lt;Note&gt; getNotes(id, updatedAfterUtc, top, skip, brief, countTotal)

Gets a Project&#39;s Notes

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when note was last updated.
Integer top = 56; // Integer | Optional, maximum number of notes to return.
Integer skip = 56; // Integer | Optional, number of notes to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<Note> result = apiInstance.getNotes(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#getNotes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when note was last updated. | [optional]
 **top** | **Integer**| Optional, maximum number of notes to return. | [optional]
 **skip** | **Integer**| Optional, number of notes to skip. | [optional]
 **brief** | **Boolean**| true if only top level properties needs to be returned. | [optional] [default to false]
 **countTotal** | **Boolean**| true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Note&gt;**](Note.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getProject"></a>
# **getProject**
> Project getProject(id)

Gets a Project



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID
try {
    Project result = apiInstance.getProject(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#getProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID |

### Return type

[**Project**](Project.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getProjects"></a>
# **getProjects**
> List&lt;Project&gt; getProjects(brief, skip, top, countTotal)

Gets a list of Projects.

Simple object graphs (excluding CUSTOMFIELDS, TAGS, etc.) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the project.
Integer skip = 56; // Integer | Optional, number of projects to skip.
Integer top = 56; // Integer | Optional, maximum number of projects to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Project> result = apiInstance.getProjects(brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#getProjects");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the project. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of projects to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of projects to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Project&gt;**](Project.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getProjectsBySearch"></a>
# **getProjectsBySearch**
> List&lt;Project&gt; getProjectsBySearch(tag, projectName, status, categoryId, pipelineId, stageId, responsibleUserId, ownerUserId, updatedAfterUtc, brief, skip, top, countTotal)

Gets a filtered list of Projects.

Only one optional parameter (excluding brief, top, skip and count_total) can be specified. Simple object graphs (excluding CUSTOMFIELDS, TAGS, etc.) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
String tag = "tag_example"; // String | Optional, a single tag.
String projectName = "projectName_example"; // String | Optional, project name.
String status = "status_example"; // String | Optional, project status.
Long categoryId = 789L; // Long | Optional, category id.
Long pipelineId = 789L; // Long | Optional, pipeline id.
Long stageId = 789L; // Long | Optional, stage id.
Long responsibleUserId = 789L; // Long | Optional, responsible user id.
Long ownerUserId = 789L; // Long | Optional, owner user id.
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when project was last updated.
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the project.
Integer skip = 56; // Integer | Optional, number of projects to skip.
Integer top = 56; // Integer | Optional, maximum number of projects to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Project> result = apiInstance.getProjectsBySearch(tag, projectName, status, categoryId, pipelineId, stageId, responsibleUserId, ownerUserId, updatedAfterUtc, brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#getProjectsBySearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tag** | **String**| Optional, a single tag. | [optional]
 **projectName** | **String**| Optional, project name. | [optional]
 **status** | **String**| Optional, project status. | [optional]
 **categoryId** | **Long**| Optional, category id. | [optional]
 **pipelineId** | **Long**| Optional, pipeline id. | [optional]
 **stageId** | **Long**| Optional, stage id. | [optional]
 **responsibleUserId** | **Long**| Optional, responsible user id. | [optional]
 **ownerUserId** | **Long**| Optional, owner user id. | [optional]
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when project was last updated. | [optional]
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the project. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of projects to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of projects to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Project&gt;**](Project.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getTasks"></a>
# **getTasks**
> List&lt;Task&gt; getTasks(id, updatedAfterUtc, top, skip, brief, countTotal)

Gets a list of Project&#39;s Tasks

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when task was last updated.
Integer top = 56; // Integer | Optional, maximum number of tasks to return.
Integer skip = 56; // Integer | Optional, number of tasks to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<Task> result = apiInstance.getTasks(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#getTasks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID |
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when task was last updated. | [optional]
 **top** | **Integer**| Optional, maximum number of tasks to return. | [optional]
 **skip** | **Integer**| Optional, number of tasks to skip. | [optional]
 **brief** | **Boolean**| true if only top level properties needs to be returned. | [optional] [default to false]
 **countTotal** | **Boolean**| true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Task&gt;**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateCustomField"></a>
# **updateCustomField**
> CustomField updateCustomField(id, apiCustomField)

Updates a Custom Field

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (Project_ID)
CustomField apiCustomField = new CustomField(); // CustomField | The Custom Field to edit (just include JSON object as request body)
try {
    CustomField result = apiInstance.updateCustomField(id, apiCustomField);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#updateCustomField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (Project_ID) |
 **apiCustomField** | [**CustomField**](CustomField.md)| The Custom Field to edit (just include JSON object as request body) |

### Return type

[**CustomField**](CustomField.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="updateImage"></a>
# **updateImage**
> Project updateImage(id, filename, file)

Updates a Project&#39;s Image

This action will replace any existing Image attached to the Project. Image file contents should be sent as binary data in request payload. See our &lt;a href&#x3D;\&quot;http://github.com/Insightly\&quot; target&#x3D;\&quot;_blank\&quot;&gt;client libraries&lt;/a&gt; for an example of how this is done.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
String filename = "filename_example"; // String | Name of Image File to be attached to Project
byte[] file = BINARY_DATA_HERE; // byte[] | File to upload
try {
    Project result = apiInstance.updateImage(id, filename, file);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#updateImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |
 **filename** | **String**| Name of Image File to be attached to Project |
 **file** | **byte[]**| File to upload |

### Return type

[**Project**](Project.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: application/json, text/json

<a name="updateLink"></a>
# **updateLink**
> Link updateLink(id, apiLink)

Updates a Link for a project

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
Link apiLink = new Link(); // Link | The Link to add (just include JSON object as request body)
try {
    Link result = apiInstance.updateLink(id, apiLink);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#updateLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |
 **apiLink** | [**Link**](Link.md)| The Link to add (just include JSON object as request body) |

### Return type

[**Link**](Link.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="updateMilestone"></a>
# **updateMilestone**
> Milestone updateMilestone(id, apiMilestone)

Updates a Milestone for a Project

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID (PROJECT_ID)
Milestone apiMilestone = new Milestone(); // Milestone | The Milestone to update (just include JSON object as request body)
try {
    Milestone result = apiInstance.updateMilestone(id, apiMilestone);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#updateMilestone");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID (PROJECT_ID) |
 **apiMilestone** | [**Milestone**](Milestone.md)| The Milestone to update (just include JSON object as request body) |

### Return type

[**Milestone**](Milestone.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="updatePipeline"></a>
# **updatePipeline**
> Project updatePipeline(id, apiPipelineChange)

Changes current pipeline for the project.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID
PipelineChange apiPipelineChange = new PipelineChange(); // PipelineChange | Pipeline change parameters (just include JSON object as request body)
try {
    Project result = apiInstance.updatePipeline(id, apiPipelineChange);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#updatePipeline");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID |
 **apiPipelineChange** | [**PipelineChange**](PipelineChange.md)| Pipeline change parameters (just include JSON object as request body) |

### Return type

[**Project**](Project.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="updatePipelineStage"></a>
# **updatePipelineStage**
> Project updatePipelineStage(id, apiStageChange)

Changes current pipeline stage for the project.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Long id = 789L; // Long | A Project's ID
PipelineStageChange apiStageChange = new PipelineStageChange(); // PipelineStageChange | Pipeline stage change parameters (just include JSON object as request body)
try {
    Project result = apiInstance.updatePipelineStage(id, apiStageChange);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#updatePipelineStage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Project&#39;s ID |
 **apiStageChange** | [**PipelineStageChange**](PipelineStageChange.md)| Pipeline stage change parameters (just include JSON object as request body) |

### Return type

[**Project**](Project.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="updateProject"></a>
# **updateProject**
> Project updateProject(apiProject, brief)

Updates a Project

A common source of problems when updating projects occurs when users omit required fields, or insert             invalid data into a field (for example by referencing an invalid CATEGORY_ID). A good troubleshooting technique             is to create a few projects via the web interface, with representative data, links, etc, and then access             these projects via the API, and inspect the returned object graph. Also, note: The STAGE_ID and PIPELINE_ID             properties of projects are read-only. (There are separate endpoints to update pipelines/stages.)

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ProjectsApi;


ProjectsApi apiInstance = new ProjectsApi();
Project apiProject = new Project(); // Project | A Project (just include JSON object as request body)
Boolean brief = false; // Boolean | Optional, true if you wish to do a partial update containing only top level properties of the Project. When true, all sub-collections are ignored.
try {
    Project result = apiInstance.updateProject(apiProject, brief);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProjectsApi#updateProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiProject** | [**Project**](Project.md)| A Project (just include JSON object as request body) |
 **brief** | **Boolean**| Optional, true if you wish to do a partial update containing only top level properties of the Project. When true, all sub-collections are ignored. | [optional] [default to false]

### Return type

[**Project**](Project.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

