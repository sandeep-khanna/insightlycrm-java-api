# OrganisationsApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addActivitySetAssignment**](OrganisationsApi.md#addActivitySetAssignment) | **POST** /Organisations/{id}/ActivitySetAssignment | Adds an Activity Set to an Organisation
[**addAddress**](OrganisationsApi.md#addAddress) | **POST** /Organisations/{id}/Addresses | Adds an Address
[**addContactInfo**](OrganisationsApi.md#addContactInfo) | **POST** /Organisations/{id}/ContactInfos | Adds a Contact Info
[**addDate**](OrganisationsApi.md#addDate) | **POST** /Organisations/{id}/Dates | Adds an Organisation Date
[**addFileAttachment**](OrganisationsApi.md#addFileAttachment) | **POST** /Organisations/{id}/FileAttachments | Adds a File Attachment to an Organisation
[**addFollow**](OrganisationsApi.md#addFollow) | **POST** /Organisations/{id}/Follow | Start following an Organisation
[**addLink**](OrganisationsApi.md#addLink) | **POST** /Organisations/{id}/Links | Adds a Link
[**addNote**](OrganisationsApi.md#addNote) | **POST** /Organisations/{id}/Notes | Adds a Note to an Organisation
[**addOrganisation**](OrganisationsApi.md#addOrganisation) | **POST** /Organisations | Adds an Organisation
[**addOrganisationLink**](OrganisationsApi.md#addOrganisationLink) | **POST** /Organisations/{id}/OrganisationLinks | Adds an Organisation Link
[**addTag**](OrganisationsApi.md#addTag) | **POST** /Organisations/{id}/Tags | Adds a Tag
[**deleteAddress**](OrganisationsApi.md#deleteAddress) | **DELETE** /Organisations/{id}/Addresses/{addressId} | Deletes an Address
[**deleteContactInfo**](OrganisationsApi.md#deleteContactInfo) | **DELETE** /Organisations/{id}/ContactInfos/{contactInfoId} | Deletes a Contact Info
[**deleteCustomField**](OrganisationsApi.md#deleteCustomField) | **DELETE** /Organisations/{id}/CustomFields/{customFieldId} | Deletes a Custom Field
[**deleteDate**](OrganisationsApi.md#deleteDate) | **DELETE** /Organisations/{id}/Dates/{dateId} | Deletes an Organisation Date
[**deleteFollow**](OrganisationsApi.md#deleteFollow) | **DELETE** /Organisations/{id}/Follow | Stop following an Organisation
[**deleteImage**](OrganisationsApi.md#deleteImage) | **DELETE** /Organisations/{id}/Image | Deletes an Organisation&#39;s Image
[**deleteLink**](OrganisationsApi.md#deleteLink) | **DELETE** /Organisations/{id}/Links/{linkId} | Deletes a Link
[**deleteOrganisation**](OrganisationsApi.md#deleteOrganisation) | **DELETE** /Organisations/{id} | Deletes an Organisation
[**deleteOrganisationLink**](OrganisationsApi.md#deleteOrganisationLink) | **DELETE** /Organisations/{id}/OrganisationLinks/{linkId} | Deletes an Organisation Link
[**deleteTag**](OrganisationsApi.md#deleteTag) | **DELETE** /Organisations/{id}/Tags/{tagName} | Deletes a Tag
[**getEmails**](OrganisationsApi.md#getEmails) | **GET** /Organisations/{id}/Emails | Gets a list of Organisation&#39;s Emails
[**getEvents**](OrganisationsApi.md#getEvents) | **GET** /Organisations/{id}/Events | Gets an Organisation&#39;s Events
[**getFileAttachments**](OrganisationsApi.md#getFileAttachments) | **GET** /Organisations/{id}/FileAttachments | Gets an Organisation&#39;s File Attachments
[**getFollow**](OrganisationsApi.md#getFollow) | **GET** /Organisations/{id}/Follow | Gets a Follow record for the Organisation
[**getImage**](OrganisationsApi.md#getImage) | **GET** /Organisations/{id}/Image | Gets an Organisations&#39;s Image
[**getNotes**](OrganisationsApi.md#getNotes) | **GET** /Organisations/{id}/Notes | Gets an Organisation&#39;s Notes
[**getOrganisation**](OrganisationsApi.md#getOrganisation) | **GET** /Organisations/{id} | Gets an Organisation
[**getOrganisations**](OrganisationsApi.md#getOrganisations) | **GET** /Organisations | Gets a list of Organisations.
[**getOrganisationsBySearch**](OrganisationsApi.md#getOrganisationsBySearch) | **GET** /Organisations/Search | Gets a filtered list of Organisations.
[**getTasks**](OrganisationsApi.md#getTasks) | **GET** /Organisations/{id}/Tasks | Gets a list of Organisation&#39;s Tasks
[**updateAddress**](OrganisationsApi.md#updateAddress) | **PUT** /Organisations/{id}/Addresses | Updates an Address
[**updateContactInfo**](OrganisationsApi.md#updateContactInfo) | **PUT** /Organisations/{id}/ContactInfos | Updates a Contact Info
[**updateCustomField**](OrganisationsApi.md#updateCustomField) | **PUT** /Organisations/{id}/CustomFields | Updates a Custom Field
[**updateDate**](OrganisationsApi.md#updateDate) | **PUT** /Organisations/{id}/Dates | Updates an Organisation Date
[**updateImage**](OrganisationsApi.md#updateImage) | **PUT** /Organisations/{id}/Image/{filename} | Updates an Organisation&#39;s Image
[**updateLink**](OrganisationsApi.md#updateLink) | **PUT** /Organisations/{id}/Links | Updates a Link
[**updateOrganisation**](OrganisationsApi.md#updateOrganisation) | **PUT** /Organisations | Updates an Organisation
[**updateOrganisationLink**](OrganisationsApi.md#updateOrganisationLink) | **PUT** /Organisations/{id}/OrganisationLinks | Updates an Organisation Link


<a name="addActivitySetAssignment"></a>
# **addActivitySetAssignment**
> addActivitySetAssignment(id, apiActivitySetAssignment)

Adds an Activity Set to an Organisation

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | A Organisaton's ID
ActivitySetAssignment apiActivitySetAssignment = new ActivitySetAssignment(); // ActivitySetAssignment | The Activity Set Assignment object which contains the configuration information for the Activity Set
try {
    apiInstance.addActivitySetAssignment(id, apiActivitySetAssignment);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#addActivitySetAssignment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| A Organisaton&#39;s ID |
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

Limited to two addresses, one Shipping Address and one Billing Address. For more information, please refer to Body Schema.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
Address apiAddress = new Address(); // Address | The Address to add (just include the JSON object in the request body)
try {
    Address result = apiInstance.addAddress(id, apiAddress);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#addAddress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
 **apiAddress** | [**Address**](Address.md)| The Address to add (just include the JSON object in the request body) |

### Return type

[**Address**](Address.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addContactInfo"></a>
# **addContactInfo**
> ContactInfo addContactInfo(id, apiContactInfo)

Adds a Contact Info

Limited to two Phone Numbers and one Website. For more information, please refer to Body Schema.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
ContactInfo apiContactInfo = new ContactInfo(); // ContactInfo | The Contact Info to add (just include the JSON object in the request body)
try {
    ContactInfo result = apiInstance.addContactInfo(id, apiContactInfo);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#addContactInfo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
 **apiContactInfo** | [**ContactInfo**](ContactInfo.md)| The Contact Info to add (just include the JSON object in the request body) |

### Return type

[**ContactInfo**](ContactInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addDate"></a>
# **addDate**
> OrganisationDate addDate(id, apiDate)

Adds an Organisation Date

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
OrganisationDate apiDate = new OrganisationDate(); // OrganisationDate | The Organisation Date to add (just include the JSON object in the request body)
try {
    OrganisationDate result = apiInstance.addDate(id, apiDate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#addDate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
 **apiDate** | [**OrganisationDate**](OrganisationDate.md)| The Organisation Date to add (just include the JSON object in the request body) |

### Return type

[**OrganisationDate**](OrganisationDate.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addFileAttachment"></a>
# **addFileAttachment**
> FileAttachment addFileAttachment(id, file, fileName, contentType, fileCategoryId)

Adds a File Attachment to an Organisation

This endpoint expects multipart/form-data as the request payload. See Stack Overflow for examples of how to generate multipart requests, or see our &lt;a href&#x3D;\&quot;http://github.com/Insightly\&quot; target&#x3D;\&quot;_blank\&quot;&gt;client libraries&lt;/a&gt; for an example of how this is generated. Only one file can be added per request.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
String file = "/path/to/file.txt"; // String | The file part of the multipart/form-data request. Only one file can be added per request.
String fileName = "fileName_example"; // String | 
String contentType = "contentType_example"; // String | 
Integer fileCategoryId = 56; // Integer | 
try {
    FileAttachment result = apiInstance.addFileAttachment(id, file, fileName, contentType, fileCategoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#addFileAttachment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
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

Start following an Organisation

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
try {
    Follow result = apiInstance.addFollow(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#addFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |

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
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
Link apiLink = new Link(); // Link | The Link to add (just include the JSON object in the request body)
try {
    Link result = apiInstance.addLink(id, apiLink);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#addLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
 **apiLink** | [**Link**](Link.md)| The Link to add (just include the JSON object in the request body) |

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

Adds a Note to an Organisation

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
Note apiNote = new Note(); // Note | The Note to add (just include the JSON object in the request body)
try {
    Note result = apiInstance.addNote(id, apiNote);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#addNote");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
 **apiNote** | [**Note**](Note.md)| The Note to add (just include the JSON object in the request body) |

### Return type

[**Note**](Note.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addOrganisation"></a>
# **addOrganisation**
> Organisation addOrganisation(apiOrganisation)

Adds an Organisation

If you have trouble with creating an organisation, try creating organisations via the web interface, and then access those organisations via the API. This way you            can see examples of the fields and sub-elements attached to the object. A common source of problems during write/update request is caused when users omit            required fields, or insert invalid data in a field (e.g. reference a CATEGORY_ID that does not exist in the user&#39;s Insightly instance.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Organisation apiOrganisation = new Organisation(); // Organisation | The Organisation to add (just include JSON object as request body)
try {
    Organisation result = apiInstance.addOrganisation(apiOrganisation);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#addOrganisation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiOrganisation** | [**Organisation**](Organisation.md)| The Organisation to add (just include JSON object as request body) |

### Return type

[**Organisation**](Organisation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addOrganisationLink"></a>
# **addOrganisationLink**
> OrganisationLink addOrganisationLink(id, apiLink)

Adds an Organisation Link

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
OrganisationLink apiLink = new OrganisationLink(); // OrganisationLink | The Organisation Link to add (just include the JSON object in the request body)
try {
    OrganisationLink result = apiInstance.addOrganisationLink(id, apiLink);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#addOrganisationLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
 **apiLink** | [**OrganisationLink**](OrganisationLink.md)| The Organisation Link to add (just include the JSON object in the request body) |

### Return type

[**OrganisationLink**](OrganisationLink.md)

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
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
Tag apiTag = new Tag(); // Tag | The Tag to add (just include the JSON object in the request body)
try {
    Tag result = apiInstance.addTag(id, apiTag);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#addTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
 **apiTag** | [**Tag**](Tag.md)| The Tag to add (just include the JSON object in the request body) |

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
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
Long addressId = 789L; // Long | An Address' ID (ADDRESS_ID)
try {
    apiInstance.deleteAddress(id, addressId);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#deleteAddress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
 **addressId** | **Long**| An Address&#39; ID (ADDRESS_ID) |

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
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
Long contactInfoId = 789L; // Long | A Contact Info's ID (CONTACT_INFO_ID)
try {
    apiInstance.deleteContactInfo(id, contactInfoId);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#deleteContactInfo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
 **contactInfoId** | **Long**| A Contact Info&#39;s ID (CONTACT_INFO_ID) |

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
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
String customFieldId = "customFieldId_example"; // String | A Custom Field's ID (CUSTOM_FIELD_ID)
try {
    apiInstance.deleteCustomField(id, customFieldId);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#deleteCustomField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
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

Deletes an Organisation Date

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
Long dateId = 789L; // Long | An Organisation Date's ID (DATE_ID)
try {
    apiInstance.deleteDate(id, dateId);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#deleteDate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
 **dateId** | **Long**| An Organisation Date&#39;s ID (DATE_ID) |

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

Stop following an Organisation

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
try {
    apiInstance.deleteFollow(id);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#deleteFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |

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

Deletes an Organisation&#39;s Image



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
try {
    apiInstance.deleteImage(id);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#deleteImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |

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
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
Long linkId = 789L; // Long | A Link's ID (LINK_ID)
try {
    apiInstance.deleteLink(id, linkId);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#deleteLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
 **linkId** | **Long**| A Link&#39;s ID (LINK_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteOrganisation"></a>
# **deleteOrganisation**
> deleteOrganisation(id)

Deletes an Organisation



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID
try {
    apiInstance.deleteOrganisation(id);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#deleteOrganisation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteOrganisationLink"></a>
# **deleteOrganisationLink**
> deleteOrganisationLink(id, linkId)

Deletes an Organisation Link

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
Long linkId = 789L; // Long | An Organisation Link's ID (ORG_LINK_ID)
try {
    apiInstance.deleteOrganisationLink(id, linkId);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#deleteOrganisationLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
 **linkId** | **Long**| An Organisation Link&#39;s ID (ORG_LINK_ID) |

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
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
String tagName = "tagName_example"; // String | A Tag's name
try {
    apiInstance.deleteTag(id, tagName);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#deleteTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
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

Gets a list of Organisation&#39;s Emails

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when email was last updated.
Integer top = 56; // Integer | Optional, maximum number of emails to return.
Integer skip = 56; // Integer | Optional, number of emails to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<Email> result = apiInstance.getEmails(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#getEmails");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID |
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

Gets an Organisation&#39;s Events

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when event was last updated.
Integer top = 56; // Integer | Optional, maximum number of events to return.
Integer skip = 56; // Integer | Optional, number of events to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<CalendarEvent> result = apiInstance.getEvents(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#getEvents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
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

Gets an Organisation&#39;s File Attachments

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when file attachment was last updated.
Integer skip = 56; // Integer | Optional, number of file attachments to skip.
Integer top = 56; // Integer | Optional, maximum number of file attachments to return in the response.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<FileAttachment> result = apiInstance.getFileAttachments(id, updatedAfterUtc, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#getFileAttachments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
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

Gets a Follow record for the Organisation

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
try {
    Follow result = apiInstance.getFollow(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#getFollow");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |

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

Gets an Organisations&#39;s Image

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
try {
    apiInstance.getImage(id);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#getImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |

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

Gets an Organisation&#39;s Notes

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when note was last updated.
Integer top = 56; // Integer | Optional, maximum number of notes to return.
Integer skip = 56; // Integer | Optional, number of notes to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<Note> result = apiInstance.getNotes(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#getNotes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
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

<a name="getOrganisation"></a>
# **getOrganisation**
> Organisation getOrganisation(id)

Gets an Organisation



### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID
try {
    Organisation result = apiInstance.getOrganisation(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#getOrganisation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID |

### Return type

[**Organisation**](Organisation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getOrganisations"></a>
# **getOrganisations**
> List&lt;Organisation&gt; getOrganisations(brief, skip, top, countTotal)

Gets a list of Organisations.

Simple object graphs (excluding ADDRESSES, CONTACTINFOS, etc.) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the organisation.
Integer skip = 56; // Integer | Optional, number of organisations to skip.
Integer top = 56; // Integer | Optional, maximum number of organisations to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Organisation> result = apiInstance.getOrganisations(brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#getOrganisations");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the organisation. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of organisations to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of organisations to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Organisation&gt;**](Organisation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getOrganisationsBySearch"></a>
# **getOrganisationsBySearch**
> List&lt;Organisation&gt; getOrganisationsBySearch(email, emailDomain, tag, phoneNumber, organisationName, city, state, postcode, country, updatedAfterUtc, brief, skip, top, countTotal)

Gets a filtered list of Organisations.

Only one optional parameter (excluding brief, top, skip and count_total) can be specified. Simple object graphs (excluding ADDRESSES, CONTACTINFOS, etc.) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
String email = "email_example"; // String | Optional, email address.
String emailDomain = "emailDomain_example"; // String | Optional, email domain.
String tag = "tag_example"; // String | Optional, a single tag.
String phoneNumber = "phoneNumber_example"; // String | Optional, phone number.
String organisationName = "organisationName_example"; // String | Optional, name of the organisation.
String city = "city_example"; // String | Optional, name of the city from organisation address.
String state = "state_example"; // String | Optional, state from the organisation address.
String postcode = "postcode_example"; // String | Optional, postal code from the organisation address.
String country = "country_example"; // String | Optional, name of the country from organisation address.
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when organisation was last updated.
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the organisation.
Integer skip = 56; // Integer | Optional, number of organisations to skip.
Integer top = 56; // Integer | Optional, maximum number of organisations to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Organisation> result = apiInstance.getOrganisationsBySearch(email, emailDomain, tag, phoneNumber, organisationName, city, state, postcode, country, updatedAfterUtc, brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#getOrganisationsBySearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**| Optional, email address. | [optional]
 **emailDomain** | **String**| Optional, email domain. | [optional]
 **tag** | **String**| Optional, a single tag. | [optional]
 **phoneNumber** | **String**| Optional, phone number. | [optional]
 **organisationName** | **String**| Optional, name of the organisation. | [optional]
 **city** | **String**| Optional, name of the city from organisation address. | [optional]
 **state** | **String**| Optional, state from the organisation address. | [optional]
 **postcode** | **String**| Optional, postal code from the organisation address. | [optional]
 **country** | **String**| Optional, name of the country from organisation address. | [optional]
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when organisation was last updated. | [optional]
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the organisation. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of organisations to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of organisations to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Organisation&gt;**](Organisation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getTasks"></a>
# **getTasks**
> List&lt;Task&gt; getTasks(id, updatedAfterUtc, top, skip, brief, countTotal)

Gets a list of Organisation&#39;s Tasks

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when task was last updated.
Integer top = 56; // Integer | Optional, maximum number of tasks to return.
Integer skip = 56; // Integer | Optional, number of tasks to skip.
Boolean brief = false; // Boolean | true if only top level properties needs to be returned.
Boolean countTotal = false; // Boolean | true if total number of records should be returned in the response headers.
try {
    List<Task> result = apiInstance.getTasks(id, updatedAfterUtc, top, skip, brief, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#getTasks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID |
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
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
Address apiAddress = new Address(); // Address | The Address to update (just include the JSON object in the request body)
try {
    Address result = apiInstance.updateAddress(id, apiAddress);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#updateAddress");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
 **apiAddress** | [**Address**](Address.md)| The Address to update (just include the JSON object in the request body) |

### Return type

[**Address**](Address.md)

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
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
ContactInfo apiContactInfo = new ContactInfo(); // ContactInfo | The Contact Info to add (just include the JSON object in the request body)
try {
    ContactInfo result = apiInstance.updateContactInfo(id, apiContactInfo);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#updateContactInfo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
 **apiContactInfo** | [**ContactInfo**](ContactInfo.md)| The Contact Info to add (just include the JSON object in the request body) |

### Return type

[**ContactInfo**](ContactInfo.md)

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
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
CustomField apiCustomField = new CustomField(); // CustomField | The Custom Field to edit (just include the JSON object in the request body)
try {
    CustomField result = apiInstance.updateCustomField(id, apiCustomField);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#updateCustomField");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
 **apiCustomField** | [**CustomField**](CustomField.md)| The Custom Field to edit (just include the JSON object in the request body) |

### Return type

[**CustomField**](CustomField.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="updateDate"></a>
# **updateDate**
> OrganisationDate updateDate(id, apiDate)

Updates an Organisation Date

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
OrganisationDate apiDate = new OrganisationDate(); // OrganisationDate | The Organisation Date to add (just include the JSON object in the request body)
try {
    OrganisationDate result = apiInstance.updateDate(id, apiDate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#updateDate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
 **apiDate** | [**OrganisationDate**](OrganisationDate.md)| The Organisation Date to add (just include the JSON object in the request body) |

### Return type

[**OrganisationDate**](OrganisationDate.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="updateImage"></a>
# **updateImage**
> Organisation updateImage(id, filename, file)

Updates an Organisation&#39;s Image

This action will replace any existing Image attached to the Organisation. Image file contents should be sent as binary data in request payload. See our &lt;a href&#x3D;\&quot;http://github.com/Insightly\&quot; target&#x3D;\&quot;_blank\&quot;&gt;client libraries&lt;/a&gt; for an example of how this is done.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
String filename = "filename_example"; // String | Name of Image File to be attached to Organisation
byte[] file = BINARY_DATA_HERE; // byte[] | File to upload
try {
    Organisation result = apiInstance.updateImage(id, filename, file);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#updateImage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
 **filename** | **String**| Name of Image File to be attached to Organisation |
 **file** | **byte[]**| File to upload |

### Return type

[**Organisation**](Organisation.md)

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
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
Link apiLink = new Link(); // Link | The Link to add (just include the JSON object in the request body)
try {
    Link result = apiInstance.updateLink(id, apiLink);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#updateLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
 **apiLink** | [**Link**](Link.md)| The Link to add (just include the JSON object in the request body) |

### Return type

[**Link**](Link.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="updateOrganisation"></a>
# **updateOrganisation**
> Organisation updateOrganisation(apiOrganisation, brief)

Updates an Organisation

If you have trouble updating an organisation, try accessing the organisation via the GET request to inspect its fields and sub-elements. A common source of            problems with write/update requests occurs when users either omit required fields, or insert invalid data into a field (for example, by referring a            CATEGORY_ID or LINK_ID which does not exist.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Organisation apiOrganisation = new Organisation(); // Organisation | An Organisation (just include JSON object as request body)
Boolean brief = false; // Boolean | Optional, true if you wish to do a partial update containing only top level properties of the Organisation. When true, all sub-collections are ignored.
try {
    Organisation result = apiInstance.updateOrganisation(apiOrganisation, brief);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#updateOrganisation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiOrganisation** | [**Organisation**](Organisation.md)| An Organisation (just include JSON object as request body) |
 **brief** | **Boolean**| Optional, true if you wish to do a partial update containing only top level properties of the Organisation. When true, all sub-collections are ignored. | [optional] [default to false]

### Return type

[**Organisation**](Organisation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="updateOrganisationLink"></a>
# **updateOrganisationLink**
> OrganisationLink updateOrganisationLink(id, apiLink)

Updates an Organisation Link

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OrganisationsApi;


OrganisationsApi apiInstance = new OrganisationsApi();
Long id = 789L; // Long | An Organisation's ID (ORGANISATION_ID)
OrganisationLink apiLink = new OrganisationLink(); // OrganisationLink | The Organisation Link to add (just include the JSON object in the request body)
try {
    OrganisationLink result = apiInstance.updateOrganisationLink(id, apiLink);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrganisationsApi#updateOrganisationLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Organisation&#39;s ID (ORGANISATION_ID) |
 **apiLink** | [**OrganisationLink**](OrganisationLink.md)| The Organisation Link to add (just include the JSON object in the request body) |

### Return type

[**OrganisationLink**](OrganisationLink.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

