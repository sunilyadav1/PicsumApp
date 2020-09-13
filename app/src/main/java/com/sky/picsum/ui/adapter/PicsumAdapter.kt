package com.sky.picsum.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sky.picsum.R
import com.sky.picsum.model.PicsumResponse
import com.sky.picsum.model.PicsumResponseItem
import kotlinx.android.synthetic.main.item_layout.view.*

open class PicsumAdapter(val mPicsumResponse: PicsumResponse): RecyclerView.Adapter<PicsumAdapter.MyViewHolder>() {
    class MyViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val imageViewAvatar=view.imageViewAvatar
        val txtTitle=view.txtTitle
        val txtDescription=view.txtDescription

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var mPicsumResponseItem: PicsumResponseItem=mPicsumResponse.get(position)
        holder.txtTitle.text=mPicsumResponseItem.author
        holder.txtDescription.text=mPicsumResponseItem.author

        Glide.with(holder.imageViewAvatar.context)
            .load(mPicsumResponseItem.download_url)
            .centerCrop()
            .placeholder(R.drawable.loading_spinner)
            .into(holder.imageViewAvatar);
    }

    override fun getItemCount(): Int {
        return mPicsumResponse.size
    }

}