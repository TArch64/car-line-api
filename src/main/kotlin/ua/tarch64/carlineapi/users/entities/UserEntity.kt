package ua.tarch64.carlineapi.users.entities

import org.hibernate.annotations.GenericGenerator
import ua.tarch64.carlineapi.cars.entities.CarEntity
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "users")
@Suppress("DataClassEqualsAndHashCodeInspection")
data class UserEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val name: String,

    @OneToMany(
        targetEntity = CarEntity::class,
        mappedBy = "user",
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY
    )
    val cars: List<CarEntity> = emptyList(),
) {
    constructor(options: UserOptions): this(name = options.name)

    data class UserOptions(
        @NotBlank
        val name: String
    )
}
