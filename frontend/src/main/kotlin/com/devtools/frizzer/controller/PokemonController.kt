package com.devtools.frizzer.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import reactor.core.publisher.Mono

@Controller
@RequestMapping("/pokemon")
class PokemonController {

    @GetMapping
    fun get() : Mono<String> {
        return Mono.just(POKEMON)
    }
}