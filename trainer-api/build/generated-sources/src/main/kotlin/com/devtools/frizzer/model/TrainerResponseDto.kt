package com.devtools.frizzer.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid

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

