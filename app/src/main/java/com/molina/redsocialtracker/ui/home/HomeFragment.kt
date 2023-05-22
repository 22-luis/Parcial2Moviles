package com.molina.redsocialtracker.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.molina.redsocialtracker.R
import com.molina.redsocialtracker.data.model.RedSocialModel
import com.molina.redsocialtracker.databinding.FragmentHomeBinding
import com.molina.redsocialtracker.ui.home.recyclerview.RedSocialAdapter
import com.molina.redsocialtracker.ui.viewmodel.RedSocialViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter : RedSocialAdapter

    private val soacialViewModel: RedSocialViewModel by activityViewModels<RedSocialViewModel> {
        RedSocialViewModel.Factory
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private fun showSelectedItem(social: RedSocialModel) {
        soacialViewModel.setSelectSocial(social)
        findNavController().navigate(R.id.action_homeFragment_to_redSocialFragment)
    }

    private fun displayMovies() {
        adapter.setData(soacialViewModel.getSocials())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view : View) {
        binding.recycleView.layoutManager = LinearLayoutManager(view.context)

        adapter = RedSocialAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)
        }

        binding.recycleView.adapter = adapter
        displayMovies()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.btnAdd.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_addRedSocialFragment)
        }
    }


}