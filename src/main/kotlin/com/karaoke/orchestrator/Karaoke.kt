package com.karaoke.orchestrator

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Karaoke

fun main(args: Array<String>) {
    SpringApplication.run(Karaoke::class.java, *args)
}