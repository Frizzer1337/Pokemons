package com.devtools.frizzer.controler

import com.devtools.frizzer.api.ArenaApiController
import com.devtools.frizzer.model.ArenaDto
import com.devtools.frizzer.service.ArenaService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirst
import org.springframework.http.ResponseEntity

class ArenaController(val service: ArenaService) : ArenaApiController() {

    override fun listArena(): ResponseEntity<Flow<ArenaDto>> {
        return ResponseEntity.ok(service.findAll().asFlow())
    }

    override suspend fun findArenaById(id: Long): ResponseEntity<ArenaDto> {
        return ResponseEntity.ok(service.findById(id).awaitFirst())
    }

    override suspend fun saveArena(arenaDto: ArenaDto): ResponseEntity<Long> {
        return ResponseEntity.ok(service.save(arenaDto).awaitFirst())
    }

}