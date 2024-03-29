package com.example.lindmanbackend.repositories

import com.example.lindmanbackend.entities.view.View
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ViewRepo : JpaRepository<View, Long> {
}



