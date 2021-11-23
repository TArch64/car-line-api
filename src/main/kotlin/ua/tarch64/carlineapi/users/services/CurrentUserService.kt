package ua.tarch64.carlineapi.users.services

import org.springframework.stereotype.Service
import ua.tarch64.carlineapi.users.entities.UserEntity
import ua.tarch64.carlineapi.users.repositories.UserRepository

@Service
class CurrentUserService(private val repository: UserRepository) {
    fun fetchCurrentUser(): UserEntity {
        return repository.findAll().first()
    }
}
