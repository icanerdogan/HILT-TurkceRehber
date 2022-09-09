package com.ibrahimcanerdogan.hiltdemo.repository

import com.ibrahimcanerdogan.hiltdemo.qualifier.DatabaseName
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl(@DatabaseName private val databaseName: String): UserRepository {

    override fun getDatabaseName(): String {
        return databaseName
    }

    override fun getUserList(): List<String> {
        return listOf("Ibrahim", "Can", "Erdogan")
    }

}