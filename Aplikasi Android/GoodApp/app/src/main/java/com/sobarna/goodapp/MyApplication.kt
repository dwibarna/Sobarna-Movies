package com.sobarna.goodapp

import android.app.Application
import com.sobarna.goodapp.core.di.CoreComponent
import com.sobarna.goodapp.core.di.DaggerCoreComponent
import com.sobarna.goodapp.di.AppComponent
import com.sobarna.goodapp.di.DaggerAppComponent

open class MyApplication: Application() {

    private val coreComponent : CoreComponent by lazy {
        DaggerCoreComponent
            .factory()
            .create(applicationContext)
    }

    val appComponent:AppComponent by lazy {
        DaggerAppComponent
            .factory()
            .create(coreComponent)
    }

}