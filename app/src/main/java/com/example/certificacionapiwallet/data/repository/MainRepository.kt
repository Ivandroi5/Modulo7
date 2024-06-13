package com.example.certificacionapiwallet.data.repository

import com.example.certificacionapiwallet.data.model.User

interface MainRepository {
    suspend fun fetchUsers(): MutableList<User>
}