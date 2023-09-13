package com.example.daggerretrofitapp.di

import com.example.daggerretrofitapp.viewmodel.MyViewModel
import dagger.Component

@Component(modules = [NetworkModule::class])
interface AppComponent {

    //inject into viewModel
    fun injectActivity(viewModel: MyViewModel)
}