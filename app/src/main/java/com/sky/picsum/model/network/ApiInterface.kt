package com.sky.picsum.model.network

import com.sky.picsum.model.Abc
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiInterface {

    @GET("/v2/list?page=10&limit=20")
    fun getPicsum(@QueryMap map: Map<String, Any>): Call<Abc>


}