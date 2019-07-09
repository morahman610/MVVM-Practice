package com.example.mvvmpractice.ViewModels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.mvvmpractice.Models.Place
import com.example.mvvmpractice.Models.PlacesRepository

class MainActivityViewModel(val placesRepository: PlacesRepository) : ViewModel() {


    fun getPlaces() : LiveData<List<Place>> {
        return placesRepository.getPlaces()
    }

    fun addPlace(place: Place) {
        placesRepository.addPlace(place)
    }
}