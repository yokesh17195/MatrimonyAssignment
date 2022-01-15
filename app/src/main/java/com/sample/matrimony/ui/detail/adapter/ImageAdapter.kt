package com.sample.matrimony.ui.detail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sample.matrimony.R

class ImageAdapter(var context:Context):RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    val list:MutableList<String> = mutableListOf()

    fun setData(list: List<String>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class ImageViewHolder(var view:View):RecyclerView.ViewHolder(view){

        val imageView = view.findViewById<ImageView>(R.id.img)

        fun bind(item:String){
            Glide.with(context).load(item).centerCrop().into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image,parent,false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}