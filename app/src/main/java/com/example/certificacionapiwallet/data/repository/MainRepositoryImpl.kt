package com.example.certificacionapiwallet.data.repository

import com.example.certificacionapiwallet.data.model.User
import com.example.certificacionapiwallet.data.network.ApiService
import com.example.certificacionapiwallet.data.network.response.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepositoryImpl: MainRepository {

    private var service = ApiService()

    override suspend fun fetchUsers(): MutableList<User> {
        return withContext(Dispatchers.IO) {
            val userResponse: UserResponse = service.getAllSismos()
            val userList = parserUsers(userResponse)
            userList
        }
    }

    private fun parserUsers(userResponse: UserResponse): MutableList<User> {
        val userList = mutableListOf<User>()
        val featureList = userResponse.feature

        for (feature in featureList) {
            val id = feature.id
            val nombre = feature.nombre
            val pais = feature.pais
            val imagenLink = feature.imagenLink
            val cuenta = feature.cuenta
            val saldo = feature.saldo
            val depositos = feature.depositos
        userList.add (User(id, nombre, pais, imagenLink, cuenta, saldo, depositos))
        }
        return userList
    }

}