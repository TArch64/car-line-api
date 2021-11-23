package ua.tarch64.carlineapi.users.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ua.tarch64.carlineapi.users.entities.UserEntity
import java.util.*

@Repository
interface UserRepository: JpaRepository<UserEntity, UUID>
