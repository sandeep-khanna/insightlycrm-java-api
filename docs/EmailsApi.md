# EmailsApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addComment**](EmailsApi.md#addComment) | **POST** /Emails/{id}/Comments | Adds a Comment to an email.
[**addEmailLink**](EmailsApi.md#addEmailLink) | **POST** /Emails/{id}/EmailLinks | Adds an Email Link
[**addFollow**](EmailsApi.md#addFollow) | **POST** /Emails/{id}/Follow | Start following an Email
[**addTag**](EmailsApi.md#addTag) | **POST** /Emails/{id}/Tags | Adds a Tag for an Email
[**deleteEmailLink**](EmailsApi.md#deleteEmailLink) | **DELETE** /Emails/{id}/EmailLinks/{linkId} | Deletes an Email Link
[**deleteFollow**](EmailsApi.md#deleteFollow) | **DELETE** /Emails/{id}/Follow | Stop following an Email
[**deleteTag**](EmailsApi.md#deleteTag) | **DELETE** /Emails/{id}/Tags/{tagName} | Deletes a Tag from an Email
[**getComments**](EmailsApi.md#getComments) | **GET** /Emails/{id}/Comments | Gets an Email&#39;s Comments
[**getEmail**](EmailsApi.md#getEmail) | **GET** /Emails/{id} | Gets an Email
[**getEmails**](EmailsApi.md#getEmails) | **GET** /Emails | Gets a list of Emails.
[**getEmailsBySearch**](EmailsApi.md#getEmailsBySearch) | **GET** /Emails/Search | Gets a filtered list of Emails.
[**getFileAttachments**](EmailsApi.md#getFileAttachments) | **GET** /Emails/{id}/FileAttachments | Gets an Email&#39;s File Attachments
[**getFollow**](EmailsApi.md#getFollow) | **GET** /Emails/{id}/Follow | Gets a Follow record for the Email


<a name="addComment"></a>
# **addComment**
> Comment addComment(id, apiComment)

Adds a Comment to an email.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EmailsApi;


EmailsApi apiInstance = new EmailsApi();
Long id = 789L; // Long | An Email's ID (EMAIL_ID)
Comment apiComment = new Comment(); // Comment | The Comment to add (just include JSON object as request body)
try {
    Comment result = apiInstance.addComment(id, apiComment);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EmailsApi#addComment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Email&#39;s ID (EMAIL_ID) |
 **apiComment** | [**Comment**](Comment.md)| The Comment to add (just include JSON object as request body) |

### Return type

[**Comment**](Comment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addEmailLink"></a>
# **addEmailLink**
> EmailLink addEmailLink(id, apiLink)

Adds an Email Link

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EmailsApi;


EmailsApi apiInstance = new EmailsApi();
Long id = 789L; // Long | An Email's ID (EMAIL_ID)
EmailLink apiLink = new EmailLink(); // EmailLink | The Email Link to add (just include JSON object as request body)
try {
    EmailLink result = apiInstance.addEmailLink(id, apiLink);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EmailsApi#addEmailLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Email&#39;s ID (EMAIL_ID) |
 **apiLink** | [**EmailLink**](EmailLink.md)| The Email Link to add (just include JSON object as request body) |

### Return type

[**EmailLink**](EmailLink.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addFollow"></a>
# **addFollow**
> Follow addFollow(id)

Start following an Email

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EmailsApi;


EmailsApi apiInstance = new EmailsApi();
Long id = 789L; // Long | An Email's ID (EMAIL_ID)
try {
    Follow result = apiInstance.addFollow(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EmailsApi#addFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Email&#39;s ID (EMAIL_ID) |

### Return type

[**Follow**](Follow.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addTag"></a>
# **addTag**
> Tag addTag(id, apiTag)

Adds a Tag for an Email

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EmailsApi;


EmailsApi apiInstance = new EmailsApi();
Long id = 789L; // Long | An Email's ID (EMAIL_ID)
Tag apiTag = new Tag(); // Tag | The Tag to add
try {
    Tag result = apiInstance.addTag(id, apiTag);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EmailsApi#addTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Email&#39;s ID (EMAIL_ID) |
 **apiTag** | [**Tag**](Tag.md)| The Tag to add |

### Return type

[**Tag**](Tag.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteEmailLink"></a>
# **deleteEmailLink**
> deleteEmailLink(id, linkId)

Deletes an Email Link

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EmailsApi;


EmailsApi apiInstance = new EmailsApi();
Long id = 789L; // Long | An Email's ID (EMAIL_ID)
Long linkId = 789L; // Long | An Email Link's ID (EMAIL_LINK_ID)
try {
    apiInstance.deleteEmailLink(id, linkId);
} catch (ApiException e) {
    System.err.println("Exception when calling EmailsApi#deleteEmailLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Email&#39;s ID (EMAIL_ID) |
 **linkId** | **Long**| An Email Link&#39;s ID (EMAIL_LINK_ID) |

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

Stop following an Email

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EmailsApi;


EmailsApi apiInstance = new EmailsApi();
Long id = 789L; // Long | An Email's ID (EMAIL_ID)
try {
    apiInstance.deleteFollow(id);
} catch (ApiException e) {
    System.err.println("Exception when calling EmailsApi#deleteFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Email&#39;s ID (EMAIL_ID) |

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

Deletes a Tag from an Email

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EmailsApi;


EmailsApi apiInstance = new EmailsApi();
Long id = 789L; // Long | An Email's ID (EMAIL_ID)
String tagName = "tagName_example"; // String | A Tag's name
try {
    apiInstance.deleteTag(id, tagName);
} catch (ApiException e) {
    System.err.println("Exception when calling EmailsApi#deleteTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Email&#39;s ID (EMAIL_ID) |
 **tagName** | **String**| A Tag&#39;s name |

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

Gets an Email&#39;s Comments

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EmailsApi;


EmailsApi apiInstance = new EmailsApi();
Long id = 789L; // Long | An Emails's ID (EMAIL_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when comment was last updated.
Integer skip = 56; // Integer | Optional, number of comments to skip.
Integer top = 56; // Integer | Optional, maximum number of comments to return in the response.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<Comment> result = apiInstance.getComments(id, updatedAfterUtc, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EmailsApi#getComments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Emails&#39;s ID (EMAIL_ID) |
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

<a name="getEmail"></a>
# **getEmail**
> Email getEmail(id)

Gets an Email



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EmailsApi;


EmailsApi apiInstance = new EmailsApi();
Long id = 789L; // Long | An Email's ID
try {
    Email result = apiInstance.getEmail(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EmailsApi#getEmail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Email&#39;s ID |

### Return type

[**Email**](Email.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getEmails"></a>
# **getEmails**
> List&lt;Email&gt; getEmails(brief, skip, top, countTotal)

Gets a list of Emails.

Simple object graphs (excluding EMAILLINKS, TAGS, etc.) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EmailsApi;


EmailsApi apiInstance = new EmailsApi();
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the email.
Integer skip = 56; // Integer | Optional, number of emails to skip.
Integer top = 56; // Integer | Optional, maximum number of emails to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Email> result = apiInstance.getEmails(brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EmailsApi#getEmails");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the email. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of emails to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of emails to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Email&gt;**](Email.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getEmailsBySearch"></a>
# **getEmailsBySearch**
> List&lt;Email&gt; getEmailsBySearch(emailFrom, emailTo, tag, updatedAfterUtc, brief, skip, top, countTotal)

Gets a filtered list of Emails.

Only one optional parameter (excluding brief, top, skip and count_total) can be specified.             Simple object graphs (excluding EMAILLINKS, TAGS, etc.) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EmailsApi;


EmailsApi apiInstance = new EmailsApi();
String emailFrom = "emailFrom_example"; // String | Optional, from email address.
String emailTo = "emailTo_example"; // String | Optional, to email address.
String tag = "tag_example"; // String | Optional, a single tag.
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when email was last updated.
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the email.
Integer skip = 56; // Integer | Optional, number of emails to skip.
Integer top = 56; // Integer | Optional, maximum number of emails to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Email> result = apiInstance.getEmailsBySearch(emailFrom, emailTo, tag, updatedAfterUtc, brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EmailsApi#getEmailsBySearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **emailFrom** | **String**| Optional, from email address. | [optional]
 **emailTo** | **String**| Optional, to email address. | [optional]
 **tag** | **String**| Optional, a single tag. | [optional]
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when email was last updated. | [optional]
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the email. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of emails to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of emails to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Email&gt;**](Email.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getFileAttachments"></a>
# **getFileAttachments**
> List&lt;FileAttachment&gt; getFileAttachments(id, updatedAfterUtc, skip, top, countTotal)

Gets an Email&#39;s File Attachments

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EmailsApi;


EmailsApi apiInstance = new EmailsApi();
Long id = 789L; // Long | An Email's ID (EMAIL_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when file attachment was last updated.
Integer skip = 56; // Integer | Optional, number of file attachments to skip.
Integer top = 56; // Integer | Optional, maximum number of file attachments to return in the response.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<FileAttachment> result = apiInstance.getFileAttachments(id, updatedAfterUtc, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EmailsApi#getFileAttachments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Email&#39;s ID (EMAIL_ID) |
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

Gets a Follow record for the Email

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EmailsApi;


EmailsApi apiInstance = new EmailsApi();
Long id = 789L; // Long | An Email's ID (EMAIL_ID)
try {
    Follow result = apiInstance.getFollow(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EmailsApi#getFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Email&#39;s ID (EMAIL_ID) |

### Return type

[**Follow**](Follow.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

