package ua.tarch64.carlineapi.users.controllers

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ua.tarch64.carlineapi.users.controllers.responses.UserResponse
import ua.tarch64.carlineapi.users.entities.UserEntity
import ua.tarch64.carlineapi.users.services.CurrentUserService
import ua.tarch64.carlineapi.users.services.UserService

@RestController
@RequestMapping("/users")
class UserController(
    private val currentUserService: CurrentUserService,
    private val userService: UserService
) {
    @GetMapping("/me")
    fun getCurrentUser(): UserResponse {
        return currentUserService.fetchCurrentUser().let(UserResponse::fromEntity)
    }

    @PostMapping
    fun addUser(@Validated @RequestBody options: UserEntity.UserOptions): UserResponse {
        return userService.addUser(options).let(UserResponse::fromEntity)
    }
}
