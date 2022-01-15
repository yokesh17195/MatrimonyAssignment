package com.sample.matrimony.ui.home.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.sample.matrimony.data.entity.ProfileModel

class ProfileDiffUtils:DiffUtil.ItemCallback<ProfileModel>() {
    override fun areItemsTheSame(oldItem: ProfileModel, newItem: ProfileModel): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: ProfileModel, newItem: ProfileModel): Boolean {
        return oldItem.equals(newItem)
    }
}