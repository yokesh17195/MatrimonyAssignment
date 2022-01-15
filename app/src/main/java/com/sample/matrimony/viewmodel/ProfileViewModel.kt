package com.sample.matrimony.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.matrimony.data.entity.ProfileModel
import com.sample.matrimony.data.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(var profileRepository: ProfileRepository) :ViewModel() {


    lateinit var data: LiveData<MutableList<ProfileModel>>
    lateinit var profiledata: LiveData<ProfileModel>
    val scope = viewModelScope

    init {
        getAllData()
    }

    fun getAllData(){
        scope.launch {
            data = profileRepository.getAllData()
        }
    }

    fun insertList(list:MutableList<ProfileModel>){
        scope.launch {
            profileRepository.insertData(list)
        }
    }

    fun getProfileData(id:Int){
        scope.launch {
            profiledata = profileRepository.getProfileData(id)
        }
    }

}