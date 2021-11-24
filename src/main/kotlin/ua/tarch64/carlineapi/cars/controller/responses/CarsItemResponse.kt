package ua.tarch64.carlineapi.cars.controller.responses

import ua.tarch64.carlineapi.cars.entities.CarEntity
import java.util.*

data class CarsItemResponse(
    val id: UUID,
    val name: String,
    val color: String
) {
    companion object {
        fun fromEntity(entity: CarEntity): CarsItemResponse {
            return CarsItemResponse(entity.id, entity.name, entity.color)
        }
    }
}
