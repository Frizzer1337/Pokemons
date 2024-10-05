package com.devtools.frizzer.entity

import com.devtools.frizzer.model.ArenaDto
import com.devtools.frizzer.model.PokemonDto
import com.devtools.frizzer.model.TrainerDto
import com.devtools.frizzer.model.TrainerResponseDto
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "trainer")
class Trainer(
    @Id
    @org.springframework.data.annotation.Id
    val id: Long?,
    val name: String,
    val pokemonId: Long?,
    val arenaId: Long?
)

fun TrainerDto.toEntity() = Trainer(
    id = id,
    name = name,
    pokemonId = pokemonId,
    arenaId = arenaId
)

fun Trainer.toDto() = TrainerDto(
    id = id,
    name = name,
    pokemonId = pokemonId,
    arenaId = arenaId
)

fun Trainer.toResponse(pokemon: PokemonDto? = null, arena: ArenaDto? = null) = TrainerResponseDto(
    id = id,
    name = name,
    pokemon = pokemon,
    arena = arena
)