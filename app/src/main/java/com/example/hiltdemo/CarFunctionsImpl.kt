package com.example.hiltdemo

import javax.inject.Inject

class CarFunctionsImpl @Inject constructor(): CarFunctions {
    override fun doDrive(): String {
        return "Car can drive!"
    }
}