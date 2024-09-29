/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package com.devtools.frizzer.api.arena

import com.devtools.frizzer.model.ArenaDto
import org.openapitools.client.infrastructure.*
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.http.codec.json.Jackson2JsonDecoder
import org.springframework.http.codec.json.Jackson2JsonEncoder
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClientResponseException
import reactor.core.publisher.Mono

class DefaultApi(client: WebClient) : ApiClient(client) {

    constructor(baseUrl: String) : this(WebClient.builder()
        .baseUrl(baseUrl)
        .codecs {
            it.defaultCodecs().jackson2JsonEncoder(Jackson2JsonEncoder(Serializer.jacksonObjectMapper, MediaType.APPLICATION_JSON))
            it.defaultCodecs().jackson2JsonDecoder(Jackson2JsonDecoder(Serializer.jacksonObjectMapper, MediaType.APPLICATION_JSON))
        }
        .build()
    )


    @Throws(WebClientResponseException::class)
    fun findArenaById(id: kotlin.Long): Mono<ArenaDto> {
        return findArenaByIdWithHttpInfo(id = id)
            .map { it.body }
    }

    @Throws(WebClientResponseException::class)
    fun findArenaByIdWithHttpInfo(id: kotlin.Long): Mono<ResponseEntity<ArenaDto>> {
        val localVariableConfig = findArenaByIdRequestConfig(id = id)
        return request<Unit, ArenaDto>(
            localVariableConfig
        )
    }

    fun findArenaByIdRequestConfig(id: kotlin.Long) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        val params = mutableMapOf<String, Any>(
            "id" to id,
        )

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/arena/{id}",
            params = params,
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }


    @Throws(WebClientResponseException::class)
    fun listArena(): Mono<kotlin.collections.List<ArenaDto>> {
        return listArenaWithHttpInfo()
            .map { it.body }
    }

    @Throws(WebClientResponseException::class)
    fun listArenaWithHttpInfo(): Mono<ResponseEntity<kotlin.collections.List<ArenaDto>>> {
        val localVariableConfig = listArenaRequestConfig()
        return request<Unit, kotlin.collections.List<ArenaDto>>(
            localVariableConfig
        )
    }

    fun listArenaRequestConfig() : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        val params = mutableMapOf<String, Any>(
        )

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/arena",
            params = params,
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }


    @Throws(WebClientResponseException::class)
    fun saveArena(arenaDto: ArenaDto): Mono<kotlin.Long> {
        return saveArenaWithHttpInfo(arenaDto = arenaDto)
            .map { it.body }
    }

    @Throws(WebClientResponseException::class)
    fun saveArenaWithHttpInfo(arenaDto: ArenaDto): Mono<ResponseEntity<kotlin.Long>> {
        val localVariableConfig = saveArenaRequestConfig(arenaDto = arenaDto)
        return request<ArenaDto, kotlin.Long>(
            localVariableConfig
        )
    }

    fun saveArenaRequestConfig(arenaDto: ArenaDto) : RequestConfig<ArenaDto> {
        val localVariableBody = arenaDto
        val localVariableQuery = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        val params = mutableMapOf<String, Any>(
        )

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/arena",
            params = params,
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

}
