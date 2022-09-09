package com.ibrahimcanerdogan.hiltdemo.util

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DatabaseService @Inject constructor(@ApplicationContext context: Context) {

}