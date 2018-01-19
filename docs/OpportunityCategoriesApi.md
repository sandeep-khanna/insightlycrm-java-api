# OpportunityCategoriesApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addOpportunityCategory**](OpportunityCategoriesApi.md#addOpportunityCategory) | **POST** /OpportunityCategories | Adds an Opportunity Category
[**deleteOpportunityCategory**](OpportunityCategoriesApi.md#deleteOpportunityCategory) | **DELETE** /OpportunityCategories/{id} | Deactivates an Opportunity Category
[**getOpportunityCategories**](OpportunityCategoriesApi.md#getOpportunityCategories) | **GET** /OpportunityCategories | Gets a list of Opportunity Categories
[**getOpportunityCategory**](OpportunityCategoriesApi.md#getOpportunityCategory) | **GET** /OpportunityCategories/{id} | Gets an Opportunity Category
[**updateOpportunityCategory**](OpportunityCategoriesApi.md#updateOpportunityCategory) | **PUT** /OpportunityCategories | Updates an Opportunity Category


<a name="addOpportunityCategory"></a>
# **addOpportunityCategory**
> Category addOpportunityCategory(category)

Adds an Opportunity Category

This endpoint is used to create a new opportunity category. This endpoint is only accessible to users with administrator permission.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunityCategoriesApi;


OpportunityCategoriesApi apiInstance = new OpportunityCategoriesApi();
Category category = new Category(); // Category | The Opportunity Category to add (just include JSON object as request body)
try {
    Category result = apiInstance.addOpportunityCategory(category);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunityCategoriesApi#addOpportunityCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category** | [**Category**](Category.md)| The Opportunity Category to add (just include JSON object as request body) |

### Return type

[**Category**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteOpportunityCategory"></a>
# **deleteOpportunityCategory**
> deleteOpportunityCategory(id)

Deactivates an Opportunity Category

The endpoint is used to deactivate an existing opportunity category. This endpoint is only accessible to users with administrator permission.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunityCategoriesApi;


OpportunityCategoriesApi apiInstance = new OpportunityCategoriesApi();
Long id = 789L; // Long | An Opportunity Category's ID
try {
    apiInstance.deleteOpportunityCategory(id);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunityCategoriesApi#deleteOpportunityCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity Category&#39;s ID |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="getOpportunityCategories"></a>
# **getOpportunityCategories**
> List&lt;Category&gt; getOpportunityCategories(skip, top, countTotal)

Gets a list of Opportunity Categories

This read only endpoint returns a list of opportunity categories set up for the Insightly instance.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunityCategoriesApi;


OpportunityCategoriesApi apiInstance = new OpportunityCategoriesApi();
Integer skip = 56; // Integer | Optional, number of categories to skip.
Integer top = 56; // Integer | Optional, maximum number of categories to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<Category> result = apiInstance.getOpportunityCategories(skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunityCategoriesApi#getOpportunityCategories");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **skip** | **Integer**| Optional, number of categories to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of categories to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;Category&gt;**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getOpportunityCategory"></a>
# **getOpportunityCategory**
> Category getOpportunityCategory(id)

Gets an Opportunity Category

This endpoint returns the graph for a specific opportunity category

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunityCategoriesApi;


OpportunityCategoriesApi apiInstance = new OpportunityCategoriesApi();
Long id = 789L; // Long | An Opportunity Category's ID
try {
    Category result = apiInstance.getOpportunityCategory(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunityCategoriesApi#getOpportunityCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Opportunity Category&#39;s ID |

### Return type

[**Category**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateOpportunityCategory"></a>
# **updateOpportunityCategory**
> Category updateOpportunityCategory(category)

Updates an Opportunity Category

This endpoint is used to update an existing opportunity category (for example, to change the background color for its label in the user interace). This endpoint is only accessible to users with administrator permission.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.OpportunityCategoriesApi;


OpportunityCategoriesApi apiInstance = new OpportunityCategoriesApi();
Category category = new Category(); // Category | An Opportunity Category (just include JSON object as request body)
try {
    Category result = apiInstance.updateOpportunityCategory(category);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OpportunityCategoriesApi#updateOpportunityCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category** | [**Category**](Category.md)| An Opportunity Category (just include JSON object as request body) |

### Return type

[**Category**](Category.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

