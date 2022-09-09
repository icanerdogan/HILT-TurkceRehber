package com.ibrahimcanerdogan.hiltdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ibrahimcanerdogan.hiltdemo.ui.MainFragment
import com.ibrahimcanerdogan.hiltdemo.util.AppFragmentFactory
import com.ibrahimcanerdogan.hiltdemo.util.Car
import com.ibrahimcanerdogan.hiltdemo.util.DatabaseService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    /*
    @Inject
    lateinit var car: Car
    */
    @Inject
    lateinit var carFunctions: CarFunctionsImpl

    @Inject
    lateinit var databaseService: DatabaseService

    @Inject
    lateinit var appFragmentFactory: AppFragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // val name = car.getCareName()
        // val batterySize = car.getBatterySize()
        val carFun = carFunctions.doDrive()
        val addResult = carFunctions.insert()

        // Log.d(TAG, name)
        // Log.d(TAG, batterySize)
        Log.d(TAG, carFun)
        Log.d(TAG, addResult.toString())

        /*MainActivity ve activity_main içine Home ve Main Fragment eklenmesi!*/
        supportFragmentManager.fragmentFactory = appFragmentFactory
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, MainFragment::class.java, null)
            .commit()
    }
}