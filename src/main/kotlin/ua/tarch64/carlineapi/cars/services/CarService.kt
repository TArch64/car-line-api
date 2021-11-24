package ua.tarch64.carlineapi.cars.services

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ua.tarch64.carlineapi.cars.entities.CarEntity
import ua.tarch64.carlineapi.cars.repositories.CarRepository
import ua.tarch64.carlineapi.users.services.CurrentUserService
import java.util.*

@Service
class CarService(
    private val repository: CarRepository,
    private val currentUserService: CurrentUserService
) {
    private val currentUser get() = currentUserService.fetchCurrentUser()

    fun getCars(): List<CarEntity> {
        return repository.findAllByUser(currentUser)
    }

    fun getCar(carId: UUID): CarEntity? {
        return repository.findByIdOrNull(carId)
    }

    fun addCar(options: CarEntity.CreateOptions): CarEntity {
        val car = CarEntity(
            name = options.name,
            color = options.color,
            mileage = options.mileage,
            user = currentUser
        )
        car.addInitialTask()
        return repository.save(car)
    }
}
