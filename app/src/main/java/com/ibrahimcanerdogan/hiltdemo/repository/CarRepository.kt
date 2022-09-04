package com.ibrahimcanerdogan.hiltdemo.repository

import com.ibrahimcanerdogan.hiltdemo.qualifier.ApiKey
import com.ibrahimcanerdogan.hiltdemo.qualifier.DatabaseName
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CarRepository @Inject constructor(
    @DatabaseName private val databaseName: String,
    @ApiKey private val apiKey: String
) {

    fun addRow(): Int {
        return 101
    }

    fun getDatabaseName(): String {
        return databaseName
    }

    fun getApiKey(): String {
        return apiKey
    }
}