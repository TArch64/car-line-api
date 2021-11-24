package ua.tarch64.carlineapi.users.services

import org.springframework.stereotype.Service
import ua.tarch64.carlineapi.users.entities.UserEntity
import ua.tarch64.carlineapi.users.repositories.UserRepository

@Service
class UserService(private val repository: UserRepository) {
    fun addUser(options: UserEntity.UserOptions): UserEntity {
        val user = UserEntity(options)
        return repository.save(user)
    }
}
