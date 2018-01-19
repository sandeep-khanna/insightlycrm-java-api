# OpportunitiesApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addActivitySetAssignment**](OpportunitiesApi.md#addActivitySetAssignment) | **POST** /Opportunities/{id}/ActivitySetAssignment | Adds an Activity Set to an Opportunity
[**addFileAttachment**](OpportunitiesApi.md#addFileAttachment) | **POST** /Opportunities/{id}/FileAttachments | Adds a File Attachment to an Opportunity
[**addFollow**](OpportunitiesApi.md#addFollow) | **POST** /Opportunities/{id}/Follow | Start following an Opportunity
[**addLink**](OpportunitiesApi.md#addLink) | **POST** /Opportunities/{id}/Links | Adds a Link
[**addNote**](OpportunitiesApi.md#addNote) | **POST** /Opportunities/{id}/Notes | Adds a Note to an Opportunity.
[**addOpportunity**](OpportunitiesApi.md#addOpportunity) | **POST** /Opportunities | Adds an Opportunity
[**addTag**](OpportunitiesApi.md#addTag) | **POST** /Opportunities/{id}/Tags | Adds a Tag for an Opportunity
[**deleteCustomField**](OpportunitiesApi.md#deleteCustomField) | **DELETE** /Opportunities/{id}/CustomFields/{customFieldId} | Deletes a Custom Field
[**deleteFollow**](OpportunitiesApi.md#deleteFollow) | **DELETE** /Opportunities/{id}/Follow | Stop following an Opportunity
[**deleteImage**](OpportunitiesApi.md#deleteImage) | **DELETE** /Opportunities/{id}/Image | Deletes an Opportunity&#39;s Image
[**deleteLink**](OpportunitiesApi.md#deleteLink) | **DELETE** /Opportunities/{id}/Links/{linkId} | Deletes a Link
[**deleteOpportunity**](OpportunitiesApi.md#deleteOpportunity) | **DELETE** /Opportunities/{id} | Deletes an Opportunity
[**deletePipeline**](OpportunitiesApi.md#deletePipeline) | **DELETE** /Opportunities/{id}/Pipeline | Clears pipeline for the opportunity.
[**deleteTag**](OpportunitiesApi.md#deleteTag) | **DELETE** /Opportunities/{id}/Tags/{tagName} | Deletes a Tag from an Opportunity
[**getEmails**](OpportunitiesApi.md#getEmails) | **GET** /Opportunities/{id}/Emails | Gets a list of Opportunity&#39;s Emails
[**getEvents**](OpportunitiesApi.md#getEvents) | **GET** /Opportunities/{id}/Events | Gets an Opportunity&#39;s Events
[**getFileAttachments**](OpportunitiesApi.md#getFileAttachments) | **GET** /Opportunities/{id}/FileAttachments | Gets an Opportunity&#39;s File Attachments
[**getFollow**](OpportunitiesApi.md#getFollow) | **GET** /Opportunities/{id}/Follow | Gets a Follow record for the Opportunity
[**getImage**](OpportunitiesApi.md#getImage) | **GET** /Opportunities/{id}/Image | Gets an Opportunity&#39;s Image
[**getLinkEmailAddress**](OpportunitiesApi.md#getLinkEmailAddress) | **GET** /Opportunities/{id}/LinkEmailAddress | Gets the email address to use for linking with the opportunity
[**getNotes**](OpportunitiesApi.md#getNotes) | **GET** /Opportunities/{id}/Notes | Gets an Opportunity&#39;s Notes
[**getOpportunities**](OpportunitiesApi.md#getOpportunities) | **GET** /Opportunities | Gets a list of Opportunities.
[**getOpportunitiesBySearch**](OpportunitiesApi.md#getOpportunitiesBySearch) | **GET** /Opportunities/Search | Gets a filtered list of Opportunities.
[**getOpportunity**](OpportunitiesApi.md#getOpportunity) | **GET** /Opportunities/{id} | Gets an Opportunity
[**getStateHistory**](OpportunitiesApi.md#getStateHistory) | **GET** /Opportunities/{id}/StateHistory | Gets the history of States and Reasons for an Opportunity.
[**getTasks**](OpportunitiesApi.md#getTasks) | **GET** /Opportunities/{id}/Tasks | Gets a list of Opportunity&#39;s Tasks
[**updateCustomField**](OpportunitiesApi.md#updateCustomField) | **PUT** /Opportunities/{id}/CustomFields | Updates a Custom Field
[**updateImage**](OpportunitiesApi.md#updateImage) | **PUT** /Opportunities/{id}/Image/{filename} | Updates an Opportunity&#39;s Image
[**updateLink**](OpportunitiesApi.md#updateLink) | **PUT** /Opportunities/{id}/Links | Updates a Link
[**updateOpportunity**](OpportunitiesApi.md#updateOpportunity) | **PUT** /Opportunities | Updates an Opportunity
[**updatePipeline**](OpportunitiesApi.md#updatePipeline) | **PUT** /Opportunities/{id}/Pipeline | Changes current pipeline for the opportunity.
[**updatePipelineStage**](OpportunitiesApi.md#updatePipelineStage) | **PUT** /Opportunities/{id}/PipelineStage | Changes current pipeline stage for the opportunity.


<a name="addActivitySetAssignment"></a>
# **addActivitySetAssignment**
> addActivitySetAssignment(id, apiActivitySetAssignment)

Adds an Activity Set to an Opportunity

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | A Opportunity's ID
ActivitySetAssignment apiActivitySetAssignment = new ActivitySetAssignment(); // ActivitySetAssignment | The Activity Set Assignment object which contains the configuration information for the Activity Set (just include JSON object as request body)
try {
    apiInstance.addActivitySetAssignment(id, apiActivitySetAssignment);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#addActivitySetAssignment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Opportunity&#39;s ID |
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

Adds a File Attachment to an Opportunity

This endpoint expects multipart/form-data as the request payload. See Stack Overflow for examples of how to generate multipart requests, or see our &lt;a href&#x3D;\&quot;http://github.com/Insightly\&quot; target&#x3D;\&quot;_blank\&quot;&gt;client libraries&lt;/a&gt; for an example of how this is generated. Only one file can be added per request.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID (OPPORTUNITY_ID)
String file = "/path/to/file.txt"; // String | The file part of the multipart/form-data request. Only one file can be added per request.
String fileName = "fileName_example"; // String | 
String contentType = "contentType_example"; // String | 
Integer fileCategoryId = 56; // Integer | 
try {
    FileAttachment result = apiInstance.addFileAttachment(id, file, fileName, contentType, fileCategoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#addFileAttachment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID (OPPORTUNITY_ID) |
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

Start following an Opportunity

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID (OPPORTUNITY_ID)
try {
    Follow result = apiInstance.addFollow(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#addFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID (OPPORTUNITY_ID) |

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

Adds a Link

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID (OPPORTUNITY_ID)
Link apiLink = new Link(); // Link | The Link to add (just include JSON object as request body)
try {
    Link result = apiInstance.addLink(id, apiLink);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#addLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID (OPPORTUNITY_ID) |
 **apiLink** | [**Link**](Link.md)| The Link to add (just include JSON object as request body) |

### Return type

[**Link**](Link.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addNote"></a>
# **addNote**
> Note addNote(id, apiNote)

Adds a Note to an Opportunity.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID (OPPORTUNITY_ID)
Note apiNote = new Note(); // Note | The Note to add (just include JSON object as request body)
try {
    Note result = apiInstance.addNote(id, apiNote);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#addNote");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID (OPPORTUNITY_ID) |
 **apiNote** | [**Note**](Note.md)| The Note to add (just include JSON object as request body) |

### Return type

[**Note**](Note.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addOpportunity"></a>
# **addOpportunity**
> Opportunity addOpportunity(apiOpportunity)

Adds an Opportunity

A common source of problems when creating opportunities occurs when users omit required fields, or insert             invalid data into a field (for example by referencing an invalid CATEGORY_ID). A good troubleshooting technique             is to create a few opportunities via the web interface, with representative data, links, etc, and then access             these opportunities via the GET method, and inspect the returned object graph. Also, note: The STAGE_ID and             PIPELINE_ID properties of opportunities are read-only. (There are separate endpoints to update pipelines/stages.)

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Opportunity apiOpportunity = new Opportunity(); // Opportunity | The Opportunity to add (just include JSON object as request body)
try {
    Opportunity result = apiInstance.addOpportunity(apiOpportunity);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#addOpportunity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiOpportunity** | [**Opportunity**](Opportunity.md)| The Opportunity to add (just include JSON object as request body) |

### Return type

[**Opportunity**](Opportunity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addTag"></a>
# **addTag**
> Tag addTag(id, apiTag)

Adds a Tag for an Opportunity

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID (OPPORTUNITY_ID)
Tag apiTag = new Tag(); // Tag | The Tag to add (just include JSON object as request body)
try {
    Tag result = apiInstance.addTag(id, apiTag);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#addTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID (OPPORTUNITY_ID) |
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
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID (OPPORTUNITY_ID)
String customFieldId = "customFieldId_example"; // String | A Custom Field's ID (CUSTOM_FIELD_ID)
try {
    apiInstance.deleteCustomField(id, customFieldId);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#deleteCustomField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID (OPPORTUNITY_ID) |
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

Stop following an Opportunity

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID (OPPORTUNITY_ID)
try {
    apiInstance.deleteFollow(id);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#deleteFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID (OPPORTUNITY_ID) |

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

Deletes an Opportunity&#39;s Image



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID (OPPORTUNITY_ID)
try {
    apiInstance.deleteImage(id);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#deleteImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID (OPPORTUNITY_ID) |

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

Deletes a Link

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID (OPPORTUNITY_ID)
Long linkId = 789L; // Long | A Link's ID (LINK_ID)
try {
    apiInstance.deleteLink(id, linkId);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#deleteLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID (OPPORTUNITY_ID) |
 **linkId** | **Long**| A Link&#39;s ID (LINK_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteOpportunity"></a>
# **deleteOpportunity**
> deleteOpportunity(id)

Deletes an Opportunity



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID
try {
    apiInstance.deleteOpportunity(id);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#deleteOpportunity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deletePipeline"></a>
# **deletePipeline**
> Opportunity deletePipeline(id)

Clears pipeline for the opportunity.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID
try {
    Opportunity result = apiInstance.deletePipeline(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#deletePipeline");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID |

### Return type

[**Opportunity**](Opportunity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteTag"></a>
# **deleteTag**
> deleteTag(id, tagName)

Deletes a Tag from an Opportunity

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID (OPPORTUNITY_ID)
String tagName = "tagName_example"; // String | A Tag's name
try {
    apiInstance.deleteTag(id, tagName);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#deleteTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID (OPPORTUNITY_ID) |
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

Gets a list of Opportunity&#39;s Emails

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when email was last updated.
Integer top = 56; // Integer | Optional, maximum number of emails to return.
Integer skip = 56; // Integer | Optional, number of emails to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<Email> result = apiInstance.getEmails(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#getEmails");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID |
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

Gets an Opportunity&#39;s Events

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID (OPPORTUNITY_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when event was last updated.
Integer top = 56; // Integer | Optional, maximum number of events to return.
Integer skip = 56; // Integer | Optional, number of events to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<CalendarEvent> result = apiInstance.getEvents(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#getEvents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID (OPPORTUNITY_ID) |
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

Gets an Opportunity&#39;s File Attachments

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID (OPPORTUNITY_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when file attachment was last updated.
Integer skip = 56; // Integer | Optional, number of file attachments to skip.
Integer top = 56; // Integer | Optional, maximum number of file attachments to return in the response.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<FileAttachment> result = apiInstance.getFileAttachments(id, updatedAfterUtc, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#getFileAttachments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID (OPPORTUNITY_ID) |
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

Gets a Follow record for the Opportunity

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID (OPPORTUNITY_ID)
try {
    Follow result = apiInstance.getFollow(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#getFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID (OPPORTUNITY_ID) |

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

Gets an Opportunity&#39;s Image



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID (OPPORTUNITY_ID)
try {
    apiInstance.getImage(id);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#getImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID (OPPORTUNITY_ID) |

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

Gets the email address to use for linking with the opportunity

An email address to use as a maildrop for the Opportunity.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID
try {
    LinkEmailAddress result = apiInstance.getLinkEmailAddress(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#getLinkEmailAddress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID |

### Return type

[**LinkEmailAddress**](LinkEmailAddress.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getNotes"></a>
# **getNotes**
> List&lt;Note&gt; getNotes(id, updatedAfterUtc, top, skip, brief, countTotal)

Gets an Opportunity&#39;s Notes

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID (OPPORRTUNITY_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when note was last updated.
Integer top = 56; // Integer | Optional, maximum number of notes to return.
Integer skip = 56; // Integer | Optional, number of notes to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<Note> result = apiInstance.getNotes(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#getNotes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID (OPPORRTUNITY_ID) |
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

<a name="getOpportunities"></a>
# **getOpportunities**
> List&lt;Opportunity&gt; getOpportunities(brief, skip, top, countTotal)

Gets a list of Opportunities.

Simple object graphs (excluding Custom Fields, Tags, etc.) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the opportunity.
Integer skip = 56; // Integer | Optional, number of opportunities to skip.
Integer top = 56; // Integer | Optional, maximum number of opportunities to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Opportunity> result = apiInstance.getOpportunities(brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#getOpportunities");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the opportunity. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of opportunities to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of opportunities to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Opportunity&gt;**](Opportunity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getOpportunitiesBySearch"></a>
# **getOpportunitiesBySearch**
> List&lt;Opportunity&gt; getOpportunitiesBySearch(tag, opportunityName, opportunityState, categoryId, pipelineId, stageId, responsibleUserId, ownerUserId, forecastCloseDate, actualCloseDate, updatedAfterUtc, brief, skip, top, countTotal)

Gets a filtered list of Opportunities.

Only one optional parameter (excluding brief, top, skip and count_total) can be specified. Simple object graphs (excluding Custom Fields, Tags, etc.) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
String tag = "tag_example"; // String | Optional, a single tag.
String opportunityName = "opportunityName_example"; // String | Optional, opportuinty name.
String opportunityState = "opportunityState_example"; // String | Optional, opportunity state.
Long categoryId = 789L; // Long | Optional, category id.
Long pipelineId = 789L; // Long | Optional, pipeline id.
Long stageId = 789L; // Long | Optional, stage id.
Long responsibleUserId = 789L; // Long | Optional, responsible user id.
Long ownerUserId = 789L; // Long | Optional, owner user id.
OffsetDateTime forecastCloseDate = new OffsetDateTime(); // OffsetDateTime | Optional, forecast close date.
OffsetDateTime actualCloseDate = new OffsetDateTime(); // OffsetDateTime | Optional, actual close date.
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when opportunity was last updated.
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the opportunity.
Integer skip = 56; // Integer | Optional, number of opportunities to skip.
Integer top = 56; // Integer | Optional, maximum number of opportunities to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Opportunity> result = apiInstance.getOpportunitiesBySearch(tag, opportunityName, opportunityState, categoryId, pipelineId, stageId, responsibleUserId, ownerUserId, forecastCloseDate, actualCloseDate, updatedAfterUtc, brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#getOpportunitiesBySearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **tag** | **String**| Optional, a single tag. | [optional]
 **opportunityName** | **String**| Optional, opportuinty name. | [optional]
 **opportunityState** | **String**| Optional, opportunity state. | [optional]
 **categoryId** | **Long**| Optional, category id. | [optional]
 **pipelineId** | **Long**| Optional, pipeline id. | [optional]
 **stageId** | **Long**| Optional, stage id. | [optional]
 **responsibleUserId** | **Long**| Optional, responsible user id. | [optional]
 **ownerUserId** | **Long**| Optional, owner user id. | [optional]
 **forecastCloseDate** | **OffsetDateTime**| Optional, forecast close date. | [optional]
 **actualCloseDate** | **OffsetDateTime**| Optional, actual close date. | [optional]
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when opportunity was last updated. | [optional]
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the opportunity. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of opportunities to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of opportunities to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Opportunity&gt;**](Opportunity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getOpportunity"></a>
# **getOpportunity**
> Opportunity getOpportunity(id)

Gets an Opportunity

Returns the Opportunity object&#39;s full graph. Prior to attempting POST and PUT operations,             we recommend using this method to fetch an existing object and make incremental changes to it.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID
try {
    Opportunity result = apiInstance.getOpportunity(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#getOpportunity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID |

### Return type

[**Opportunity**](Opportunity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getStateHistory"></a>
# **getStateHistory**
> List&lt;OpportunityState&gt; getStateHistory(id)

Gets the history of States and Reasons for an Opportunity.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID
try {
    List<OpportunityState> result = apiInstance.getStateHistory(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#getStateHistory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID |

### Return type

[**List&lt;OpportunityState&gt;**](OpportunityState.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getTasks"></a>
# **getTasks**
> List&lt;Task&gt; getTasks(id, updatedAfterUtc, top, skip, brief, countTotal)

Gets a list of Opportunity&#39;s Tasks

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when task was last updated.
Integer top = 56; // Integer | Optional, maximum number of tasks to return.
Integer skip = 56; // Integer | Optional, number of tasks to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<Task> result = apiInstance.getTasks(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#getTasks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID |
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
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID (OPPORTUNITY_ID)
CustomField apiCustomField = new CustomField(); // CustomField | The Custom Field to edit (just include JSON object as request body)
try {
    CustomField result = apiInstance.updateCustomField(id, apiCustomField);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#updateCustomField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID (OPPORTUNITY_ID) |
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
> Opportunity updateImage(id, filename, file)

Updates an Opportunity&#39;s Image

This action will replace any existing Image attached to the Opportunity. Image file contents should be sent as binary data in request payload. See our &lt;a href&#x3D;\&quot;http://github.com/Insightly\&quot; target&#x3D;\&quot;_blank\&quot;&gt;client libraries&lt;/a&gt; for an example of how this is done.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID (OPPORTUNITY_ID)
String filename = "filename_example"; // String | Name of Image File to be attached to Opportunity
byte[] file = BINARY_DATA_HERE; // byte[] | File to upload
try {
    Opportunity result = apiInstance.updateImage(id, filename, file);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#updateImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID (OPPORTUNITY_ID) |
 **filename** | **String**| Name of Image File to be attached to Opportunity |
 **file** | **byte[]**| File to upload |

### Return type

[**Opportunity**](Opportunity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: application/json, text/json

<a name="updateLink"></a>
# **updateLink**
> Link updateLink(id, apiLink)

Updates a Link

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID (OPPORTUNITY_ID)
Link apiLink = new Link(); // Link | The Link to add (just include JSON object as request body)
try {
    Link result = apiInstance.updateLink(id, apiLink);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#updateLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID (OPPORTUNITY_ID) |
 **apiLink** | [**Link**](Link.md)| The Link to add (just include JSON object as request body) |

### Return type

[**Link**](Link.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="updateOpportunity"></a>
# **updateOpportunity**
> Opportunity updateOpportunity(apiOpportunity, brief)

Updates an Opportunity

A common source of problems when updating opportunities occurs when users omit required fields, or insert             invalid data into a field (for example by referencing an invalid CATEGORY_ID). A good troubleshooting technique             is to create a few opportunities via the web interface, with representative data, links, etc, and then access             these opportunities via the GET method, and inspect the returned object graph. Also, note: The STAGE_ID and             PIPELINE_ID properties of opportunities are read-only. (There are separate endpoints to update pipelines/stages.)

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Opportunity apiOpportunity = new Opportunity(); // Opportunity | An Opportunity (just include JSON object as request body)
Boolean brief = false; // Boolean | Optional, true if you wish to do a partial update containing only top level properties of the Opportunity. When true, all sub-collections are ignored.
try {
    Opportunity result = apiInstance.updateOpportunity(apiOpportunity, brief);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#updateOpportunity");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiOpportunity** | [**Opportunity**](Opportunity.md)| An Opportunity (just include JSON object as request body) |
 **brief** | **Boolean**| Optional, true if you wish to do a partial update containing only top level properties of the Opportunity. When true, all sub-collections are ignored. | [optional] [default to false]

### Return type

[**Opportunity**](Opportunity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="updatePipeline"></a>
# **updatePipeline**
> Opportunity updatePipeline(id, apiPipelineChange)

Changes current pipeline for the opportunity.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID
PipelineChange apiPipelineChange = new PipelineChange(); // PipelineChange | Pipeline change parameters (just include JSON object as request body)
try {
    Opportunity result = apiInstance.updatePipeline(id, apiPipelineChange);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#updatePipeline");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID |
 **apiPipelineChange** | [**PipelineChange**](PipelineChange.md)| Pipeline change parameters (just include JSON object as request body) |

### Return type

[**Opportunity**](Opportunity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="updatePipelineStage"></a>
# **updatePipelineStage**
> Opportunity updatePipelineStage(id, apiStageChange)

Changes current pipeline stage for the opportunity.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunitiesApi;


OpportunitiesApi apiInstance = new OpportunitiesApi();
Long id = 789L; // Long | An Opportunity's ID
PipelineStageChange apiStageChange = new PipelineStageChange(); // PipelineStageChange | Pipeline stage change parameters (just include JSON object as request body)
try {
    Opportunity result = apiInstance.updatePipelineStage(id, apiStageChange);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunitiesApi#updatePipelineStage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity&#39;s ID |
 **apiStageChange** | [**PipelineStageChange**](PipelineStageChange.md)| Pipeline stage change parameters (just include JSON object as request body) |

### Return type

[**Opportunity**](Opportunity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

