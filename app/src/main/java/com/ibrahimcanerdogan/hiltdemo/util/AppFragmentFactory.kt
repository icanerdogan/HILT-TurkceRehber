package com.ibrahimcanerdogan.hiltdemo.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.ibrahimcanerdogan.hiltdemo.HomeFragment
import com.ibrahimcanerdogan.hiltdemo.qualifier.ApiKey
import com.ibrahimcanerdogan.hiltdemo.qualifier.DatabaseName
import com.ibrahimcanerdogan.hiltdemo.ui.MainFragment
import javax.inject.Inject


class AppFragmentFactory @Inject constructor(
    @DatabaseName private val databaseName: String,
    @ApiKey private val apiKey: String
): FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className) {
            MainFragment::class.java.name -> {
                MainFragment(databaseName)
            }
            HomeFragment::class.java.name -> {
                HomeFragment(apiKey)
            }
            else -> super.instantiate(classLoader, className)
        }
    }

}