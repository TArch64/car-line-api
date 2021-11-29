package ua.tarch64.carlineapi.cars.controller

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ua.tarch64.carlineapi.cars.controller.responses.CarResponse
import ua.tarch64.carlineapi.cars.entities.CarEntity
import ua.tarch64.carlineapi.cars.services.CarService
import java.util.*

@RestController
@RequestMapping("/cars")
class CarController(private val carService: CarService) {
    @GetMapping
    fun getCars(): List<CarResponse> {
        return carService.getCars().map(CarResponse::fromEntity)
    }

    @PostMapping
    fun addCar(@Validated @RequestBody options: CarEntity.CarOptions): CarResponse {
        return carService.addCar(options).let(CarResponse::fromEntity)
    }

    @GetMapping("/{carId}")
    fun getCar(@PathVariable carId: UUID): CarResponse? {
        return carService.getCar(carId)?.let(CarResponse::fromEntity)
    }

    @PutMapping("/{carId}")
    fun updateCar(
        @PathVariable carId: UUID,
        @Validated @RequestBody options: CarEntity.CarOptions
    ) {
        carService.updateCar(carId, options)
    }

    @DeleteMapping("/{carId}")
    fun deleteCar(@PathVariable carId: UUID) {
        carService.deleteCar(carId)
    }
}
