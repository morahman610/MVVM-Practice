package com.example.mvvmpractice.Models

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

class PlaceDAO {
    private val placeList = mutableListOf<Place>()
    private val places = MutableLiveData<List<Place>>()
    private var currentPlacePosition = MutableLiveData<Int>()

    init {
        placeList.add(Place("United States", "The U.S. is a country of 50 ehe Pacific Ocean."))
        placeList.add(Place("Italy", "Italy, a Eurl mae and cuisine. "))
        placeList.add(Place("Japan", "Japan is an island country in East Asia. Located in the Pacific Ocean, it lies off the "))
        placeList.add(Place("Morocco", "Morocco, guished by its Berber, Arabian and European cultural influences. "))
        places.value = placeList
    }

    fun addplace(place: Place) {
        placeList.add(place)
        places.value = placeList
    }

    fun getPlaces() = places as LiveData<List<Place>>

 /*   fun getNextPlace() {
        if(currentPlacePosition != null) {
            currentPlacePosition.value++

        }
    } */
}