package com.example.certificacionapiwallet.data.network

import com.example.certificacionapiwallet.domain.RetrofitHelper
import com.example.certificacionapiwallet.data.network.response.UserResponse

class ApiService {
    private val helperRetrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllSismos(): UserResponse {
        val response: UserResponse = helperRetrofit.create(ApiClient::class.java).getAllUser()
        return response
    }
}