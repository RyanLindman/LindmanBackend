package com.example.lindmanbackend.entities.dto

data class UserDto (
    val email: String,
    val username: String,
    val password: String,
    val confirmPassword: String,
) {

}
