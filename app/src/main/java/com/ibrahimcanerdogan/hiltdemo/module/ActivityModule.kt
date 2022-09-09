package com.ibrahimcanerdogan.hiltdemo.module

import android.content.Context
import com.ibrahimcanerdogan.hiltdemo.CarFunctions
import com.ibrahimcanerdogan.hiltdemo.CarFunctionsImpl
import com.ibrahimcanerdogan.hiltdemo.qualifier.ApiKey
import com.ibrahimcanerdogan.hiltdemo.qualifier.DatabaseName
import com.ibrahimcanerdogan.hiltdemo.repository.CarRepository
import com.ibrahimcanerdogan.hiltdemo.util.DatabaseService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @ActivityScoped
    @Provides
    fun provideCarRepository(@DatabaseName databaseName: String,@ApiKey apiKey: String): CarRepository {
        return CarRepository(databaseName, apiKey)
    }

    @ActivityScoped
    @Provides
    fun provideCarFunctionsImpl(carRepository: CarRepository): CarFunctions {
        return CarFunctionsImpl(carRepository)
    }

/*    @ActivityScoped
    @Provides
    fun provideDatabaseService(@ActivityContext context: Context): DatabaseService {
        return DatabaseService(context)
    }*/
    /*
    @Binds
    abstract fun bindCarFunction(carFunctionsImpl: CarFunctionsImpl): CarFunctions
    */
}
