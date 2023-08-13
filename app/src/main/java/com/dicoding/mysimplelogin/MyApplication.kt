package com.dicoding.mysimplelogin

import android.app.Application
import com.dicoding.mysimplelogin.di.AppComponent
import com.dicoding.mysimplelogin.di.DaggerAppComponent

open class MyApplication: Application() { // custom Application to use Dagger in all classes
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create( // `DaggerAppComponent` is generated after `Build > Make Project`
            applicationContext
        )
    }
}