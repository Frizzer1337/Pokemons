package com.devtools.frizzer.model

import java.util.Objects
import com.devtools.frizzer.model.ArenaDto
import com.devtools.frizzer.model.PokemonDto
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import jakarta.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param name 
 * @param id 
 * @param pokemon 
 * @param arena 
 */
data class TrainerResponseDto(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("name", required = true) val name: kotlin.String,

    @Schema(example = "null", description = "")
    @get:JsonProperty("id") val id: kotlin.Long? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("pokemon") var pokemon: PokemonDto? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @get:JsonProperty("arena") var arena: ArenaDto? = null
    ) {

}
