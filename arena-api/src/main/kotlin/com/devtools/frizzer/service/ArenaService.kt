package com.devtools.frizzer.service

import com.devtools.frizzer.entity.Arena
import com.devtools.frizzer.entity.toDto
import com.devtools.frizzer.entity.toEntity
import com.devtools.frizzer.model.ArenaDto
import com.devtools.frizzer.repository.ArenaRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ArenaService(val repository: ArenaRepository) {

    fun findAll(): Flux<ArenaDto> {
        return repository.findAll().map(Arena::toDto)
    }

    fun findById(id: Long): Mono<ArenaDto> {
        return repository.findById(id).map(Arena::toDto)
    }

    fun save(arena: ArenaDto): Mono<Long> {
        return repository.save(arena.toEntity()).mapNotNull(Arena::id)
    }

}