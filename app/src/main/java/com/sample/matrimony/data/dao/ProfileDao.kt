package com.sample.matrimony.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sample.matrimony.data.entity.ProfileModel

@Dao
interface ProfileDao {

    @Query("Select * from profile_table")
    suspend fun getData():MutableList<ProfileModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllData(data:MutableList<ProfileModel>)

    @Query("Select * from profile_table")
    fun getLiveData():LiveData<MutableList<ProfileModel>>

    @Query("Select * from profile_table where id=:id")
    fun getProfileData(id:Int):LiveData<ProfileModel>

}