package com.test.msealbums

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://jsonplaceholder.typicode.com"


    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}
