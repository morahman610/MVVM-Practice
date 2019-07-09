package com.example.mvvmpractice.Utilities

import com.example.mvvmpractice.Models.MockDatabase
import com.example.mvvmpractice.Models.PlacesRepository
import com.example.mvvmpractice.ViewModels.ViewModelFactory

object InjectorUtils {

    fun providePlacesViewModelFactory() : ViewModelFactory {

        val placesRepository = PlacesRepository(MockDatabase.getInstance().placeDAO)
        return ViewModelFactory(placesRepository)
    }
}