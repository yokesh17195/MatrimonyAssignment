package com.sample.matrimony.ui.home

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.matrimony.R
import com.sample.matrimony.data.entity.ProfileModel
import com.sample.matrimony.databinding.FragmentHomeBinding
import com.sample.matrimony.ui.home.adapter.ProfileAdapter
import com.sample.matrimony.ui.home.listener.ProfileSelectedLisener
import com.sample.matrimony.viewmodel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home),
    ProfileSelectedLisener {

    lateinit var binding: FragmentHomeBinding


    val profileViewModel:ProfileViewModel by activityViewModels()

    val localList: MutableList<ProfileModel> = mutableListOf()

    val adapter: ProfileAdapter by lazy {
        ProfileAdapter(requireContext(),this)
    }

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        initUI()

    }

    private fun initUI() {

        binding.options.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_gestureFragment)
        }

        binding.profileList.apply {
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = this@HomeFragment.adapter
        }

        if(sharedPreferences.getBoolean("FirstTime",true)){
            profileViewModel.insertList(getData())
            sharedPreferences.edit().putBoolean("FirstTime",false).apply()
        }


        profileViewModel.data.observe(viewLifecycleOwner,{

            setAdapter(it)
        })

    }

    private fun setAdapter(listData: MutableList<ProfileModel>) {
        adapter.submitList(listData)
    }


    fun getData(): MutableList<ProfileModel> {

        val list1: ArrayList<String> = ArrayList()

        list1.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSX5QQ2YP9YrZU-MO4p3wH5ip0deVLO-AsZ3A&usqp=CAU")
        list1.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2b_UowT-SpOEyw2TUI4u9jXkBAUd9OPoMEQ&usqp=CAU")
        list1.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJ0-DcLX0IKnf6aHUBROab0t_aaWwoRAQzag&usqp=CAU")

        localList.add(
            ProfileModel(
                name = "Priyanka Mohan",
                age = "30",
                height = "5.6 ft",
                profession = "Actor",
                city = "Chennai",
                state = "TamilNadu",
                country = "India",
                profilePic = list1
            )
        )

        val list2: ArrayList<String> = ArrayList()

        list2.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1cQrn4kbhhHhSAcB6MEKof4-ohTXD-Mc4Dw&usqp=CAU")
        list2.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR47KEc2ssBDRq17SJk5PgX_lTeY15buMjWBw&usqp=CAU")
        list2.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiK-5syId7lEq6wWVYVjXxDtIBHC3JWXmuPw&usqp=CAU")

        localList.add(
            ProfileModel(
                name = "Nazriya", age = "31", height = "5.6 ft",
                profession = "Actor", city = "Chennai", state = "TamilNadu", country = "India",
                profilePic = list2
            )
        )

        val list3: ArrayList<String> = ArrayList()

        list3.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsg0QSYOeFRdGPrDBp0n2oivzutxHiJLempw&usqp=CAU")
        list3.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjamrBqfJDmu_iXdx6K3_XIWHsn5c2Jhh3Qw&usqp=CAU")
        list3.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHBTCZNR4J-bn0sTgyPo1Nj_YvhHlEL4_c1Q&usqp=CAU")


        localList.add(
            ProfileModel(
                name = "Nayanthara", age = "32", height = "5.4 ft",
                profession = "Actor", city = "Chennai", state = "TamilNadu", country = "India",
                profilePic = list3
            )
        )

        val list4: ArrayList<String> = ArrayList()

        list4.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWGRjf5GAld0nWCZrAj2BZ-y9dVId-S6P7uw&usqp=CAU")
        list4.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXM5dZUsuW55ybgIRylk3SF_2iFUFsCx3mnA&usqp=CAU")
        list4.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4lw_zNicAwhY8euBuDoSF_gt1w2hVZGohdg&usqp=CAU")


        localList.add(
            ProfileModel(
                name = "Samantha", age = "33", height = "5.3 ft",
                profession = "Actor", city = "Chennai", state = "TamilNadu", country = "India",
                profilePic = list4
            )
        )

        val list5: ArrayList<String> = ArrayList()

        list5.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyiOVMuAkoVScgNLMEv8OoeZJRPntXxBC-0w&usqp=CAU")
        list5.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyiOVMuAkoVScgNLMEv8OoeZJRPntXxBC-0w&usqp=CAU")
        list5.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2P4p5OhAekOQQLrZctlPsbhnoxeGA9YuWqw&usqp=CAU")


        localList.add(
            ProfileModel(
                name = "Anupama", age = "34", height = "5.7 ft",
                profession = "Actor", city = "Chennai", state = "TamilNadu", country = "India",
                profilePic = list5
            )
        )

        return localList
    }

    override fun isSelected(pos: Int) {

        val data = adapter.currentList
        val modifiedData:MutableList<ProfileModel> = mutableListOf()
        modifiedData.addAll(data)
        modifiedData.removeAt(pos)
        adapter.submitList(modifiedData)

    }

    override fun navigateToDetails(id: Int) {
        val bundle = Bundle().apply {
            putInt("Id",id)
        }
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment,bundle)
    }
}