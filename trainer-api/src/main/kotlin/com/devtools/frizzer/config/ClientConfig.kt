package com.devtools.frizzer.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import com.devtools.frizzer.api.arena.DefaultApi as ArenaApi
import com.devtools.frizzer.api.pokemon.DefaultApi as PokemonApi

private const val pokemonUrl: String = "http://localhost:8000/v1"
private const val arenaUrl: String = "http://localhost:8002/v1"

@Configuration
class ClientConfig {

    @Bean
    fun pokemonClient(): PokemonApi = PokemonApi(pokemonUrl)

    @Bean
    fun arenaClient(): ArenaApi = ArenaApi(arenaUrl)
}