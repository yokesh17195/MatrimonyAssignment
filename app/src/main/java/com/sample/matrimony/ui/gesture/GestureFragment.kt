package com.sample.matrimony.ui.gesture

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.sample.matrimony.R
import com.sample.matrimony.data.entity.ProfileModel
import com.sample.matrimony.databinding.FragmentGestureBinding
import com.sample.matrimony.databinding.ItemGestureBinding
import com.sample.matrimony.support.SlideTransformer
import com.sample.matrimony.ui.gesture.adapter.GestureAdapter
import com.sample.matrimony.ui.home.listener.ProfileSelectedLisener
import com.sample.matrimony.viewmodel.ProfileViewModel

class GestureFragment:Fragment(R.layout.fragment_gesture) {

    lateinit var binding:FragmentGestureBinding

    val gestureAdapter:GestureAdapter by lazy {
        GestureAdapter(requireContext())
    }

    val profileViewModel: ProfileViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentGestureBinding.bind(view)

        binding.profileList.apply {
            adapter = gestureAdapter
            offscreenPageLimit = 3
            setPageTransformer(SlideTransformer(3))
        }

        profileViewModel.data.observe(viewLifecycleOwner,{

            gestureAdapter.setData(it)
        })

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

    }

}