package com.sample.matrimony.ui.gesture.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sample.matrimony.data.entity.ProfileModel
import com.sample.matrimony.databinding.ItemGestureBinding
import com.sample.matrimony.ui.home.diffutils.ProfileDiffUtils
import com.sample.matrimony.ui.home.listener.ProfileSelectedLisener

class GestureAdapter(
    var context: Context
): RecyclerView.Adapter<GestureAdapter.GestureViewHolder>() {

    val list:MutableList<ProfileModel> = mutableListOf()

    fun setData( list:MutableList<ProfileModel>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class GestureViewHolder(var binding: ItemGestureBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: ProfileModel){
            binding.profile = data

            binding.yes.setOnClickListener {
                list.removeAt(adapterPosition)
                notifyDataSetChanged()
                Toast.makeText(context,"Selected!",Toast.LENGTH_LONG).show()
            }
            binding.no.setOnClickListener {
                list.removeAt(adapterPosition)
                notifyDataSetChanged()
                Toast.makeText(context,"Not Selected!",Toast.LENGTH_LONG).show()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GestureViewHolder {
        return GestureViewHolder(ItemGestureBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: GestureViewHolder, position: Int) {
        holder.bind(list[position])
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return list.size
    }


}