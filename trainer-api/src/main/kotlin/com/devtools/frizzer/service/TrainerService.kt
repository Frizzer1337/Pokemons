package com.devtools.frizzer.service

import com.devtools.frizzer.entity.Trainer
import com.devtools.frizzer.entity.toDto
import com.devtools.frizzer.entity.toEntity
import com.devtools.frizzer.entity.toResponse
import com.devtools.frizzer.model.PokemonDto
import com.devtools.frizzer.model.TrainerDto
import com.devtools.frizzer.model.TrainerResponseDto
import com.devtools.frizzer.repository.TrainerRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClientResponseException.NotFound
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import com.devtools.frizzer.api.arena.DefaultApi as ArenaApi
import com.devtools.frizzer.api.pokemon.DefaultApi as PokemonApi


@Service
class TrainerService(
    val repository: TrainerRepository,
    val pokemonClient: PokemonApi,
    val arenaClient: ArenaApi,
) {

    fun findById(id: Long): Mono<TrainerResponseDto> {
        return repository.findById(id)
            .flatMap { trainer ->
                val result = trainer.toResponse().toMono()
                addPokemon(trainer.pokemonId, result).then(addArena(trainer.arenaId, result))
            }
    }

    fun addPokemon(pokemonId: Long?, response: Mono<TrainerResponseDto>): Mono<TrainerResponseDto> {
        return if (pokemonId == null) {
            Mono.empty()
        } else {
            pokemonClient.findPokemonById(pokemonId)
                .flatMap { pokemon -> response.map { it.copy(pokemon = pokemon) } }
                .onErrorMap(NotFound::class.java) { pokemonNotFound(pokemonId) }
        }
    }

    fun addArena(arenaId: Long?, response: Mono<TrainerResponseDto>): Mono<TrainerResponseDto> {
        return if (arenaId == null) {
            Mono.empty()
        } else {
            arenaClient.findArenaById(arenaId)
                .flatMap { arena -> response.map { it.copy(arena = arena) } }
                .onErrorMap(NotFound::class.java) { arenaNotFound(arenaId) }
        }
    }

    fun save(trainer: TrainerDto): Mono<Long> {
        return pokemonExists(trainer)
            .onErrorMap(NotFound::class.java) { pokemonNotFound(trainer.pokemonId) }
            .thenReturn(
                repository
                    .save(trainer.toEntity())
                    .mapNotNull(Trainer::id)
            )
            .flatMap { it }
    }

    fun findAll(): Flux<TrainerDto> {
        return repository.findAll().map(Trainer::toDto)
    }

    private fun pokemonExists(trainer: TrainerDto): Mono<PokemonDto> {
        return if (trainer.pokemonId == null) {
            Mono.empty()
        } else {
            pokemonClient.findPokemonById(trainer.pokemonId)
        }
    }

    private fun pokemonNotFound(pokemonId: Long?) = ResponseStatusException(
        HttpStatus.NOT_FOUND,
        "Pokemon with id  $pokemonId not found"
    )

    private fun arenaNotFound(arenaId: Long?) = ResponseStatusException(
        HttpStatus.NOT_FOUND,
        "Pokemon with id  $arenaId not found"
    )
}