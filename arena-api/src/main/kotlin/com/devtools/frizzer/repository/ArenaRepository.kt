package com.devtools.frizzer.repository

import com.devtools.frizzer.entity.Arena
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository

@Repository
interface ArenaRepository : R2dbcRepository<Arena, Long>