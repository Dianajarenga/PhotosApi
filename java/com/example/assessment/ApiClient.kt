package com.example.assessment

import com.example.assessment.ApiClient.retrofit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

        var retrofit = Retrofit.Builder()
            .baseUrl("<your base url goes here>")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun <T> buildApiClient(apiInterface: Class<T>): T{return retrofit.create(apiInterface)}
