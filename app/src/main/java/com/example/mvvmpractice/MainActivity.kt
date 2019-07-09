package com.example.mvvmpractice

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.mvvmpractice.Models.Place
import com.example.mvvmpractice.Utilities.InjectorUtils
import com.example.mvvmpractice.ViewModels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
    }

    fun setupUI() {
        val factory = InjectorUtils.providePlacesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)
        var placePosition = 0

        viewModel.getPlaces().observe(this, Observer { places ->
            placeNameTxt.setText(places!![placePosition]._name)
            placeDescriptionTxt.setText(places!![placePosition]._description)
        })

        goBtn.setOnClickListener {
            placePosition++

        }

        viewModel.addPlace(Place("United States", "The U.S. is a country of 50 ehe Pacific Ocean."))
        viewModel.addPlace(Place("Italy", "Italy, a Eurl mae and cuisine. "))
        viewModel.addPlace(Place("Japan", "Japan is an island country in East Asia. Located in the Pacific Ocean, it lies off the "))
        viewModel.addPlace(Place("Morocco", "Morocco, guished by its Berber, Arabian and European cultural influences. "))
    }
}
