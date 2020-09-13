package com.sky.picsum.repository

import androidx.lifecycle.MutableLiveData
import com.sky.picsum.model.PicsumResponse
import com.sky.picsum.model.network.ApiClient
import com.sky.picsum.model.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PicsumRepository {
    private var apiInterface: ApiInterface? = null


    fun getPicsumApis( page:Int,  limit:Int):MutableLiveData<PicsumResponse>{
        val mutableLiveData=MutableLiveData<PicsumResponse>()
        var map =HashMap<String,Int>()
        map.put("page",page)
        map.put("limit",limit)
        apiInterface=ApiClient.clientAuthentication!!.create(ApiInterface::class.java)
        apiInterface!!.getPicsum(map).enqueue(object :Callback<PicsumResponse>{
            override fun onResponse(call: Call<PicsumResponse>, response: Response<PicsumResponse>) {
                mutableLiveData.value=response.body();
            }

            override fun onFailure(call: Call<PicsumResponse>, t: Throwable) {
                mutableLiveData.value=null
            }
        })

        return mutableLiveData;

    }
}