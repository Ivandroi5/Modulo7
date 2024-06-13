package com.example.certificacionapiwallet.presentarion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.certificacionapiwallet.domain.UseCase


class ViewModelFactory(private val userUseCase: UseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(userUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}