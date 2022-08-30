package com.example.hiltdemo.util

import javax.inject.Inject

class Battery @Inject constructor() {

    fun getBatterySize(): Int {
        return 12
    }
}