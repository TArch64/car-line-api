package ua.tarch64.carlineapi.tasks.controllers

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ua.tarch64.carlineapi.tasks.controllers.responses.TaskResponse
import ua.tarch64.carlineapi.tasks.entities.TaskEntity
import ua.tarch64.carlineapi.tasks.services.TaskService
import java.util.*

@RestController
@RequestMapping()
class TaskController(private val taskService: TaskService) {
    @PostMapping("/cars/{carId}/tasks")
    fun addTask(
        @PathVariable carId: UUID,
        @Validated @RequestBody options: TaskEntity.TaskOptions
    ): TaskResponse {
        return taskService.addTask(carId, options).let(TaskResponse::fromEntity)
    }

    @DeleteMapping("/tasks/{taskId}")
    fun deleteTask(@PathVariable taskId: UUID) {
        taskService.deleteTask(taskId)
    }

    @PutMapping("/tasks/{taskId}")
    fun updateTask(
        @PathVariable taskId: UUID,
        @Validated @RequestBody options: TaskEntity.TaskOptions
    ) {
        taskService.updateTask(taskId, options)
    }
}
