package com.molina.redsocialtracker.ui.redsocial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.molina.redsocialtracker.R
import com.molina.redsocialtracker.databinding.FragmentAddRedSocialBinding
import com.molina.redsocialtracker.databinding.FragmentHomeBinding
import com.molina.redsocialtracker.databinding.FragmentRedSocialBinding
import com.molina.redsocialtracker.ui.home.recyclerview.RedSocialAdapter
import com.molina.redsocialtracker.ui.viewmodel.RedSocialViewModel

class RedSocialFragment : Fragment() {

    private lateinit var binding: FragmentRedSocialBinding

    private val socialViewModel: RedSocialViewModel by activityViewModels<RedSocialViewModel> {
        RedSocialViewModel.Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = FragmentRedSocialBinding.inflate(inflater, container , false)
        return binding.root
    }
    private fun setViewModel(){
        binding.viewmodel = socialViewModel
    }


}