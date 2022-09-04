package com.ibrahimcanerdogan.hiltdemo

import com.ibrahimcanerdogan.hiltdemo.repository.CarRepository
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CarFunctionsImpl @Inject constructor(private val carRepository: CarRepository): CarFunctions {
    override fun doDrive(): String {
        return "Car can drive!"
    }

    fun insert(): Int {
        return carRepository.addRow()
    }
}