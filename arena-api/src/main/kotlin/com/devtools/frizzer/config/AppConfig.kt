package com.devtools.frizzer.config

import com.devtools.frizzer.api.ArenaApiController
import com.devtools.frizzer.controler.ArenaController
import com.devtools.frizzer.service.ArenaService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig(val service: ArenaService) {

    @Bean
    fun arenaApiController(): ArenaApiController = ArenaController(service)

}