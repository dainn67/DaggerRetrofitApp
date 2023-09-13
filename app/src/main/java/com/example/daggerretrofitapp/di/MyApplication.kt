package com.example.daggerretrofitapp.di

import android.app.Application

class MyApplication: Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().build()
    }
}