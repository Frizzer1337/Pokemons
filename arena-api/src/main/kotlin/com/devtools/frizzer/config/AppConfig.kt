package com.devtools.frizzer.config

import com.devtools.frizzer.api.ArenaApiController
import com.devtools.frizzer.controler.ArenaController
import com.devtools.frizzer.service.ArenaService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod.POST
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class AppConfig(
    val service: ArenaService,
    val http: ServerHttpSecurity
) {

    @Bean
    fun arenaApiController(): ArenaApiController = ArenaController(service)

    @Bean
    fun securityFilterChain(): SecurityWebFilterChain {
        http.oauth2ResourceServer { oauth2 -> oauth2.jwt(Customizer.withDefaults()) }
        return http.authorizeExchange { c ->
            c.pathMatchers("/error").permitAll()
                .pathMatchers(POST, "/v1/arena/").hasRole("ROLE_TRAINER")
                .anyExchange().authenticated()
        }
            .build()
    }

    @Bean
    fun jwtAuthenticationConverter(): JwtAuthenticationConverter {
        val converter = JwtAuthenticationConverter()
        val jwtGrantedAuthoritiesConverter = JwtGrantedAuthoritiesConverter()
        converter.setPrincipalClaimName("preffered_username")
        converter.setJwtGrantedAuthoritiesConverter { jwt ->
            val authorities = jwtGrantedAuthoritiesConverter.convert(jwt)
            val roles = jwt.getClaimAsMap("realm_access")["roles"] as List<String>
            authorities?.addAll(
                roles.filter { role -> role.startsWith("ROLE_") }
                    .map(::SimpleGrantedAuthority)
            )
            authorities
        }
        return converter
    }

}