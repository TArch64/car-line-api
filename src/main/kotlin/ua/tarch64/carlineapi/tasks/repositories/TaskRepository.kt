package ua.tarch64.carlineapi.tasks.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ua.tarch64.carlineapi.tasks.entities.TaskEntity
import java.util.*

@Repository
interface TaskRepository: JpaRepository<TaskEntity, UUID>
