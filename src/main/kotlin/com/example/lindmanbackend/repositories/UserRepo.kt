package com.example.lindmanbackend.repositories

import com.example.lindmanbackend.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepo : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
    fun findByUsername(username: String): User?

    override fun findById(id: Long): Optional<User>
}

