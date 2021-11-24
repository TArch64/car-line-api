package ua.tarch64.carlineapi.cars.services

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
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

    @Transactional
    fun addCar(options: CarEntity.Options): CarEntity {
        val car = CarEntity(currentUser, options).apply { addInitialTask() }
        return repository.save(car)
    }

    @Transactional
    fun updateCar(carId: UUID, options: CarEntity.Options) {
        val car = repository.getById(carId).copy(options)
        repository.save(car)
    }

    @Transactional
    fun deleteCar(carId: UUID) {
        repository.deleteById(carId)
    }
}
