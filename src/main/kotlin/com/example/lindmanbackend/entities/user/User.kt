package com.example.lindmanbackend.entities.user

import com.example.lindmanbackend.entities.view.View
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,


    @Column(length = 30, nullable = false, unique = true)
    val username: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val password: String,

    @Transient
    val confirmPassword: String,

    @OneToMany
    var views: List<View> = mutableListOf()
    ) {
    fun getId(): Long? {
        return id
    }

}