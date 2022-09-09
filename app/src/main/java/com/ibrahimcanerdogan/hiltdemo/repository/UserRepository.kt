package com.ibrahimcanerdogan.hiltdemo.repository

interface UserRepository {

    fun getDatabaseName(): String

    fun getUserList(): List<String>
}