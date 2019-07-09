package com.example.mvvmpractice.Models

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class PlacesRepository (private val placeDAO: PlaceDAO){

    companion object {
        @Volatile private var instance: PlacesRepository? = null

        fun getInstance(placeDAO: PlaceDAO) = instance?: synchronized(this) {
            instance?: PlacesRepository(placeDAO).also { instance = it }
        }
    }

    fun addPlace(place: Place) {
        placeDAO.addplace(place)
    }

  //  fun getCurrentPlace() = placeDAO.getNextPlace()

    fun getPlaces() = placeDAO.getPlaces()


}