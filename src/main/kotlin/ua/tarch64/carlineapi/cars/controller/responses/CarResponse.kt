package ua.tarch64.carlineapi.cars.controller.responses

import ua.tarch64.carlineapi.cars.entities.CarEntity
import ua.tarch64.carlineapi.tasks.controllers.responses.TaskResponse
import java.util.*

data class CarResponse(
    val id: UUID,
    val name: String,
    val color: String,
    val mileage: Int,
    val tasks: List<TaskResponse>
) {
    companion object {
        fun fromEntity(entity: CarEntity): CarResponse {
            return CarResponse(
                entity.id,
                entity.name,
                entity.color,
                entity.mileage,
                entity.tasks.map(TaskResponse::fromEntity)
            )
        }
    }
}
