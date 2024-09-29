package com.devtools.frizzer.invoker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.devtools.frizzer.invoker", "com.devtools.frizzer.api", "com.devtools.frizzer.model"])
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
