package com.example.lindmanbackend.services

import com.example.lindmanbackend.entities.User
import com.example.lindmanbackend.entities.dto.UserDto
import com.example.lindmanbackend.repositories.UserRepo
import lombok.extern.java.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.util.NoSuchElementException
import java.util.Optional

@Service
class UserService @Autowired constructor(
    private val userRepo: UserRepo,
    private val passwordEncoder: BCryptPasswordEncoder,
) {

    fun getUserById(id: Long): User? {
        val user: Optional<User> = userRepo.findById(id)
        return user.orElseThrow { NoSuchElementException("User not found with ID: $id") }


    }

    fun createUser(userDto: UserDto): User {

        validatePassword(userDto.password, userDto.confirmPassword)

        val hashedPassword = passwordEncoder.encode(userDto.password)
        val user = User(email = userDto.email, username = userDto.username, password = hashedPassword, confirmPassword = userDto.confirmPassword)



        return userRepo.save(user)
    }

    private fun validatePassword(password: String, confirmPassword: String) {
        if (password !== confirmPassword){
            throw IllegalArgumentException("Passwords do not match")
        }
    }

}


