package com.devtools.frizzer.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param name 
 * @param id 
 * @param pokemonId 
 * @param arenaId 
 */
data class TrainerDto(

    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("name", required = true) val name: kotlin.String,

    @Schema(example = "null", description = "")
    @get:JsonProperty("id") val id: kotlin.Long? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("pokemonId") val pokemonId: kotlin.Long? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("arenaId") val arenaId: kotlin.Long? = null
    ) {

}

