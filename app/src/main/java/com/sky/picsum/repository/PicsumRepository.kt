package com.sky.picsum.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sky.picsum.model.Abc
import com.sky.picsum.model.network.ApiClient
import com.sky.picsum.model.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PicsumRepository {
    private var apiInterface: ApiInterface? = null


    fun getPicsumApis( page:String,  limit:String):MutableLiveData<Abc>{
        val mutableLiveData=MutableLiveData<Abc>()
        var map =HashMap<String,Any>()
        map.put("page",page)
        map.put("limit",limit)
        apiInterface=ApiClient.clientAuthentication!!.create(ApiInterface::class.java)
        apiInterface!!.getPicsum(map).enqueue(object :Callback<Abc>{
            override fun onResponse(call: Call<Abc>, response: Response<Abc>) {
                TODO("Not yet implemented")
                mutableLiveData.value=response.body();
            }

            override fun onFailure(call: Call<Abc>, t: Throwable) {
                TODO("Not yet implemented")
                mutableLiveData.value=null
            }
        })

        return mutableLiveData;

    }
}