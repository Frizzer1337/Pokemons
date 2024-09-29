package com.devtools.frizzer.api

import com.devtools.frizzer.model.PokemonDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import jakarta.validation.Valid
import kotlinx.coroutines.flow.Flow
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

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
