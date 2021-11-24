package ua.tarch64.carlineapi.tasks.services

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ua.tarch64.carlineapi.cars.services.CarService
import ua.tarch64.carlineapi.tasks.entities.TaskEntity
import ua.tarch64.carlineapi.tasks.repositories.TaskRepository
import java.util.*

@Service
class TaskService(
    private val repository: TaskRepository,
    private val carService: CarService
) {
    @Transactional
    fun addTask(carId: UUID, options: TaskEntity.TaskOptions): TaskEntity {
        val task = TaskEntity(carService.getCar(carId)!!, options)
        return repository.save(task)
    }

    @Transactional
    fun deleteTask(taskId: UUID) {
        repository.deleteById(taskId)
    }

    @Transactional
    fun updateTask(taskId: UUID, options: TaskEntity.TaskOptions) {
        val task = repository.getById(taskId).copy(options)
        repository.save(task)
    }
}
