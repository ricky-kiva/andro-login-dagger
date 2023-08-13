package com.dicoding.mysimplelogin.di

import android.content.Context
import com.dicoding.mysimplelogin.SessionManager
import dagger.Module
import dagger.Provides

@Module
class StorageModule { // `@Module` indicates the class is a module
    // `@Provides` to make instance of new object
    // Dagger don't care about the function name. just make sure the `return` value is the correct object
    @Provides
    fun provideSessionManager(context: Context): SessionManager = SessionManager(context) // make `SessionManager` object
}