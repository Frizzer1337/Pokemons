package com.devtools.frizzer.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import reactor.core.publisher.Mono

@Controller
@RequestMapping("/arena")
class ArenaController {

    @GetMapping
    fun get() : Mono<String> {
        return Mono.just(ARENA)
    }
}