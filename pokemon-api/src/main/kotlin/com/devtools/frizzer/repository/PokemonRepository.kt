package com.devtools.frizzer.repository

import com.devtools.frizzer.entity.Pokemon
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository

@Repository
interface PokemonRepository : R2dbcRepository<Pokemon, Long>