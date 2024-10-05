package com.devtools.frizzer.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.server.WebSession
import reactor.core.publisher.Mono

const val INDEX = "index"
const val POKEMON = "pokemon"
const val TRAINER = "trainer"
const val ARENA = "arena.html"

@Controller
@RequestMapping("/")
class FrontController {

    @GetMapping
    fun index(model: Model, session: WebSession): Mono<String> {
        return Mono.just(INDEX)
    }

}