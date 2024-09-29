package com.devtools.frizzer.config

import com.devtools.frizzer.api.TrainerApiController
import com.devtools.frizzer.controller.TrainerController
import com.devtools.frizzer.service.TrainerService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig(val service: TrainerService) {

    @Bean
    fun trainerApiController(): TrainerApiController = TrainerController(service)

}