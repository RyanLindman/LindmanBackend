package com.example.lindmanbackend.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
@Entity
class View(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    private val name: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        other as View
        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name)"
    }
}



