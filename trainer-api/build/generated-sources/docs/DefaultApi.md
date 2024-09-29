# DefaultApi

All URIs are relative to *http://localhost:8000/v1*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**findArenaById**](DefaultApi.md#findArenaById) | **GET** /arena/{id} | Find arena by id |
| [**listArena**](DefaultApi.md#listArena) | **GET** /arena | list all available arenas |
| [**saveArena**](DefaultApi.md#saveArena) | **POST** /arena | saves a arena |


<a id="findArenaById"></a>
# **findArenaById**
> ArenaDto findArenaById(id)

Find arena by id

Returns arena with given id

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import com.devtools.frizzer.model.*

val apiInstance = DefaultApi()
val id : kotlin.Long = 789 // kotlin.Long | ID of arena to return
try {
    val result : ArenaDto = apiInstance.findArenaById(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#findArenaById")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#findArenaById")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **id** | **kotlin.Long**| ID of arena to return | |

### Return type

[**ArenaDto**](ArenaDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listArena"></a>
# **listArena**
> kotlin.collections.List&lt;ArenaDto&gt; listArena()

list all available arenas

List all available arenas

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import com.devtools.frizzer.model.*

val apiInstance = DefaultApi()
try {
    val result : kotlin.collections.List<ArenaDto> = apiInstance.listArena()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#listArena")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#listArena")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;ArenaDto&gt;**](ArenaDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="saveArena"></a>
# **saveArena**
> kotlin.Long saveArena(arenaDto)

saves a arena

Saves a arena

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import com.devtools.frizzer.model.*

val apiInstance = DefaultApi()
val arenaDto : ArenaDto =  // ArenaDto | 
try {
    val result : kotlin.Long = apiInstance.saveArena(arenaDto)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#saveArena")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#saveArena")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **arenaDto** | [**ArenaDto**](ArenaDto.md)|  | |

### Return type

**kotlin.Long**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

