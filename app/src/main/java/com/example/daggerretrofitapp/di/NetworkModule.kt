package com.example.daggerretrofitapp.di

import com.example.daggerretrofitapp.api.ApiUser
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {
    @Provides
    fun provideApiUser(): ApiUser {
        val retrofitService = Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofitService.create(ApiUser::class.java)
    }
}