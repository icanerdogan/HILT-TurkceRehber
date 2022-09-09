package com.ibrahimcanerdogan.hiltdemo.module

import android.content.Context
import com.ibrahimcanerdogan.hiltdemo.qualifier.ApiKey
import com.ibrahimcanerdogan.hiltdemo.qualifier.DatabaseName
import com.ibrahimcanerdogan.hiltdemo.repository.UserRepositoryImpl
import com.ibrahimcanerdogan.hiltdemo.util.DatabaseService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Singleton
    @DatabaseName
    @Provides
    fun provideDatabaseName(): String {
        return "local.db"
    }

    @Singleton
    @ApiKey
    @Provides
    fun provideApiKey(): String {
        return "zaCELgL.0imfnc8mVLWwsAawjYr4Rx-Af50DDqtlx"
    }

    @Singleton
    @Provides
    fun provideDatabaseService(@ApplicationContext context: Context): DatabaseService {
        return DatabaseService(context)
    }

    @Singleton
    @Provides
    fun provideUserRepository(@DatabaseName databaseName: String): UserRepositoryImpl {
        return UserRepositoryImpl(databaseName)
    }
}