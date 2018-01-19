# CountriesApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getCountries**](CountriesApi.md#getCountries) | **GET** /Countries | Gets a list of Countries used by Insightly


<a name="getCountries"></a>
# **getCountries**
> List&lt;Country&gt; getCountries()

Gets a list of Countries used by Insightly

This read only endpoint returns a list of the countries Insightly recognizes for use in addresses.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.CountriesApi;


CountriesApi apiInstance = new CountriesApi();
try {
    List<Country> result = apiInstance.getCountries();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CountriesApi#getCountries");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Country&gt;**](Country.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

