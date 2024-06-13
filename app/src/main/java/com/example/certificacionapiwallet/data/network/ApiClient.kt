package com.example.certificacionapiwallet.data.network

import com.example.certificacionapiwallet.data.network.response.UserResponse
import retrofit2.http.GET

interface ApiClient {
    @GET("wallet")
    suspend fun getAllUser(): UserResponse

}