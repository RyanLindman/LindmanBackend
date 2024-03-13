package com.example.lindmanbackend.controllers

import com.example.lindmanbackend.entities.View
import com.example.lindmanbackend.services.ViewService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class ViewController(private val viewService: ViewService) {

    @GetMapping("/views")
    @ResponseBody

    fun getAllViews(): List<View> {
        return viewService.getAllViews()
    }

}