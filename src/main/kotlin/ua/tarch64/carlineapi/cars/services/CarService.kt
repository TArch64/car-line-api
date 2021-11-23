package ua.tarch64.carlineapi.cars.services

import org.springframework.stereotype.Service
import ua.tarch64.carlineapi.cars.repositories.CarRepository

@Service
class CarService(private val repository: CarRepository)
