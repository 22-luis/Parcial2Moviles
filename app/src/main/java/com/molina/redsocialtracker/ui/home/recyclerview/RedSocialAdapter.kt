package com.molina.redsocialtracker.ui.home.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener
import com.molina.redsocialtracker.data.model.RedSocialModel
import com.molina.redsocialtracker.databinding.ItemSocialBinding

class RedSocialAdapter(
    private val clickListener: (RedSocialModel) -> Unit
) : RecyclerView.Adapter<RedSocialRecyclerViewHolder>(){

    private val socials = ArrayList<RedSocialModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedSocialRecyclerViewHolder {
        val binding = ItemSocialBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RedSocialRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return socials.size
    }

    override fun onBindViewHolder(holder: RedSocialRecyclerViewHolder, position: Int) {
        val social = socials[position]
        holder.bind(social, clickListener)
    }

    fun setData(socialsList: List<RedSocialModel>){
        socials.clear()
        socials.addAll(socialsList)
    }



}