package com.molina.redsocialtracker.repositories

import com.molina.redsocialtracker.data.model.RedSocialModel

class RedSocialRepository(private val socials :MutableList<RedSocialModel>) {

    fun getSocials () = socials


    //This function add the data in the beginning of the List
    fun setSocials(social: RedSocialModel ) = socials.add(0, social)
}