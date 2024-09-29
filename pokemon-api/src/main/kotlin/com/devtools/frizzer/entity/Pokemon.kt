package com.devtools.frizzer.entity

import com.devtools.frizzer.model.PokemonDto
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Pokemon(
    @Id
    @org.springframework.data.annotation.Id
    val id: Long?,
    val name: String
)

fun Pokemon.toDto() = PokemonDto(
    id = id,
    name = name
)

fun PokemonDto.toEntity() = Pokemon(
    id = id,
    name = name
)