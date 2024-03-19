package com.example.lindmanbackend.entities.user

data class UserDto (

    val email: String,
    val username: String,
    val password: String,
    val confirmPassword: String,
) {

}
