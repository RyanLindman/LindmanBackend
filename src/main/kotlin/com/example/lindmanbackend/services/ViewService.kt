package com.example.lindmanbackend.services

import com.example.lindmanbackend.entities.View
import com.example.lindmanbackend.repositories.ViewRepo
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class ViewService(private val viewRepo: ViewRepo) {
    fun getAllViews(): List<View> {
        return viewRepo.findAll()
    }

    fun getViewById(id: Long): View? {
        return viewRepo.findById(id).orElse(null)
    }

    fun createView(view: View): View {
        return viewRepo.save(view)
    }

    fun updateView(view: View): View {
        if (viewRepo.existsById(view.getId())) {
            return viewRepo.save(view)
        } else {
            throw IllegalArgumentException("View with ID: ${view.getId()} does not exist")
        }
    }

    fun deleteViewById(id: Long) {
        if (viewRepo.existsById(id)) {
            viewRepo.deleteById(id)
        } else {
            throw IllegalArgumentException("View with id $id does not exist")
        }
    }




}