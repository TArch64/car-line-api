package ua.tarch64.carlineapi.tasks.entities

import org.hibernate.annotations.GenericGenerator
import ua.tarch64.carlineapi.cars.entities.CarEntity
import ua.tarch64.carlineapi.tasks.enums.TaskStatus
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "tasks")
data class TaskEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false, length = 100)
    val name: String,

    @Column(nullable = true)
    val repeat: Int?,

    @Enumerated
    @Column(nullable = false)
    val status: TaskStatus,

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    val car: CarEntity
)
