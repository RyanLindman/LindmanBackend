package com.example.lindmanbackend.controllers

import com.example.lindmanbackend.entities.view.View
import com.example.lindmanbackend.entities.view.dto.ViewDto
import com.example.lindmanbackend.entities.view.dto.ResponseFormat
import com.example.lindmanbackend.services.ViewService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("/api/v1/views")
class ViewController(private val viewService: ViewService) {

    @GetMapping("/all")
    @ResponseBody

    fun getAllViews(): List<View> {
        return viewService.getAllViews()
    }

    @PostMapping("/create")
    fun createView(@RequestBody request: ViewDto): ResponseEntity<ResponseFormat> {
        val view = viewService.createView(
            title = request.title,
            name = request.name
        )

        val response = ResponseFormat(
            id = view.getId(),
            name = view.name,
            title = view.title,
            content = view.content ?: "",
        )

        return ResponseEntity.ok(response)
    }
}