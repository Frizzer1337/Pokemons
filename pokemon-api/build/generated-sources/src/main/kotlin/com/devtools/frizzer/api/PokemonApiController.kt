package com.devtools.frizzer.api

import com.devtools.frizzer.model.PokemonDto
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
class PokemonApiController() {

    @Operation(
        summary = "Find pokemon by id",
        operationId = "findPokemonById",
        description = """Returns pokemon with given id""",
        responses = [
            ApiResponse(responseCode = "200", description = "A paged array of pokemons", content = [Content(schema = Schema(implementation = PokemonDto::class))]),
            ApiResponse(responseCode = "400", description = "Invalid id"),
            ApiResponse(responseCode = "404", description = "Pokemon not found") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/pokemon/{pokemonId}"],
        produces = ["application/json"]
    )
    suspend fun findPokemonById(@Parameter(description = "ID of pokemon to return", required = true) @PathVariable("pokemonId") pokemonId: kotlin.Long): ResponseEntity<PokemonDto> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "list all available pokemons",
        operationId = "listPokemons",
        description = """List all available pokemons""",
        responses = [
            ApiResponse(responseCode = "200", description = "A paged array of pokemons", content = [Content(array = ArraySchema(schema = Schema(implementation = PokemonDto::class)))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/pokemon"],
        produces = ["application/json"]
    )
    fun listPokemons(): ResponseEntity<Flow<PokemonDto>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "saves a pokemon",
        operationId = "savePokemon",
        description = """Saves a pokemon""",
        responses = [
            ApiResponse(responseCode = "200", description = "Pokemon was successfully saved", content = [Content(schema = Schema(implementation = kotlin.Long::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/pokemon"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    suspend fun savePokemon(@Parameter(description = "", required = true) @Valid @RequestBody pokemonDto: PokemonDto): ResponseEntity<kotlin.Long> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
