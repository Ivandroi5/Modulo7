package com.example.certificacionapiwallet.domain

import com.example.certificacionapiwallet.data.model.User
import com.example.certificacionapiwallet.data.repository.MainRepository

class UseCase(private val repository: MainRepository) {

    suspend fun getAllEqForHour(): MutableList<User>{
        return repository.fetchUsers()
    }

}