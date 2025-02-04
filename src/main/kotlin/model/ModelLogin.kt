package model

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val user: String,
    val passwd: String
)

@Serializable
data class LoginResponse(
    val id_empleado: Int,
    val id_gestor: Int,
    val nombre: String,
    val email: String
)
