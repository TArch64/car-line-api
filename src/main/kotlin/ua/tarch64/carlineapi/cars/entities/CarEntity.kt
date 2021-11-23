package ua.tarch64.carlineapi.cars.entities

import org.hibernate.annotations.GenericGenerator
import ua.tarch64.carlineapi.tasks.entities.TaskEntity
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "cars")
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
    val tasks: List<TaskEntity>
)
