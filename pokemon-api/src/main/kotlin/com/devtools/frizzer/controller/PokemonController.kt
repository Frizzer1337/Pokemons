package com.devtools.frizzer.controller

import com.devtools.frizzer.api.PokemonApiController
import com.devtools.frizzer.model.PokemonDto
import com.devtools.frizzer.service.PokemonService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono

class PokemonController(val service: PokemonService) : PokemonApiController() {

    override suspend fun findPokemonById(pokemonId: Long): ResponseEntity<PokemonDto> {
        return ResponseEntity.ok(
            service.findById(pokemonId)
                .switchIfEmpty(Mono.error(ResponseStatusException(HttpStatus.NOT_FOUND)))
                .awaitSingle()
        )
    }

    override fun listPokemons(): ResponseEntity<Flow<PokemonDto>> {
        return ResponseEntity.ok(service.findAll().asFlow())
    }

    override suspend fun savePokemon(pokemonDto: PokemonDto): ResponseEntity<Long> {
        return ResponseEntity.ok(service.save(pokemonDto).awaitSingle())
    }

}