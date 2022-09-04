package com.ibrahimcanerdogan.hiltdemo.util

import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import javax.inject.Singleton

@FragmentScoped
class Car @Inject constructor(val battery: Battery){

    fun getCareName(): String {
        return "This car name is Toyota!"
    }

    fun getBatterySize(): String {
        return "The battery size is ${battery.getBatterySize()}"
    }
}