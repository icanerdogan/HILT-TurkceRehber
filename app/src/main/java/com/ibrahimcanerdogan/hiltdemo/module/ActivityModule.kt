package com.ibrahimcanerdogan.hiltdemo.module

import com.ibrahimcanerdogan.hiltdemo.CarFunctions
import com.ibrahimcanerdogan.hiltdemo.CarFunctionsImpl
import com.ibrahimcanerdogan.hiltdemo.qualifier.ApiKey
import com.ibrahimcanerdogan.hiltdemo.qualifier.DatabaseName
import com.ibrahimcanerdogan.hiltdemo.repository.CarRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @Provides
    fun provideCarRepository(@DatabaseName databaseName: String,@ApiKey apiKey: String): CarRepository {
        return CarRepository(databaseName, apiKey)
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
