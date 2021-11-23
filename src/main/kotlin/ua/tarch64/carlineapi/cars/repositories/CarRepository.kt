package ua.tarch64.carlineapi.cars.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ua.tarch64.carlineapi.cars.entities.CarEntity
import java.util.*

@Repository
interface CarRepository: JpaRepository<CarEntity, UUID>
