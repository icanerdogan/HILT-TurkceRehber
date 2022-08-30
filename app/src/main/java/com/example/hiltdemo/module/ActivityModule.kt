package com.example.hiltdemo.module

import com.example.hiltdemo.CarFunctions
import com.example.hiltdemo.CarFunctionsImpl
import com.example.hiltdemo.repository.CarRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @Provides
    fun provideCarRepository(): CarRepository {
        return CarRepository()
    }

    @Provides
    fun provideCarFunctionsImpl(carRepository: CarRepository): CarFunctions {
        return CarFunctionsImpl(carRepository)
    }

    /*
    @Binds
    abstract fun bindCarFunction(carFunctionsImpl: CarFunctionsImpl): CarFunctions
    */
}
