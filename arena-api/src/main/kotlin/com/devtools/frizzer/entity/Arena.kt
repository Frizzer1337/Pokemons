package com.devtools.frizzer.entity

import com.devtools.frizzer.model.ArenaDto
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Arena(
    @Id
    @org.springframework.data.annotation.Id
    val id: Long?,
    val name: String
)

fun Arena.toDto() = ArenaDto(
    id = id,
    name = name
)

fun ArenaDto.toEntity() = Arena(
    id = id,
    name = name
)