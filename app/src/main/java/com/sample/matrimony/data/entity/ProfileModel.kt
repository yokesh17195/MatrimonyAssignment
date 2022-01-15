package com.sample.matrimony.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.sample.matrimony.data.converter.ProfileConverter

@Entity(tableName = "profile_table")

class ProfileModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null,
    val name:String?=null,

    @TypeConverters(ProfileConverter::class)
    val profilePic:ArrayList<String>,

    val age:String?=null,
    val height:String?=null,
    val profession:String?=null,
    val city:String?=null,
    val state:String?=null,
    val country:String?=null
)
