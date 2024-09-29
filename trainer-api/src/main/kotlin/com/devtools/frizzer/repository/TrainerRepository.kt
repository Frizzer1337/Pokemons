package com.devtools.frizzer.repository

import com.devtools.frizzer.entity.Trainer
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository

@Repository
interface TrainerRepository : R2dbcRepository<Trainer, Long>