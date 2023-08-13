package com.dicoding.mysimplelogin.di

import android.content.Context
import com.dicoding.mysimplelogin.HomeActivity
import com.dicoding.mysimplelogin.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class]) // `@Component` used to list which Module to use on Dagger
interface AppComponent { // `AppComponent` uses `@Singleton` because `StorageModule` is "singleton"
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent // `@BindsInstance` to inject `Context` in every Module that needed
    }

    fun inject(activity: MainActivity) // function to inject on MainActivity
    fun inject(activity: HomeActivity) // function to inject on HomeActivity
}