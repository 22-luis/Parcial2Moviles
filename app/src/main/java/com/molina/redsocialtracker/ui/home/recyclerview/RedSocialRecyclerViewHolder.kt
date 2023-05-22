package com.molina.redsocialtracker.ui.home.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.molina.redsocialtracker.data.model.RedSocialModel
import com.molina.redsocialtracker.databinding.FragmentRedSocialBinding
import com.molina.redsocialtracker.databinding.ItemSocialBinding

class RedSocialRecyclerViewHolder(private val binding: ItemSocialBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(social : RedSocialModel, clickListener : (RedSocialModel) -> Unit) {
        binding.nameTextView.text = social.name
        binding.userTextView.text = social.user

        binding.cardView.setOnClickListener{
            clickListener(social)
        }
    }
}