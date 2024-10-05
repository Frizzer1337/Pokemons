package com.devtools.frizzer.controller

import com.devtools.frizzer.api.TrainerApiController
import com.devtools.frizzer.model.TrainerDto
import com.devtools.frizzer.model.TrainerResponseDto
import com.devtools.frizzer.service.TrainerService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.http.ResponseEntity

class TrainerController(val service: TrainerService) : TrainerApiController() {

    override suspend fun findTrainerById(trainerId: Long): ResponseEntity<TrainerResponseDto> {
        return ResponseEntity.ok(service.findById(trainerId).awaitSingle())
    }

    override fun listTrainers(): ResponseEntity<Flow<TrainerDto>> {
        return ResponseEntity.ok(service.findAll().asFlow())
    }

    override suspend fun saveTrainer(trainerDto: TrainerDto): ResponseEntity<Long> {
        return ResponseEntity.ok(service.save(trainerDto).awaitSingle())
    }

}