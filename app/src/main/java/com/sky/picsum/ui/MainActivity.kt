package com.sky.picsum.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sky.picsum.R
import com.sky.picsum.viewmodel.PicsumViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    lateinit var picsumViewModel: PicsumViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        picsumViewModel=ViewModelProviders.of(this@MainActivity).get(PicsumViewModel::class.java)

        progressBar.visibility= View.VISIBLE
        picsumViewModel.getPicsumApi(0,10).observe(this, Observer {
            Log.e("Api response:",it.toString())
            progressBar.visibility= View.GONE

        })
    }
}