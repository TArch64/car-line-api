package ua.tarch64.carlineapi.cars.entities

import org.hibernate.annotations.GenericGenerator
import ua.tarch64.carlineapi.tasks.entities.TaskEntity
import ua.tarch64.carlineapi.tasks.enums.TaskStatus
import ua.tarch64.carlineapi.users.entities.UserEntity
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.PositiveOrZero

@Entity
@Table(name = "cars")
@Suppress("DataClassEqualsAndHashCodeInspection")
data class CarEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false, length = 100)
    val name: String,

    @Column(nullable = false, length = 25)
    val color: String,

    @Column(nullable = false)
    val mileage: Int,

    @OneToMany(
        targetEntity = TaskEntity::class,
        mappedBy = "car",
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY
    )
    val tasks: MutableList<TaskEntity> = mutableListOf(),

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    val user: UserEntity
) {
    constructor(user: UserEntity, options: CarOptions) : this(
        name = options.name,
        color = options.color,
        mileage = options.mileage,
        user = user
    )

    data class CarOptions(
        @NotBlank
        val name: String,
        @NotBlank
        val color: String,
        @NotNull
        @PositiveOrZero
        val mileage: Int
    )

    fun addInitialTask() {
        val task = TaskEntity(
            name = "Welcome to the app",
            status = TaskStatus.DONE,
            onMileage = mileage,
            repeat = null,
            car = this
        )
        tasks.add(task)
    }

    fun copy(options: CarOptions): CarEntity {
        return copy(
            name = options.name,
            color = options.color,
            mileage = options.mileage
        )
    }
}
