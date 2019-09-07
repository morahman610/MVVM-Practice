package com.example.mvvmpractice.ViewModels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.mvvmpractice.Models.Place
import com.example.mvvmpractice.Models.PlacesRepository

class MainActivityViewModel(val placesRepository: PlacesRepository) : ViewModel() {

    private val currentPlace = MutableLiveData<Place>()

    fun getPlace() : LiveData<Place> {
        val places = placesRepository.getPlaces().value

        if(currentPlace.value == null) {
            currentPlace.value = places?.get(1)
        }

        return currentPlace
    }

    fun changePlace(_currentPlace: Place) {
        val places = placesRepository.getPlaces().value
        currentPlace.value = places?.get(places.indexOf(_currentPlace) + 1)
    }

    fun addPlace(place: Place) {
        placesRepository.addPlace(place)
    }
}