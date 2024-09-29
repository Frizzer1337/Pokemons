package com.devtools.frizzer.api

import com.devtools.frizzer.model.TrainerDto
import com.devtools.frizzer.model.TrainerResponseDto
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
class TrainerApiController() {

    @Operation(
        summary = "Find trainer by id",
        operationId = "findTrainerById",
        description = """Returns trainer with given id""",
        responses = [
            ApiResponse(responseCode = "200", description = "A paged array of trainers", content = [Content(schema = Schema(implementation = TrainerResponseDto::class))]),
            ApiResponse(responseCode = "400", description = "Invalid id"),
            ApiResponse(responseCode = "404", description = "Trainer not found") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/trainer/{trainerId}"],
        produces = ["application/json"]
    )
    suspend fun findTrainerById(@Parameter(description = "ID of trainer to return", required = true) @PathVariable("trainerId") trainerId: kotlin.Long): ResponseEntity<TrainerResponseDto> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "list all available trainers",
        operationId = "listTrainers",
        description = """List all available trainers""",
        responses = [
            ApiResponse(responseCode = "200", description = "A paged array of trainers", content = [Content(array = ArraySchema(schema = Schema(implementation = TrainerDto::class)))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/trainer"],
        produces = ["application/json"]
    )
    fun listTrainers(): ResponseEntity<Flow<TrainerDto>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "saves a trainer",
        operationId = "saveTrainer",
        description = """Saves a trainer""",
        responses = [
            ApiResponse(responseCode = "200", description = "Pokemon was successfully saved", content = [Content(schema = Schema(implementation = kotlin.Long::class))]) ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/trainer"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    suspend fun saveTrainer(@Parameter(description = "", required = true) @Valid @RequestBody trainerDto: TrainerDto): ResponseEntity<kotlin.Long> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
