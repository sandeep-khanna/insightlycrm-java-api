# LeadsApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addActivitySetAssignment**](LeadsApi.md#addActivitySetAssignment) | **POST** /Leads/{id}/ActivitySetAssignment | Adds an Activity Set to a Lead
[**addFileAttachment**](LeadsApi.md#addFileAttachment) | **POST** /Leads/{id}/FileAttachments | Adds a File Attachment to a Lead
[**addFollow**](LeadsApi.md#addFollow) | **POST** /Leads/{id}/Follow | Start following a Lead
[**addLead**](LeadsApi.md#addLead) | **POST** /Leads | Adds a Lead
[**addNote**](LeadsApi.md#addNote) | **POST** /Leads/{id}/Notes | Adds a Note to a Lead.
[**addTag**](LeadsApi.md#addTag) | **POST** /Leads/{id}/Tags | Adds a Tag for a Lead
[**deleteCustomField**](LeadsApi.md#deleteCustomField) | **DELETE** /Leads/{id}/CustomFields/{customFieldId} | Deletes a Custom Field
[**deleteFollow**](LeadsApi.md#deleteFollow) | **DELETE** /Leads/{id}/Follow | Stop following a Lead
[**deleteImage**](LeadsApi.md#deleteImage) | **DELETE** /Leads/{id}/Image | Deletes a Lead&#39;s Image
[**deleteLead**](LeadsApi.md#deleteLead) | **DELETE** /Leads/{id} | Deletes a Lead
[**deleteTag**](LeadsApi.md#deleteTag) | **DELETE** /Leads/{id}/Tags/{tagName} | Deletes a Tag from a Lead
[**getEmails**](LeadsApi.md#getEmails) | **GET** /Leads/{id}/Emails | Gets a list of Lead&#39;s Emails
[**getEvents**](LeadsApi.md#getEvents) | **GET** /Leads/{id}/Events | Gets a Lead&#39;s Events
[**getFileAttachments**](LeadsApi.md#getFileAttachments) | **GET** /Leads/{id}/FileAttachments | Gets a Lead&#39;s File Attachments
[**getFollow**](LeadsApi.md#getFollow) | **GET** /Leads/{id}/Follow | Gets a Follow record for the Lead
[**getImage**](LeadsApi.md#getImage) | **GET** /Leads/{id}/Image | Gets a Lead&#39;s Image
[**getLead**](LeadsApi.md#getLead) | **GET** /Leads/{id} | Gets a Lead
[**getLeads**](LeadsApi.md#getLeads) | **GET** /Leads | Gets a list of Leads.
[**getLeadsBySearch**](LeadsApi.md#getLeadsBySearch) | **GET** /Leads/Search | Gets a filtered list of Leads.
[**getLinkEmailAddress**](LeadsApi.md#getLinkEmailAddress) | **GET** /Leads/{id}/LinkEmailAddress | Gets the email address to use for linking with the Lead
[**getNotes**](LeadsApi.md#getNotes) | **GET** /Leads/{id}/Notes | Gets a Lead&#39;s Notes
[**getTasks**](LeadsApi.md#getTasks) | **GET** /Leads/{id}/Tasks | Gets a list of Lead&#39;s Tasks
[**updateCustomField**](LeadsApi.md#updateCustomField) | **PUT** /Leads/{id}/CustomFields | Updates a Custom Field
[**updateImage**](LeadsApi.md#updateImage) | **PUT** /Leads/{id}/Image/{filename} | Updates a Lead&#39;s Image
[**updateLead**](LeadsApi.md#updateLead) | **PUT** /Leads | Updates a Lead


<a name="addActivitySetAssignment"></a>
# **addActivitySetAssignment**
> addActivitySetAssignment(id, apiActivitySetAssignment)

Adds an Activity Set to a Lead

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID
ActivitySetAssignment apiActivitySetAssignment = new ActivitySetAssignment(); // ActivitySetAssignment | The Activity Set Assignment object which contains the configuration information for the Activity Set
try {
    apiInstance.addActivitySetAssignment(id, apiActivitySetAssignment);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#addActivitySetAssignment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID |
 **apiActivitySetAssignment** | [**ActivitySetAssignment**](ActivitySetAssignment.md)| The Activity Set Assignment object which contains the configuration information for the Activity Set |

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

Adds a File Attachment to a Lead

This endpoint expects multipart/form-data as the request payload. See Stack Overflow for examples of how to generate multipart requests, or see our &lt;a href&#x3D;\&quot;http://github.com/Insightly\&quot; target&#x3D;\&quot;_blank\&quot;&gt;client libraries&lt;/a&gt; for an example of how this is generated. Only one file can be added per request.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID (LEAD_ID)
String file = "/path/to/file.txt"; // String | The file part of the multipart/form-data request. Only one file can be added per request.
String fileName = "fileName_example"; // String | 
String contentType = "contentType_example"; // String | 
Integer fileCategoryId = 56; // Integer | 
try {
    FileAttachment result = apiInstance.addFileAttachment(id, file, fileName, contentType, fileCategoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#addFileAttachment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID (LEAD_ID) |
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

Start following a Lead

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID (LEAD_ID)
try {
    Follow result = apiInstance.addFollow(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#addFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID (LEAD_ID) |

### Return type

[**Follow**](Follow.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addLead"></a>
# **addLead**
> Lead addLead(apiLead)

Adds a Lead

A common source of problems when creating leads occurs when users omit required fields, or insert             invalid data into a field. A good troubleshooting technique             is to create a few leads via the web interface, with representative data, links, etc, and then access             these leads via the API, and inspect the returned object graph.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Lead apiLead = new Lead(); // Lead | The Lead to add (just include JSON object as request body)
try {
    Lead result = apiInstance.addLead(apiLead);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#addLead");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiLead** | [**Lead**](Lead.md)| The Lead to add (just include JSON object as request body) |

### Return type

[**Lead**](Lead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addNote"></a>
# **addNote**
> Note addNote(id, apiNote)

Adds a Note to a Lead.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID (LEAD_ID)
Note apiNote = new Note(); // Note | The Note to add (just include JSON object as request body)
try {
    Note result = apiInstance.addNote(id, apiNote);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#addNote");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID (LEAD_ID) |
 **apiNote** | [**Note**](Note.md)| The Note to add (just include JSON object as request body) |

### Return type

[**Note**](Note.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addTag"></a>
# **addTag**
> Tag addTag(id, apiTag)

Adds a Tag for a Lead

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID (LEAD_ID)
Tag apiTag = new Tag(); // Tag | The Tag to add (just include the JSON object in request body.
try {
    Tag result = apiInstance.addTag(id, apiTag);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#addTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID (LEAD_ID) |
 **apiTag** | [**Tag**](Tag.md)| The Tag to add (just include the JSON object in request body. |

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
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID (LEAD_ID)
String customFieldId = "customFieldId_example"; // String | A Custom Field's ID (CUSTOM_FIELD_ID)
try {
    apiInstance.deleteCustomField(id, customFieldId);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#deleteCustomField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID (LEAD_ID) |
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

Stop following a Lead

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID (LEAD_ID)
try {
    apiInstance.deleteFollow(id);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#deleteFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID (LEAD_ID) |

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

Deletes a Lead&#39;s Image



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID (LEAD_ID)
try {
    apiInstance.deleteImage(id);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#deleteImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID (LEAD_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteLead"></a>
# **deleteLead**
> deleteLead(id)

Deletes a Lead



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID
try {
    apiInstance.deleteLead(id);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#deleteLead");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID |

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

Deletes a Tag from a Lead

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID (LEAD_ID)
String tagName = "tagName_example"; // String | A Tag's name
try {
    apiInstance.deleteTag(id, tagName);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#deleteTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID (LEAD_ID) |
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

Gets a list of Lead&#39;s Emails

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when email was last updated.
Integer top = 56; // Integer | Optional, maximum number of emails to return.
Integer skip = 56; // Integer | Optional, number of emails to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<Email> result = apiInstance.getEmails(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#getEmails");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID |
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

Gets a Lead&#39;s Events

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID (LEAD_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when event was last updated.
Integer top = 56; // Integer | Optional, maximum number of events to return.
Integer skip = 56; // Integer | Optional, number of events to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<CalendarEvent> result = apiInstance.getEvents(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#getEvents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID (LEAD_ID) |
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

Gets a Lead&#39;s File Attachments

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID (LEAD_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when file attachment was last updated.
Integer skip = 56; // Integer | Optional, number of file attachments to skip.
Integer top = 56; // Integer | Optional, maximum number of file attachments to return in the response.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<FileAttachment> result = apiInstance.getFileAttachments(id, updatedAfterUtc, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#getFileAttachments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID (LEAD_ID) |
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

Gets a Follow record for the Lead

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID (LEAD_ID)
try {
    Follow result = apiInstance.getFollow(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#getFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID (LEAD_ID) |

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

Gets a Lead&#39;s Image



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID (LEAD_ID)
try {
    apiInstance.getImage(id);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#getImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID (LEAD_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

<a name="getLead"></a>
# **getLead**
> Lead getLead(id)

Gets a Lead



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID
try {
    Lead result = apiInstance.getLead(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#getLead");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID |

### Return type

[**Lead**](Lead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getLeads"></a>
# **getLeads**
> List&lt;Lead&gt; getLeads(includeConverted, brief, skip, top, countTotal)

Gets a list of Leads.

Simple object graphs (excluding Custom Fields, Tags, etc.) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Boolean includeConverted = false; // Boolean | Optional, by default converted leads are not included, pass in \"true\" to include them in the response
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the lead.
Integer skip = 56; // Integer | Optional, number of lead to skip.
Integer top = 56; // Integer | Optional, maximum number of lead to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Lead> result = apiInstance.getLeads(includeConverted, brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#getLeads");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **includeConverted** | **Boolean**| Optional, by default converted leads are not included, pass in \&quot;true\&quot; to include them in the response | [optional] [default to false]
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the lead. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of lead to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of lead to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Lead&gt;**](Lead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getLeadsBySearch"></a>
# **getLeadsBySearch**
> List&lt;Lead&gt; getLeadsBySearch(email, tag, phoneNumber, firstName, lastName, city, state, postcode, country, organisation, updatedAfterUtc, includeConverted, brief, skip, top, countTotal)

Gets a filtered list of Leads.

Only one optional parameter (excluding include_converted, top, skip and count_total) can be specified. Simple object graphs (excluding Custom Fields, Tags, etc.) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
String email = "email_example"; // String | Optional, email address.
String tag = "tag_example"; // String | Optional, a single tag.
String phoneNumber = "phoneNumber_example"; // String | Optional, phone number.
String firstName = "firstName_example"; // String | Optional, first name of the contact.
String lastName = "lastName_example"; // String | Optional, last name of the contact.
String city = "city_example"; // String | Optional, name of the city from lead address.
String state = "state_example"; // String | Optional, state from the lead address.
String postcode = "postcode_example"; // String | Optional, postal code from the lead address.
String country = "country_example"; // String | Optional, name of the country from lead address.
String organisation = "organisation_example"; // String | Optional, name of the default organisation.
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when lead was last updated.
Boolean includeConverted = false; // Boolean | Optional, by default converted leads are not included, pass in \"true\" to include them in the response
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the lead.
Integer skip = 56; // Integer | Optional, number of lead to skip.
Integer top = 56; // Integer | Optional, maximum number of lead to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Lead> result = apiInstance.getLeadsBySearch(email, tag, phoneNumber, firstName, lastName, city, state, postcode, country, organisation, updatedAfterUtc, includeConverted, brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#getLeadsBySearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**| Optional, email address. | [optional]
 **tag** | **String**| Optional, a single tag. | [optional]
 **phoneNumber** | **String**| Optional, phone number. | [optional]
 **firstName** | **String**| Optional, first name of the contact. | [optional]
 **lastName** | **String**| Optional, last name of the contact. | [optional]
 **city** | **String**| Optional, name of the city from lead address. | [optional]
 **state** | **String**| Optional, state from the lead address. | [optional]
 **postcode** | **String**| Optional, postal code from the lead address. | [optional]
 **country** | **String**| Optional, name of the country from lead address. | [optional]
 **organisation** | **String**| Optional, name of the default organisation. | [optional]
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when lead was last updated. | [optional]
 **includeConverted** | **Boolean**| Optional, by default converted leads are not included, pass in \&quot;true\&quot; to include them in the response | [optional] [default to false]
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the lead. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of lead to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of lead to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Lead&gt;**](Lead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getLinkEmailAddress"></a>
# **getLinkEmailAddress**
> LinkEmailAddress getLinkEmailAddress(id)

Gets the email address to use for linking with the Lead

An email address to use as a maildrop for the Lead.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID
try {
    LinkEmailAddress result = apiInstance.getLinkEmailAddress(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#getLinkEmailAddress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID |

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

Gets a Lead&#39;s Notes

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID (LEAD_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when note was last updated.
Integer top = 56; // Integer | Optional, maximum number of notes to return.
Integer skip = 56; // Integer | Optional, number of notes to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<Note> result = apiInstance.getNotes(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#getNotes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID (LEAD_ID) |
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

<a name="getTasks"></a>
# **getTasks**
> List&lt;Task&gt; getTasks(id, updatedAfterUtc, top, skip, brief, countTotal)

Gets a list of Lead&#39;s Tasks

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when task was last updated.
Integer top = 56; // Integer | Optional, maximum number of tasks to return.
Integer skip = 56; // Integer | Optional, number of tasks to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<Task> result = apiInstance.getTasks(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#getTasks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID |
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
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID (LEAD_ID)
CustomField apiCustomField = new CustomField(); // CustomField | The Custom Field to edit (just include JSON object as request body)
try {
    CustomField result = apiInstance.updateCustomField(id, apiCustomField);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#updateCustomField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID (LEAD_ID) |
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
> Lead updateImage(id, filename, file)

Updates a Lead&#39;s Image

This action will replace any existing Image attached to the Lead. The contents of the image file should be sent as binary data in the request payload. See our &lt;a href&#x3D;\&quot;http://github.com/Insightly\&quot; target&#x3D;\&quot;_blank\&quot;&gt;client libraries&lt;/a&gt; for an example of how this is done.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Long id = 789L; // Long | A Lead's ID (LEAD_ID)
String filename = "filename_example"; // String | Name of Image File to be attached to Lead
byte[] file = BINARY_DATA_HERE; // byte[] | File to upload
try {
    Lead result = apiInstance.updateImage(id, filename, file);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#updateImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Lead&#39;s ID (LEAD_ID) |
 **filename** | **String**| Name of Image File to be attached to Lead |
 **file** | **byte[]**| File to upload |

### Return type

[**Lead**](Lead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: application/json, text/json

<a name="updateLead"></a>
# **updateLead**
> Lead updateLead(apiLead, brief)

Updates a Lead

A common source of problems when updating leads occurs when users omit required fields, or insert             invalid data into a field. A good troubleshooting technique             is to create a few leads via the web interface, with representative data, links, etc, and then access             these leads via the API, and inspect the returned object graph.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.LeadsApi;


LeadsApi apiInstance = new LeadsApi();
Lead apiLead = new Lead(); // Lead | A Lead (just include JSON object as request body)
Boolean brief = false; // Boolean | Optional, true if you wish to do a partial update containing only top level properties of the Lead. When true, all sub-collections are ignored.
try {
    Lead result = apiInstance.updateLead(apiLead, brief);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LeadsApi#updateLead");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiLead** | [**Lead**](Lead.md)| A Lead (just include JSON object as request body) |
 **brief** | **Boolean**| Optional, true if you wish to do a partial update containing only top level properties of the Lead. When true, all sub-collections are ignored. | [optional] [default to false]

### Return type

[**Lead**](Lead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

