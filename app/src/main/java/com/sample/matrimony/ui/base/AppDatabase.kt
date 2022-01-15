package com.sample.matrimony.ui.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.sample.matrimony.data.converter.ProfileConverter
import com.sample.matrimony.data.dao.ProfileDao
import com.sample.matrimony.data.entity.ProfileModel

@Database(entities = [ProfileModel::class],version = 1)
@TypeConverters(ProfileConverter::class)
abstract class AppDatabase:RoomDatabase() {

    abstract fun profileDao():ProfileDao

}