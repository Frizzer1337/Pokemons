package com.devtools.frizzer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TrainerApiApplication

fun main(args: Array<String>) {
    runApplication<TrainerApiApplication>(*args)
}
