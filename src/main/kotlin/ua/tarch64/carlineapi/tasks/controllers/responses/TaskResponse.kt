package ua.tarch64.carlineapi.tasks.controllers.responses

import ua.tarch64.carlineapi.tasks.entities.TaskEntity
import ua.tarch64.carlineapi.tasks.enums.TaskStatus
import java.util.*

data class TaskResponse(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val repeat: Int?,
    val status: TaskStatus,
    val onMileage: Int
) {
    companion object {
        fun fromEntity(entity: TaskEntity): TaskResponse {
            return TaskResponse(
                entity.id,
                entity.name,
                entity.repeatOn,
                entity.status,
                entity.onMileage
            )
        }
    }
}
