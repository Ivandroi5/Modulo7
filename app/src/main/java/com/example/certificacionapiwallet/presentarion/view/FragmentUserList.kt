package com.example.certificacionapiwallet.presentarion.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.certificacionapiwallet.UserListAdpater
import com.example.certificacionapiwallet.data.repository.MainRepositoryImpl
import com.example.certificacionapiwallet.databinding.FragmentUserListBinding
import com.example.certificacionapiwallet.domain.UseCase
import com.example.certificacionapiwallet.presentarion.viewmodel.MainViewModel
import com.example.certificacionapiwallet.presentarion.viewmodel.ViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class FragmentUserList : Fragment() {
    private lateinit var binding: FragmentUserListBinding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val repository: MainRepositoryImpl = MainRepositoryImpl()
        val userUseCase: UseCase=UseCase(repository)
        val viewModelFactory = ViewModelFactory(userUseCase)
        val mainViewModel = ViewModelProvider(requireActivity(), viewModelFactory)
            .get(MainViewModel::class.java)

        binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root

    }



        private fun showError() {
            Toast.makeText(requireContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
        }
//
    }


