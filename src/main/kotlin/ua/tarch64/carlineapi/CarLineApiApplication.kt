package ua.tarch64.carlineapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CarLineApiApplication

fun main(args: Array<String>) {
    runApplication<CarLineApiApplication>(*args)
}
