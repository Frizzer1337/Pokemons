package com.devtools.frizzer.api

import com.devtools.frizzer.model.ArenaDto
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import org.springframework.validation.annotation.Validated
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.beans.factory.annotation.Autowired

import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

import kotlinx.coroutines.flow.Flow
import kotlin.collections.List
import kotlin.collections.Map

@RestController
@Validated
@RequestMapping("\${api.base-path:/v1}")
class ArenaApiController() {

    @Operation(
        summary = "Find arena by id",
        operationId = "findArenaById",
        description = """Returns arena with given id""",
        responses = [
            ApiResponse(responseCode = "200", description = "Arena with given id", content = [Content(schema = Schema(implementation = ArenaDto::class))]),
            ApiResponse(responseCode = "400", description = "Invalid id"),
            ApiResponse(responseCode = "404", description = "Arena not found") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/arena/{id}"],
        produces = ["application/json"]
    )
    suspend fun findArenaById(@Parameter(description = "ID of arena to return", required = true) @PathVariable("id") id: kotlin.Long): ResponseEntity<ArenaDto> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "list all available arenas",
        operationId = "listArena",
        description = """List all available arenas""",
        responses = [
            ApiResponse(responseCode = "200", description = "A paged array of arenas", content = [Content(array = ArraySchema(schema = Schema(implementation = ArenaDto::class)))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/arena"],
        produces = ["application/json"]
    )
    fun listArena(): ResponseEntity<Flow<ArenaDto>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "saves a arena",
        operationId = "saveArena",
        description = """Saves a arena""",
        responses = [
            ApiResponse(responseCode = "200", description = "Arena was successfully saved", content = [Content(schema = Schema(implementation = kotlin.Long::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/arena"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    suspend fun saveArena(@Parameter(description = "", required = true) @Valid @RequestBody arenaDto: ArenaDto): ResponseEntity<kotlin.Long> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}