package com.devtools.frizzer.service

import com.devtools.frizzer.entity.Pokemon
import com.devtools.frizzer.entity.toDto
import com.devtools.frizzer.entity.toEntity
import com.devtools.frizzer.model.PokemonDto
import com.devtools.frizzer.repository.PokemonRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PokemonService(
    val repository: PokemonRepository
) {
    fun findAll(): Flux<PokemonDto> {
        return repository.findAll().map(Pokemon::toDto)
    }

    fun findById(id: Long): Mono<PokemonDto> {
        return repository.findById(id).map(Pokemon::toDto)
    }

    fun save(pokemon: PokemonDto): Mono<Long> {
        return repository.save(pokemon.toEntity()).mapNotNull(Pokemon::id)
    }
}