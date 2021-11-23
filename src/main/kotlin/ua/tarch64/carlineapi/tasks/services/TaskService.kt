package ua.tarch64.carlineapi.tasks.services

import org.springframework.stereotype.Service
import ua.tarch64.carlineapi.tasks.repositories.TaskRepository

@Service
class TaskService(private val repository: TaskRepository)
