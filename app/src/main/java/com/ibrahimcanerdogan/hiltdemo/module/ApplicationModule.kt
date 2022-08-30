package com.ibrahimcanerdogan.hiltdemo.module

import com.ibrahimcanerdogan.hiltdemo.qualifier.ApiKey
import com.ibrahimcanerdogan.hiltdemo.qualifier.DatabaseName
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @DatabaseName
    @Provides
    fun provideDatabaseName(): String {
        return "local.db"
    }

    @ApiKey
    @Provides
    fun provideApiKey(): String {
        return "zaCELgL.0imfnc8mVLWwsAawjYr4Rx-Af50DDqtlx"
    }
}