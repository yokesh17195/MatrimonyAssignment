package com.sample.matrimony.data.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sample.matrimony.data.entity.ProfileModel
import org.json.JSONObject

class ProfileConverter {

    @TypeConverter
    fun fromString(value: String): ArrayList<String> =
        Gson().fromJson(value, object : TypeToken<ArrayList<String>>() {}.type)

    @TypeConverter
    fun fromModel(value: ArrayList<String>): String = Gson().toJson(value)

}