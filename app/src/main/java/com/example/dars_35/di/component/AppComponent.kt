package com.example.dars_35.di.component

import com.example.dars_35.GalleryActivity
import com.example.dars_35.MainActivity
import com.example.dars_35.MyApp
import com.example.dars_35.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(app:MyApp)
    fun inject(activity: MainActivity)
    fun inject(activity: GalleryActivity)
}