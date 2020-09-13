package com.sky.picsum.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.sky.picsum.R
import com.sky.picsum.model.PicsumResponse
import com.sky.picsum.ui.adapter.PicsumAdapter
import com.sky.picsum.ui.base.BaseActivity
import com.sky.picsum.viewmodel.PicsumViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() , SwipeRefreshLayout.OnRefreshListener{
    lateinit var picsumViewModel: PicsumViewModel
    lateinit var adapter: PicsumAdapter
    var isLastPage: Boolean = false
    var SKIP:Int=1
    var LIMIT:Int=12;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mSwipeRefreshLayout.setOnRefreshListener(this)
        picsumViewModel=ViewModelProviders.of(this@MainActivity).get(PicsumViewModel::class.java)
       renderUI(SKIP,LIMIT);
    }

    private fun renderUI(mSkip: Int, mLimit: Int) {
        progressBar.visibility= View.VISIBLE
        picsumViewModel.getPicsumApi(mSkip, mLimit).observe(this, Observer {
           // Log.e("Api response:",it.toString())
            progressBar.visibility= View.GONE
            setupUI(it)
        })

    }

    private fun setupUI(picsumResponse: PicsumResponse) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PicsumAdapter(picsumResponse)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter




    }

    override fun onRefresh() {
        mSwipeRefreshLayout.setRefreshing(false)
        SKIP=SKIP+1;
        Log.e("Skip:",""+SKIP)
        Log.e("Limit:",""+LIMIT)
        renderUI(SKIP,LIMIT);
    }
}