package com.example.daggerretrofitapp.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiUser {
    //https://randomuser.me/api/?results=20
    @GET("api/")
    fun getUsers(
        @Query("results") results: Int
    ): Call<UserResponse>
}