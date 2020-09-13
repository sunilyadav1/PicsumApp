package com.sky.picsum.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sky.picsum.model.PicsumResponse
import com.sky.picsum.repository.PicsumRepository

class PicsumViewModel : ViewModel() {
    lateinit var picsumRepository: PicsumRepository
    var mMutableLiveData=MutableLiveData<PicsumResponse>()

    fun getPicsumApi(page:Int,  limit:Int):LiveData<PicsumResponse>{
        picsumRepository= PicsumRepository()
       mMutableLiveData= picsumRepository.getPicsumApis(page,limit)

        return  mMutableLiveData;
    }
}