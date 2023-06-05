package com.molina.redsocialtracker.ui.addredsocial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.molina.redsocialtracker.R
import com.molina.redsocialtracker.databinding.FragmentAddRedSocialBinding
import com.molina.redsocialtracker.ui.viewmodel.RedSocialViewModel


class AddRedSocialFragment : Fragment() {

private lateinit var binding: FragmentAddRedSocialBinding

    private val socialViewModel: RedSocialViewModel by activityViewModels {
        RedSocialViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = FragmentAddRedSocialBinding.inflate(inflater, container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observerStatus()

    }

    private fun setViewModel(){
        binding.viewmodel = socialViewModel
    }

    private fun observerStatus(){
        socialViewModel.status.observe(viewLifecycleOwner){
            when{
                it.equals(RedSocialViewModel.WRONG)->{

                    socialViewModel.clearStatus()
                }
                it.equals(RedSocialViewModel.CREATED)->{

                    socialViewModel.clearStatus()
                    findNavController().popBackStack()

                }
            }
        }
    }



}