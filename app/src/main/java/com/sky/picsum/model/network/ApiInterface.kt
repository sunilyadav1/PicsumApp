package com.sky.picsum.model.network

import com.sky.picsum.model.PicsumResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiInterface {

    @GET("/v2/list")
    fun getPicsum(@QueryMap map: Map<String, Int>): Call<PicsumResponse>


}