package ua.tarch64.carlineapi.cars.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ua.tarch64.carlineapi.cars.controller.responses.CarsItemResponse
import ua.tarch64.carlineapi.cars.services.CarService

@RestController
@RequestMapping("/cars")
class CarController(private val carService: CarService) {
    @GetMapping
    fun getCars(): List<CarsItemResponse> {
        return carService.getCars().map(CarsItemResponse::fromEntity)
    }
}
