package com.example.mvvmpractice.ViewModels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.mvvmpractice.Models.PlacesRepository

class ViewModelFactory(private val placesRepository: PlacesRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(placesRepository) as T
    }
}