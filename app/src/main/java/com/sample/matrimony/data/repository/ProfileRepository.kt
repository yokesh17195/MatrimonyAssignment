package com.sample.matrimony.data.repository

import androidx.lifecycle.LiveData
import com.sample.matrimony.data.dao.ProfileDao
import com.sample.matrimony.data.entity.ProfileModel
import javax.inject.Inject

class ProfileRepository @Inject constructor(var profileDao: ProfileDao) {

    fun getAllData():LiveData<MutableList<ProfileModel>>{
        return profileDao.getLiveData()
    }

    suspend fun insertData(list: MutableList<ProfileModel>){
        profileDao.insertAllData(list)
    }

    fun getProfileData(id:Int):LiveData<ProfileModel>{
        return profileDao.getProfileData(id)
    }

}