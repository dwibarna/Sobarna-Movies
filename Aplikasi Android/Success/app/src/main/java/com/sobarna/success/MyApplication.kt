package com.sobarna.success

import android.app.Application
import com.sobarna.success.core.di.CoreComponent
import com.sobarna.success.core.di.DaggerCoreComponent
import com.sobarna.success.di.AppComponent
import com.sobarna.success.di.DaggerAppComponent

open class MyApplication : Application() {


    private val coreComponent:CoreComponent by lazy{
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}