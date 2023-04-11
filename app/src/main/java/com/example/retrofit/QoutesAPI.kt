package com.example.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QoutesAPI {

    @GET("/quotes")
    suspend fun getQoutes(@Query("page") page:Int): Response<QouteList>
}