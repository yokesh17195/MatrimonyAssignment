package com.sample.matrimony.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sample.matrimony.data.entity.ProfileModel
import com.sample.matrimony.databinding.ItemProfileBinding
import com.sample.matrimony.ui.home.diffutils.ProfileDiffUtils
import com.sample.matrimony.ui.home.listener.ProfileSelectedLisener

class ProfileAdapter(
    var context: Context,
    var profileSelectedLisener: ProfileSelectedLisener
):ListAdapter<ProfileModel,ProfileAdapter.ProfileViewHolder>(ProfileDiffUtils()) {

    inner class ProfileViewHolder(var binding:ItemProfileBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data:ProfileModel){
            binding.profile = data

            binding.yes.setOnClickListener {
                profileSelectedLisener.isSelected(adapterPosition)
                Toast.makeText(context,"Selected!", Toast.LENGTH_LONG).show()
            }
            binding.no.setOnClickListener {
                profileSelectedLisener.isSelected(adapterPosition)
                Toast.makeText(context,"Not Selected!",Toast.LENGTH_LONG).show()
            }

            binding.profilePic.setOnClickListener{
                profileSelectedLisener.navigateToDetails(data.id!!)
            }

            binding.name.setOnClickListener{
                profileSelectedLisener.navigateToDetails(data.id!!)
            }

            binding.details.setOnClickListener {
                profileSelectedLisener.navigateToDetails(data.id!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        return ProfileViewHolder(ItemProfileBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.binding.executePendingBindings()
    }

}