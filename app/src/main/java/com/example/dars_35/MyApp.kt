package com.example.dars_35

import android.app.Application
import com.example.dars_35.di.component.AppComponent
import com.example.dars_35.di.component.DaggerAppComponent

class MyApp: Application() {

    companion object{
        lateinit var app:MyApp
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        app = this
        appComponent = DaggerAppComponent.builder().build()
        appComponent.inject(this)
    }
}