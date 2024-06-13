package com.example.certificacionapiwallet.data.model

import com.google.gson.annotations.SerializedName

data class User(
    val id: String,
    val nombre: String,
    val pais: String,
    val imagenLink: List<String>,
    val cuenta: String,
    val saldo: String,
    val depositos : Boolean
){}
