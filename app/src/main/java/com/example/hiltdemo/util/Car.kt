package com.example.hiltdemo.util

import javax.inject.Inject

class Car @Inject constructor(val battery: Battery){

    fun getCareName(): String {
        return "This car name is Toyota!"
    }

    fun getBatterySize(): String {
        return "The battery size is ${battery.getBatterySize()}"
    }
}