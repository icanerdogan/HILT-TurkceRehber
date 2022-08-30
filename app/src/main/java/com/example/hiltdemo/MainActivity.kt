package com.example.hiltdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.hiltdemo.repository.CarRepository
import com.example.hiltdemo.util.Car
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    @Inject
    lateinit var car: Car
    @Inject
    lateinit var carFunctions: CarFunctionsImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = car.getCareName()
        val batterySize = car.getBatterySize()
        val carFun = carFunctions.doDrive()
        val addResult = carFunctions.insert()

        Log.d(TAG, name)
        Log.d(TAG, batterySize)
        Log.d(TAG, carFun)
        Log.d(TAG, addResult.toString())
    }
}