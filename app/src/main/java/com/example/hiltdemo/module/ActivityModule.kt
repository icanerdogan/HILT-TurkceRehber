package com.example.hiltdemo.module

import com.example.hiltdemo.CarFunctions
import com.example.hiltdemo.CarFunctionsImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class ActivityModule {

    @Binds
    abstract fun bindCarFunction(carFunctionsImpl: CarFunctionsImpl): CarFunctions
}
