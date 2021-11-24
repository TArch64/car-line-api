package ua.tarch64.carlineapi.cars.controller

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ua.tarch64.carlineapi.cars.controller.responses.CarResponse
import ua.tarch64.carlineapi.cars.controller.responses.CarsItemResponse
import ua.tarch64.carlineapi.cars.entities.CarEntity
import ua.tarch64.carlineapi.cars.services.CarService
import java.util.*

@RestController
@RequestMapping("/cars")
class CarController(private val carService: CarService) {
    @GetMapping
    fun getCars(): List<CarsItemResponse> {
        return carService.getCars().map(CarsItemResponse::fromEntity)
    }

    @GetMapping("/{carId}")
    fun getCar(@PathVariable("carId") carId: UUID): CarResponse? {
        return carService.getCar(carId)?.let(CarResponse::fromEntity)
    }

    @PostMapping
    fun addCar(@Validated @RequestBody options: CarEntity.CreateOptions): CarResponse {
        return carService.addCar(options).let(CarResponse::fromEntity)
    }
}
