package com.example.certificacionapiwallet.presentarion.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.certificacionapiwallet.data.model.User
import com.example.certificacionapiwallet.domain.UseCase
import kotlinx.coroutines.launch

class MainViewModel (private val userUseCase: UseCase):ViewModel(){

    private val _userList = MutableLiveData<MutableList<User>>()


    val userListLV: LiveData<MutableList<User>>
        get() = _userList


    init{
        viewModelScope.launch {
            _userList.value = userUseCase.getAllEqForHour()
        }
    }


}