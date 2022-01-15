package com.sample.matrimony.support

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sample.matrimony.R
import com.sample.matrimony.data.entity.ProfileModel

@BindingAdapter("android:loadImage")
fun loadImage(imageView: ImageView, imageUrl: String) {
    Glide.with(imageView)
        .load(imageUrl)
        .centerCrop()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(imageView)
}

@BindingAdapter("android:bindDetails")
fun setDetails(text: TextView,data:ProfileModel?){
    val bindDetails = StringBuilder().apply {
        append(data?.age)
        append(", ")
        append(data?.height)
        append(", ")
        append(data?.profession)
        append(", ")
        append(data?.city)
        append(", ")
        append(data?.state)
        append(", ")
        append(data?.country)
    }.toString()

    text.setText(bindDetails)
}

