package ua.tarch64.carlineapi.users.controllers.responses

import ua.tarch64.carlineapi.cars.controller.responses.CarsItemResponse
import ua.tarch64.carlineapi.users.entities.UserEntity

data class UserResponse(
    val name: String,
    val cars: List<CarsItemResponse>
) {
    companion object {
        fun fromEntity(entity: UserEntity): UserResponse {
            return UserResponse(
                entity.name,
                entity.cars.map(CarsItemResponse::fromEntity)
            )
        }
    }
}
