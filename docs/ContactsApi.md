# ContactsApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addActivitySetAssignment**](ContactsApi.md#addActivitySetAssignment) | **POST** /Contacts/{id}/ActivitySetAssignment | Adds an Activity Set to a Contact
[**addAddress**](ContactsApi.md#addAddress) | **POST** /Contacts/{id}/Addresses | Adds an Address
[**addContact**](ContactsApi.md#addContact) | **POST** /Contacts | Adds a Contact
[**addContactInfo**](ContactsApi.md#addContactInfo) | **POST** /Contacts/{id}/ContactInfos | Adds a Contact Info
[**addContactLink**](ContactsApi.md#addContactLink) | **POST** /Contacts/{id}/ContactLinks | Adds a Contact Link
[**addDate**](ContactsApi.md#addDate) | **POST** /Contacts/{id}/Dates | Adds a Contact Date
[**addFileAttachment**](ContactsApi.md#addFileAttachment) | **POST** /Contacts/{id}/FileAttachments | Adds a File Attachment to a Contact
[**addFollow**](ContactsApi.md#addFollow) | **POST** /Contacts/{id}/Follow | Start following a Contact
[**addLink**](ContactsApi.md#addLink) | **POST** /Contacts/{id}/Links | Adds a Link
[**addNote**](ContactsApi.md#addNote) | **POST** /Contacts/{id}/Notes | Adds a Note to a Contact
[**addTag**](ContactsApi.md#addTag) | **POST** /Contacts/{id}/Tags | Adds a Tag
[**deleteAddress**](ContactsApi.md#deleteAddress) | **DELETE** /Contacts/{id}/Addresses/{addressId} | Deletes an Address
[**deleteContact**](ContactsApi.md#deleteContact) | **DELETE** /Contacts/{id} | Deletes a Contact
[**deleteContactInfo**](ContactsApi.md#deleteContactInfo) | **DELETE** /Contacts/{id}/ContactInfos/{contactInfoId} | Deletes a Contact Info
[**deleteContactLink**](ContactsApi.md#deleteContactLink) | **DELETE** /Contacts/{id}/ContactLinks/{linkId} | Deletes a Contact Link
[**deleteCustomField**](ContactsApi.md#deleteCustomField) | **DELETE** /Contacts/{id}/CustomFields/{customFieldId} | Deletes a Custom Field
[**deleteDate**](ContactsApi.md#deleteDate) | **DELETE** /Contacts/{id}/Dates/{dateId} | Deletes a Contact Date
[**deleteFollow**](ContactsApi.md#deleteFollow) | **DELETE** /Contacts/{id}/Follow | Stop following a Contact
[**deleteImage**](ContactsApi.md#deleteImage) | **DELETE** /Contacts/{id}/Image | Deletes a Contact&#39;s Image
[**deleteLink**](ContactsApi.md#deleteLink) | **DELETE** /Contacts/{id}/Links/{linkId} | Deletes a Link
[**deleteTag**](ContactsApi.md#deleteTag) | **DELETE** /Contacts/{id}/Tags/{tagName} | Deletes a Tag
[**getContact**](ContactsApi.md#getContact) | **GET** /Contacts/{id} | Gets a Contact
[**getContacts**](ContactsApi.md#getContacts) | **GET** /Contacts | Gets a list of Contacts.
[**getContactsBySearch**](ContactsApi.md#getContactsBySearch) | **GET** /Contacts/Search | Gets a filtered list of Contacts.
[**getEmails**](ContactsApi.md#getEmails) | **GET** /Contacts/{id}/Emails | Gets a list of Contact&#39;s Emails
[**getEvents**](ContactsApi.md#getEvents) | **GET** /Contacts/{id}/Events | Gets a Contact&#39;s Events
[**getFileAttachments**](ContactsApi.md#getFileAttachments) | **GET** /Contacts/{id}/FileAttachments | Gets a Contact&#39;s File Attachments
[**getFollow**](ContactsApi.md#getFollow) | **GET** /Contacts/{id}/Follow | Gets a Follow record for the Contact
[**getImage**](ContactsApi.md#getImage) | **GET** /Contacts/{id}/Image | Gets a Contact&#39;s Image
[**getNotes**](ContactsApi.md#getNotes) | **GET** /Contacts/{id}/Notes | Gets a Contact&#39;s Notes
[**getTasks**](ContactsApi.md#getTasks) | **GET** /Contacts/{id}/Tasks | Gets a list of Contact&#39;s Tasks
[**updateAddress**](ContactsApi.md#updateAddress) | **PUT** /Contacts/{id}/Addresses | Updates an Address
[**updateContact**](ContactsApi.md#updateContact) | **PUT** /Contacts | Updates a Contact
[**updateContactInfo**](ContactsApi.md#updateContactInfo) | **PUT** /Contacts/{id}/ContactInfos | Updates a Contact Info
[**updateContactLink**](ContactsApi.md#updateContactLink) | **PUT** /Contacts/{id}/ContactLinks | Updates a Contact Link
[**updateCustomField**](ContactsApi.md#updateCustomField) | **PUT** /Contacts/{id}/CustomFields | Updates a Custom Field
[**updateDate**](ContactsApi.md#updateDate) | **PUT** /Contacts/{id}/Dates | Updates a Contact Date
[**updateImage**](ContactsApi.md#updateImage) | **PUT** /Contacts/{id}/Image/{filename} | Updates a Contact&#39;s Image
[**updateLink**](ContactsApi.md#updateLink) | **PUT** /Contacts/{id}/Links | Updates a Link


<a name="addActivitySetAssignment"></a>
# **addActivitySetAssignment**
> addActivitySetAssignment(id, apiActivitySetAssignment)

Adds an Activity Set to a Contact

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID
ActivitySetAssignment apiActivitySetAssignment = new ActivitySetAssignment(); // ActivitySetAssignment | The Activity Set Assignment object which contains the configuration information for the Activity Set
try {
    apiInstance.addActivitySetAssignment(id, apiActivitySetAssignment);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#addActivitySetAssignment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID |
 **apiActivitySetAssignment** | [**ActivitySetAssignment**](ActivitySetAssignment.md)| The Activity Set Assignment object which contains the configuration information for the Activity Set |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addAddress"></a>
# **addAddress**
> Address addAddress(id, apiAddress)

Adds an Address

Limited to two addresses, one Mailing Address and one Other Address. For more information, please refer to Body Schema.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
Address apiAddress = new Address(); // Address | The Address to add (just include JSON object as request body)
try {
    Address result = apiInstance.addAddress(id, apiAddress);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#addAddress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **apiAddress** | [**Address**](Address.md)| The Address to add (just include JSON object as request body) |

### Return type

[**Address**](Address.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addContact"></a>
# **addContact**
> Contact addContact(apiContact)

Adds a Contact

If you have trouble with creating a contact, try creating contacts via the web interface, and then access those contacts via the API. This way you            can see examples of the fields and sub-elements attached to the object. A common source of problems during write/update request is caused when users omit            required fields, or insert invalid data in a field (e.g. reference a CATEGORY_ID that does not exist in the user&#39;s Insightly instance.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Contact apiContact = new Contact(); // Contact | The Contact to add (just include the JSON object as the request body)
try {
    Contact result = apiInstance.addContact(apiContact);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#addContact");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiContact** | [**Contact**](Contact.md)| The Contact to add (just include the JSON object as the request body) |

### Return type

[**Contact**](Contact.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addContactInfo"></a>
# **addContactInfo**
> ContactInfo addContactInfo(id, apiContactInfo)

Adds a Contact Info

Limited to six Phone Numbers and one Email Address. For more information, please refer to Body Schema.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
ContactInfo apiContactInfo = new ContactInfo(); // ContactInfo | The Contact Info to add (just include the JSON object in the request body)
try {
    ContactInfo result = apiInstance.addContactInfo(id, apiContactInfo);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#addContactInfo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **apiContactInfo** | [**ContactInfo**](ContactInfo.md)| The Contact Info to add (just include the JSON object in the request body) |

### Return type

[**ContactInfo**](ContactInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addContactLink"></a>
# **addContactLink**
> ContactLink addContactLink(id, apiLink)

Adds a Contact Link

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
ContactLink apiLink = new ContactLink(); // ContactLink | The Contact Link to add (just include the JSON object as request body)
try {
    ContactLink result = apiInstance.addContactLink(id, apiLink);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#addContactLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **apiLink** | [**ContactLink**](ContactLink.md)| The Contact Link to add (just include the JSON object as request body) |

### Return type

[**ContactLink**](ContactLink.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addDate"></a>
# **addDate**
> ContactDate addDate(id, apiContactDate)

Adds a Contact Date

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
ContactDate apiContactDate = new ContactDate(); // ContactDate | The Contact Date to add (just include JSON object as request body)
try {
    ContactDate result = apiInstance.addDate(id, apiContactDate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#addDate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **apiContactDate** | [**ContactDate**](ContactDate.md)| The Contact Date to add (just include JSON object as request body) |

### Return type

[**ContactDate**](ContactDate.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addFileAttachment"></a>
# **addFileAttachment**
> FileAttachment addFileAttachment(id, file, fileName, contentType, fileCategoryId)

Adds a File Attachment to a Contact

This endpoint expects multipart/form-data as the request payload. See Stack Overflow for examples of how to generate multipart requests, or see our &lt;a href&#x3D;\&quot;http://github.com/Insightly\&quot; target&#x3D;\&quot;_blank\&quot;&gt;client libraries&lt;/a&gt; for an example of how this is generated. Only one file can be added per request.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | Contact ID
String file = "/path/to/file.txt"; // String | The file part of the multipart/form-data request. Only one file can be added per request.
String fileName = "fileName_example"; // String | 
String contentType = "contentType_example"; // String | 
Integer fileCategoryId = 56; // Integer | 
try {
    FileAttachment result = apiInstance.addFileAttachment(id, file, fileName, contentType, fileCategoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#addFileAttachment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| Contact ID |
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

Start following a Contact

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
try {
    Follow result = apiInstance.addFollow(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#addFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |

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
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
Link apiLink = new Link(); // Link | The Link to add (just include JSON object as request body)
try {
    Link result = apiInstance.addLink(id, apiLink);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#addLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
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

Adds a Note to a Contact

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
Note apiNote = new Note(); // Note | The Note to add
try {
    Note result = apiInstance.addNote(id, apiNote);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#addNote");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **apiNote** | [**Note**](Note.md)| The Note to add |

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

Adds a Tag

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
Tag apiTag = new Tag(); // Tag | The Tag to add (just include the JSON object as the request body)
try {
    Tag result = apiInstance.addTag(id, apiTag);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#addTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **apiTag** | [**Tag**](Tag.md)| The Tag to add (just include the JSON object as the request body) |

### Return type

[**Tag**](Tag.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteAddress"></a>
# **deleteAddress**
> deleteAddress(id, addressId)

Deletes an Address

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
Long addressId = 789L; // Long | An Address' ID (ADDRESS_ID)
try {
    apiInstance.deleteAddress(id, addressId);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#deleteAddress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **addressId** | **Long**| An Address&#39; ID (ADDRESS_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteContact"></a>
# **deleteContact**
> deleteContact(id)

Deletes a Contact



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID
try {
    apiInstance.deleteContact(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#deleteContact");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteContactInfo"></a>
# **deleteContactInfo**
> deleteContactInfo(id, contactInfoId)

Deletes a Contact Info

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
Long contactInfoId = 789L; // Long | A Contact Info's ID (CONTAC_INFO_ID)
try {
    apiInstance.deleteContactInfo(id, contactInfoId);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#deleteContactInfo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **contactInfoId** | **Long**| A Contact Info&#39;s ID (CONTAC_INFO_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteContactLink"></a>
# **deleteContactLink**
> deleteContactLink(id, linkId)

Deletes a Contact Link

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
Long linkId = 789L; // Long | A Contact Link's ID (CONTACT_LINK_ID)
try {
    apiInstance.deleteContactLink(id, linkId);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#deleteContactLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **linkId** | **Long**| A Contact Link&#39;s ID (CONTACT_LINK_ID) |

### Return type

null (empty response body)

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
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
String customFieldId = "customFieldId_example"; // String | A Custom Field's ID (CUSTOM_FIELD_ID)
try {
    apiInstance.deleteCustomField(id, customFieldId);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#deleteCustomField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **customFieldId** | **String**| A Custom Field&#39;s ID (CUSTOM_FIELD_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteDate"></a>
# **deleteDate**
> deleteDate(id, dateId)

Deletes a Contact Date

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
Long dateId = 789L; // Long | A Contact Date's ID (DATE_ID)
try {
    apiInstance.deleteDate(id, dateId);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#deleteDate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **dateId** | **Long**| A Contact Date&#39;s ID (DATE_ID) |

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

Stop following a Contact

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
try {
    apiInstance.deleteFollow(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#deleteFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |

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

Deletes a Contact&#39;s Image



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
try {
    apiInstance.deleteImage(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#deleteImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |

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
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
Long linkId = 789L; // Long | A Link's ID (LINK_ID)
try {
    apiInstance.deleteLink(id, linkId);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#deleteLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **linkId** | **Long**| A Link&#39;s ID (LINK_ID) |

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

Deletes a Tag

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
String tagName = "tagName_example"; // String | A Tag's name
try {
    apiInstance.deleteTag(id, tagName);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#deleteTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **tagName** | **String**| A Tag&#39;s name |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="getContact"></a>
# **getContact**
> Contact getContact(id)

Gets a Contact



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID
try {
    Contact result = apiInstance.getContact(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#getContact");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID |

### Return type

[**Contact**](Contact.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getContacts"></a>
# **getContacts**
> List&lt;Contact&gt; getContacts(brief, skip, top, countTotal)

Gets a list of Contacts.

Simple object graphs (excluding ADDRESSES, CONTACTINFOS, etc.) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the contact.
Integer skip = 56; // Integer | Optional, number of contacts to skip.
Integer top = 56; // Integer | Optional, maximum number of contacts to return in the response.
Boolean countTotal = false; // Boolean | Optional,true if total number of records should be returned in the response headers.
try {
    List<Contact> result = apiInstance.getContacts(brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#getContacts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the contact. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of contacts to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of contacts to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional,true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Contact&gt;**](Contact.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getContactsBySearch"></a>
# **getContactsBySearch**
> List&lt;Contact&gt; getContactsBySearch(email, tag, phoneNumber, firstName, lastName, city, state, postcode, country, organisation, updatedAfterUtc, brief, skip, top, countTotal)

Gets a filtered list of Contacts.

Only one optional parameter (excluding brief, top, skip and count_total) can be specified. Simple object graphs (excluding ADDRESSES, CONTACTINFOS, etc.) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
String email = "email_example"; // String | Optional, email address.
String tag = "tag_example"; // String | Optional, a single tag. Performs an exact match.
String phoneNumber = "phoneNumber_example"; // String | Optional, phone number.
String firstName = "firstName_example"; // String | Optional, first name of the contact.
String lastName = "lastName_example"; // String | Optional, last name of the contact.
String city = "city_example"; // String | Optional, name of the city from contact address.
String state = "state_example"; // String | Optional, state from the contact address.
String postcode = "postcode_example"; // String | Optional, postal code from the contact address.
String country = "country_example"; // String | Optional, name of the country from contact address.
String organisation = "organisation_example"; // String | Optional, name of the default organisation.
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when contact was last updated.
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the contact.
Integer skip = 56; // Integer | Optional, number of contacts to skip.
Integer top = 56; // Integer | Optional, maximum number of contacts to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Contact> result = apiInstance.getContactsBySearch(email, tag, phoneNumber, firstName, lastName, city, state, postcode, country, organisation, updatedAfterUtc, brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#getContactsBySearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**| Optional, email address. | [optional]
 **tag** | **String**| Optional, a single tag. Performs an exact match. | [optional]
 **phoneNumber** | **String**| Optional, phone number. | [optional]
 **firstName** | **String**| Optional, first name of the contact. | [optional]
 **lastName** | **String**| Optional, last name of the contact. | [optional]
 **city** | **String**| Optional, name of the city from contact address. | [optional]
 **state** | **String**| Optional, state from the contact address. | [optional]
 **postcode** | **String**| Optional, postal code from the contact address. | [optional]
 **country** | **String**| Optional, name of the country from contact address. | [optional]
 **organisation** | **String**| Optional, name of the default organisation. | [optional]
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when contact was last updated. | [optional]
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the contact. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of contacts to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of contacts to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Contact&gt;**](Contact.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getEmails"></a>
# **getEmails**
> List&lt;Email&gt; getEmails(id, updatedAfterUtc, top, skip, brief, countTotal)

Gets a list of Contact&#39;s Emails

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when email was last updated.
Integer top = 56; // Integer | Optional, maximum number of emails to return.
Integer skip = 56; // Integer | Optional, number of emails to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<Email> result = apiInstance.getEmails(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#getEmails");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID |
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

Gets a Contact&#39;s Events

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when event was last updated.
Integer top = 56; // Integer | Optional, maximum number of events to return.
Integer skip = 56; // Integer | Optional, number of events to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<CalendarEvent> result = apiInstance.getEvents(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#getEvents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
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

Gets a Contact&#39;s File Attachments

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when file attachment was last updated.
Integer skip = 56; // Integer | Optional, number of file attachments to skip.
Integer top = 56; // Integer | Optional, maximum number of file attachments to return in the response.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<FileAttachment> result = apiInstance.getFileAttachments(id, updatedAfterUtc, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#getFileAttachments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
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

Gets a Follow record for the Contact

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
try {
    Follow result = apiInstance.getFollow(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#getFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |

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

Gets a Contact&#39;s Image



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID
try {
    apiInstance.getImage(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#getImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/octet-stream

<a name="getNotes"></a>
# **getNotes**
> List&lt;Note&gt; getNotes(id, updatedAfterUtc, top, skip, brief, countTotal)

Gets a Contact&#39;s Notes

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when note was last updated.
Integer top = 56; // Integer | Optional, maximum number of notes to return.
Integer skip = 56; // Integer | Optional, number of notes to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<Note> result = apiInstance.getNotes(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#getNotes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
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

Gets a list of Contact&#39;s Tasks

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when task was last updated.
Integer top = 56; // Integer | Optional, maximum number of tasks to return.
Integer skip = 56; // Integer | Optional, number of tasks to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<Task> result = apiInstance.getTasks(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#getTasks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID |
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

<a name="updateAddress"></a>
# **updateAddress**
> Address updateAddress(id, apiAddress)

Updates an Address

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
Address apiAddress = new Address(); // Address | The Address to update (just include the JSON object as the request body)
try {
    Address result = apiInstance.updateAddress(id, apiAddress);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#updateAddress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **apiAddress** | [**Address**](Address.md)| The Address to update (just include the JSON object as the request body) |

### Return type

[**Address**](Address.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="updateContact"></a>
# **updateContact**
> Contact updateContact(apiContact, brief)

Updates a Contact

If you have trouble updating a contact, try accessing the contact via the GET request to inspect its fields and sub-elements. A common source of            problems with write/update requests occurs when users either omit required fields, or insert invalid data into a field (for example, by referring a            CATEGORY_ID or LINK_ID which does not exist.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Contact apiContact = new Contact(); // Contact | A Contact, just include the JSON object as the request body
Boolean brief = false; // Boolean | Optional, true if you wish to do a partial update containing only top level properties of the Contact. When true, all sub-collections are ignored.
try {
    Contact result = apiInstance.updateContact(apiContact, brief);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#updateContact");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiContact** | [**Contact**](Contact.md)| A Contact, just include the JSON object as the request body |
 **brief** | **Boolean**| Optional, true if you wish to do a partial update containing only top level properties of the Contact. When true, all sub-collections are ignored. | [optional] [default to false]

### Return type

[**Contact**](Contact.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="updateContactInfo"></a>
# **updateContactInfo**
> ContactInfo updateContactInfo(id, apiContactInfo)

Updates a Contact Info

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
ContactInfo apiContactInfo = new ContactInfo(); // ContactInfo | The Contact Info to add (just include the JSON object in the request body)
try {
    ContactInfo result = apiInstance.updateContactInfo(id, apiContactInfo);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#updateContactInfo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **apiContactInfo** | [**ContactInfo**](ContactInfo.md)| The Contact Info to add (just include the JSON object in the request body) |

### Return type

[**ContactInfo**](ContactInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="updateContactLink"></a>
# **updateContactLink**
> ContactLink updateContactLink(id, apiLink)

Updates a Contact Link

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
ContactLink apiLink = new ContactLink(); // ContactLink | The Contact Link to add (just include the JSON object as request body)
try {
    ContactLink result = apiInstance.updateContactLink(id, apiLink);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#updateContactLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **apiLink** | [**ContactLink**](ContactLink.md)| The Contact Link to add (just include the JSON object as request body) |

### Return type

[**ContactLink**](ContactLink.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="updateCustomField"></a>
# **updateCustomField**
> CustomField updateCustomField(id, apiCustomField)

Updates a Custom Field

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
CustomField apiCustomField = new CustomField(); // CustomField | The Custom Field to edit (just include JSON object as request body)
try {
    CustomField result = apiInstance.updateCustomField(id, apiCustomField);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#updateCustomField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **apiCustomField** | [**CustomField**](CustomField.md)| The Custom Field to edit (just include JSON object as request body) |

### Return type

[**CustomField**](CustomField.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="updateDate"></a>
# **updateDate**
> ContactDate updateDate(id, apiContactDate)

Updates a Contact Date

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
ContactDate apiContactDate = new ContactDate(); // ContactDate | The Contact Date to add (just include the JSON object as request body)
try {
    ContactDate result = apiInstance.updateDate(id, apiContactDate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#updateDate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **apiContactDate** | [**ContactDate**](ContactDate.md)| The Contact Date to add (just include the JSON object as request body) |

### Return type

[**ContactDate**](ContactDate.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="updateImage"></a>
# **updateImage**
> Contact updateImage(id, filename, file)

Updates a Contact&#39;s Image

This action will replace any existing Image attached to the Contact. The contents of the image data should be sent as binary data in the request payload. See our &lt;a href&#x3D;\&quot;http://github.com/Insightly\&quot; target&#x3D;\&quot;_blank\&quot;&gt;client libraries&lt;/a&gt; for an example of how this is done.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
String filename = "filename_example"; // String | Name of Image File to be attached to Contact
byte[] file = BINARY_DATA_HERE; // byte[] | File to upload
try {
    Contact result = apiInstance.updateImage(id, filename, file);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#updateImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **filename** | **String**| Name of Image File to be attached to Contact |
 **file** | **byte[]**| File to upload |

### Return type

[**Contact**](Contact.md)

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
//import com.insightly.api.ContactsApi;


ContactsApi apiInstance = new ContactsApi();
Long id = 789L; // Long | A Contact's ID (CONTACT_ID)
Link apiLink = new Link(); // Link | The Link to add (just include JSON object as request body)
try {
    Link result = apiInstance.updateLink(id, apiLink);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContactsApi#updateLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Contact&#39;s ID (CONTACT_ID) |
 **apiLink** | [**Link**](Link.md)| The Link to add (just include JSON object as request body) |

### Return type

[**Link**](Link.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

