package com.example.mvvmpractice.Models

class MockDatabase private constructor(){

    val placeDAO = PlaceDAO()


    companion object {
        @Volatile private var instance: MockDatabase? = null

        fun getInstance() = instance?: synchronized(this) {
            instance?: MockDatabase().also { instance = it }
        }
    }

}