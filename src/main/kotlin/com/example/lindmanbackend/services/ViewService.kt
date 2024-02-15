package com.example.lindmanbackend.services

import com.example.lindmanbackend.entities.View
import com.example.lindmanbackend.repositories.ViewRepo
import org.springframework.stereotype.Service

@Service
class ViewService (private val viewRepo: ViewRepo) {
    fun getAllViews(): List<View> {
        return viewRepo.findAll();
    }
}