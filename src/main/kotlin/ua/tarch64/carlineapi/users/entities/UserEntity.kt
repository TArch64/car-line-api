package ua.tarch64.carlineapi.users.entities

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val name: String
)
