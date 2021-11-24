package ua.tarch64.carlineapi.cars.controller.responses

import ua.tarch64.carlineapi.tasks.entities.TaskEntity
import ua.tarch64.carlineapi.tasks.enums.TaskStatus
import java.util.*

data class CarTaskResponse(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val repeat: Int?,
    val status: TaskStatus
) {
    companion object {
        fun fromEntity(entity: TaskEntity): CarTaskResponse {
            return CarTaskResponse(
                entity.id,
                entity.name,
                entity.repeat,
                entity.status
            )
        }
    }
}
