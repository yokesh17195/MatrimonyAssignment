package com.sample.matrimony.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.sample.matrimony.R
import com.sample.matrimony.data.dao.ProfileDao
import com.sample.matrimony.databinding.FragmentDetailBinding
import com.sample.matrimony.ui.detail.adapter.ImageAdapter
import com.sample.matrimony.viewmodel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    lateinit var binding: FragmentDetailBinding

    val imgAdapter: ImageAdapter by lazy {
        ImageAdapter(requireContext())
    }

    val profileViewModel: ProfileViewModel by activityViewModels()

    var id:Int? = null


    @Inject
    lateinit var profileDao: ProfileDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDetailBinding.bind(view)

        initUI()


    }

    private fun initUI() {

        id = arguments?.getInt("Id")

        binding.imageList.adapter = imgAdapter

        TabLayoutMediator(binding.tabLayout, binding.imageList) { tab, position ->
            //Some implementation
        }.attach()

        profileViewModel.getProfileData(id!!)
        profileViewModel.profiledata.observe(viewLifecycleOwner, {
            binding.executePendingBindings()
            binding.profile = it

            val imgList: MutableList<String> = mutableListOf()

            it.profilePic.forEach {

                imgList.add(it)

            }

            imgAdapter.setData(imgList)


        })

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }


    }
}