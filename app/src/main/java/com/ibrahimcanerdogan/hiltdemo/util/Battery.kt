package com.ibrahimcanerdogan.hiltdemo.util

import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import javax.inject.Singleton

@FragmentScoped
class Battery @Inject constructor() {

    fun getBatterySize(): Int {
        return 12
    }
}