package ua.tarch64.carlineapi.cars.services

import org.springframework.stereotype.Service
import ua.tarch64.carlineapi.cars.entities.CarEntity
import ua.tarch64.carlineapi.cars.repositories.CarRepository
import ua.tarch64.carlineapi.users.services.CurrentUserService

@Service
class CarService(
    private val repository: CarRepository,
    private val currentUserService: CurrentUserService
) {
    fun getCars(): List<CarEntity> {
        val user = currentUserService.fetchCurrentUser()
        return repository.findAllByUser(user)
    }
}
