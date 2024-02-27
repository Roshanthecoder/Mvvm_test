package com.example.test.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.test.repository.MainRepository
import com.example.test.viewmodel.MainViewmodel
import com.example.test.viewmodel.SecondaryViewmodel

class MainViewmodelFactory(private val repository: MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewmodel::class.java)) {
            return MainViewmodel(repository) as T
        } else if (modelClass.isAssignableFrom(SecondaryViewmodel::class.java)) {
            return SecondaryViewmodel(repository) as T
        }
        throw IllegalArgumentException("Unknown Exception from Viewmodel")

    }
}