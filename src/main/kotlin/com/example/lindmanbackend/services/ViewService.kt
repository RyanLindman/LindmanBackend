package com.example.lindmanbackend.services

import com.example.lindmanbackend.entities.user.User
import com.example.lindmanbackend.entities.view.View
import com.example.lindmanbackend.entities.view.dto.ResponseFormat
import com.example.lindmanbackend.entities.view.dto.ViewDto
import com.example.lindmanbackend.repositories.UserRepo
import com.example.lindmanbackend.repositories.ViewRepo
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import kotlin.IllegalArgumentException

@Service
class ViewService(
    private val viewRepo: ViewRepo,
    private val userService: UserService,
    private val userRepo: UserRepo
) {
    fun getAllViews(): List<View> {
        return viewRepo.findAll()
    }

    fun getViewById(id: Long): View? {
        return viewRepo.findById(id).orElse(null)
    }

    fun getViewResponse(viewId: Long): ResponseFormat {
        val view = viewRepo.findById(viewId)
            .orElseThrow { NoSuchElementException("View not found with id: $viewId") }

        // Constructing the ResponseFormat
        return ResponseFormat(
            id = view.getId(),
            name = view.name,
            title = view.title,
            content = view.content ?: "",
        )
    }

    fun convertDtoToEntity(viewDto: ViewDto): View {
        return View(
            name = viewDto.name.toString(),
            title = viewDto.title.toString(),
            content = viewDto.content
        )
    }

    fun convertEntityToDto(view: View): ViewDto {
        return ViewDto(
            name = view.name,
            title = view.title,
            content = view.content
        )
    }

    fun createView(viewDto: ViewDto): View {
        val view = View(
            name = viewDto.name.toString(),
            title = viewDto.title.toString(),
            content = viewDto.content
        )
        return viewRepo.save(view)
    }


    fun updateView(id: Long): View {

        return viewRepo.save(existingView)
    }

    fun deleteViewById(id: Long) {
        if (viewRepo.existsById(id)) {
            viewRepo.deleteById(id)
        } else {
            throw IllegalArgumentException("View with id $id does not exist")
        }
    }


}