# EventsApi

All URIs are relative to *https://api.insight.ly/v2.2*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addEvent**](EventsApi.md#addEvent) | **POST** /Events | Adds a Calendar Event
[**addEventLink**](EventsApi.md#addEventLink) | **POST** /Events/{id}/EventLinks | Adds an Event Link
[**deleteEvent**](EventsApi.md#deleteEvent) | **DELETE** /Events/{id} | Deletes a Calendar Event
[**deleteEventLink**](EventsApi.md#deleteEventLink) | **DELETE** /Events/{id}/EventLinks/{linkId} | Deletes an Event Link
[**getEvent**](EventsApi.md#getEvent) | **GET** /Events/{id} | Gets a Calendar Event
[**getEvents**](EventsApi.md#getEvents) | **GET** /Events | Gets a list of Calendar Events.
[**getEventsBySearch**](EventsApi.md#getEventsBySearch) | **GET** /Events/Search | Gets a filtered list of Calendar Events.
[**updateEvent**](EventsApi.md#updateEvent) | **PUT** /Events | Updates a Calendar Event


<a name="addEvent"></a>
# **addEvent**
> CalendarEvent addEvent(apiEvent)

Adds a Calendar Event

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EventsApi;


EventsApi apiInstance = new EventsApi();
CalendarEvent apiEvent = new CalendarEvent(); // CalendarEvent | The Event to add (just include JSON object as request body)
try {
    CalendarEvent result = apiInstance.addEvent(apiEvent);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EventsApi#addEvent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiEvent** | [**CalendarEvent**](CalendarEvent.md)| The Event to add (just include JSON object as request body) |

### Return type

[**CalendarEvent**](CalendarEvent.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="addEventLink"></a>
# **addEventLink**
> EventLink addEventLink(id, apiLink)

Adds an Event Link

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EventsApi;


EventsApi apiInstance = new EventsApi();
Long id = 789L; // Long | An Event's ID (EVENT_ID)
EventLink apiLink = new EventLink(); // EventLink | The Event Link to add (just include JSON object as request body)
try {
    EventLink result = apiInstance.addEventLink(id, apiLink);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EventsApi#addEventLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Event&#39;s ID (EVENT_ID) |
 **apiLink** | [**EventLink**](EventLink.md)| The Event Link to add (just include JSON object as request body) |

### Return type

[**EventLink**](EventLink.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteEvent"></a>
# **deleteEvent**
> deleteEvent(id)

Deletes a Calendar Event

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EventsApi;


EventsApi apiInstance = new EventsApi();
Long id = 789L; // Long | An Event's ID
try {
    apiInstance.deleteEvent(id);
} catch (ApiException e) {
    System.err.println("Exception when calling EventsApi#deleteEvent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Event&#39;s ID |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="deleteEventLink"></a>
# **deleteEventLink**
> deleteEventLink(id, linkId)

Deletes an Event Link

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EventsApi;


EventsApi apiInstance = new EventsApi();
Long id = 789L; // Long | An Event's ID (EVENT_ID)
Long linkId = 789L; // Long | A EVENT Link's ID (EVENT_LINK_ID)
try {
    apiInstance.deleteEventLink(id, linkId);
} catch (ApiException e) {
    System.err.println("Exception when calling EventsApi#deleteEventLink");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Event&#39;s ID (EVENT_ID) |
 **linkId** | **Long**| A EVENT Link&#39;s ID (EVENT_LINK_ID) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

<a name="getEvent"></a>
# **getEvent**
> CalendarEvent getEvent(id)

Gets a Calendar Event

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EventsApi;


EventsApi apiInstance = new EventsApi();
Long id = 789L; // Long | An Event's ID
try {
    CalendarEvent result = apiInstance.getEvent(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EventsApi#getEvent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| An Event&#39;s ID |

### Return type

[**CalendarEvent**](CalendarEvent.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getEvents"></a>
# **getEvents**
> List&lt;CalendarEvent&gt; getEvents(brief, skip, top, countTotal)

Gets a list of Calendar Events.

Simple object graphs (excluding EVENTLINKS) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EventsApi;


EventsApi apiInstance = new EventsApi();
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the event.
Integer skip = 56; // Integer | Optional, number of events to skip.
Integer top = 56; // Integer | Optional, maximum number of events to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<CalendarEvent> result = apiInstance.getEvents(brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EventsApi#getEvents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the event. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of events to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of events to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;CalendarEvent&gt;**](CalendarEvent.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getEventsBySearch"></a>
# **getEventsBySearch**
> List&lt;CalendarEvent&gt; getEventsBySearch(title, ownerUserId, startDateUtc, endDateUtc, updatedAfterUtc, brief, skip, top, countTotal)

Gets a filtered list of Calendar Events.

Only one optional parameter (excluding top, skip and count_total) can be specified. Simple object graphs (excluding EVENTLINKS) are returned if \&quot;brief&#x3D;true\&quot; is used in the query string.

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EventsApi;


EventsApi apiInstance = new EventsApi();
String title = "title_example"; // String | Optional, event title.
Long ownerUserId = 789L; // Long | Optional, id of the owner user.
OffsetDateTime startDateUtc = new OffsetDateTime(); // OffsetDateTime | Optional, start date of the event. Only the date is considered, not the time.
OffsetDateTime endDateUtc = new OffsetDateTime(); // OffsetDateTime | Optional, end date of the event. Only the date is considered, not the time.
OffsetDateTime updatedAfterUtc = new OffsetDateTime(); // OffsetDateTime | Optional, earliest date when event was last updated. Date and time are considered.
Boolean brief = false; // Boolean | Optional, true if response should only contain top level properties of the event.
Integer skip = 56; // Integer | Optional, number of events to skip.
Integer top = 56; // Integer | Optional, maximum number of events to return in the response.
Boolean countTotal = false; // Boolean | Optional, true if total number of records should be returned in the response headers.
try {
    List<CalendarEvent> result = apiInstance.getEventsBySearch(title, ownerUserId, startDateUtc, endDateUtc, updatedAfterUtc, brief, skip, top, countTotal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EventsApi#getEventsBySearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **title** | **String**| Optional, event title. | [optional]
 **ownerUserId** | **Long**| Optional, id of the owner user. | [optional]
 **startDateUtc** | **OffsetDateTime**| Optional, start date of the event. Only the date is considered, not the time. | [optional]
 **endDateUtc** | **OffsetDateTime**| Optional, end date of the event. Only the date is considered, not the time. | [optional]
 **updatedAfterUtc** | **OffsetDateTime**| Optional, earliest date when event was last updated. Date and time are considered. | [optional]
 **brief** | **Boolean**| Optional, true if response should only contain top level properties of the event. | [optional] [default to false]
 **skip** | **Integer**| Optional, number of events to skip. | [optional]
 **top** | **Integer**| Optional, maximum number of events to return in the response. | [optional]
 **countTotal** | **Boolean**| Optional, true if total number of records should be returned in the response headers. | [optional] [default to false]

### Return type

[**List&lt;CalendarEvent&gt;**](CalendarEvent.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateEvent"></a>
# **updateEvent**
> CalendarEvent updateEvent(apiEvent, brief)

Updates a Calendar Event

### Example
```java
// Import classes:
//import com.insightly.api.util.ApiException;
//import com.insightly.api.EventsApi;


EventsApi apiInstance = new EventsApi();
CalendarEvent apiEvent = new CalendarEvent(); // CalendarEvent | The Event to update (just include JSON object as request body)
Boolean brief = false; // Boolean | Optional, true if you wish to do a partial update containing only top level properties of the Event. When true, all sub-collections are ignored.
try {
    CalendarEvent result = apiInstance.updateEvent(apiEvent, brief);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling EventsApi#updateEvent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiEvent** | [**CalendarEvent**](CalendarEvent.md)| The Event to update (just include JSON object as request body) |
 **brief** | **Boolean**| Optional, true if you wish to do a partial update containing only top level properties of the Event. When true, all sub-collections are ignored. | [optional] [default to false]

### Return type

[**CalendarEvent**](CalendarEvent.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/json

