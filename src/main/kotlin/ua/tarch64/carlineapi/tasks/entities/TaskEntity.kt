package ua.tarch64.carlineapi.tasks.entities

import org.hibernate.annotations.GenericGenerator
import ua.tarch64.carlineapi.cars.entities.CarEntity
import ua.tarch64.carlineapi.tasks.enums.TaskStatus
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tasks")
@Suppress("DataClassEqualsAndHashCodeInspection")
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

    @Column(nullable = true, name = "repeat")
    val repeatOn: Int?,

    @Column(nullable = false)
    val onMileage: Int,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val status: TaskStatus,

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    val car: CarEntity
) {
    constructor(car: CarEntity, options: TaskOptions): this(
        name = options.name,
        repeatOn = options.repeatOn,
        onMileage = options.onMileage,
        status = options.status,
        car = car
    )

    data class TaskOptions(
        @NotBlank
        val name: String,
        val repeatOn: Int?,
        @NotNull
        val onMileage: Int,
        @NotNull
        val status: TaskStatus,
    )

    fun copy(options: TaskOptions): TaskEntity {
        return copy(
            name = options.name,
            status = options.status,
            onMileage = options.onMileage,
            repeatOn = options.repeatOn
        )
    }
}
