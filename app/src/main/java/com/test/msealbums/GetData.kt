package com.test.msealbums

import retrofit2.Call
import retrofit2.http.GET

interface GetData {
    @get:GET("/albums")
    val allUsers: Call<List<Album>>
}
