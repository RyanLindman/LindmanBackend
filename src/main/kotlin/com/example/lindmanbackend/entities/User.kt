package com.example.lindmanbackend.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(length = 30, nullable = false)
    private var username: String,

    @Column(nullable = false, unique = true)
    private var email: String,

    @Column(nullable = false)
    private var password: String,


    ) {
}