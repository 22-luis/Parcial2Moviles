package com.molina.redsocialtracker.ui.viewmodel

import android.text.Editable.Factory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.molina.redsocialtracker.RedSocialReviewerApplication
import com.molina.redsocialtracker.data.model.RedSocialModel
import com.molina.redsocialtracker.repositories.RedSocialRepository

class RedSocialViewModel(private val repository: RedSocialRepository): ViewModel() {

    val name = MutableLiveData("")
    val user = MutableLiveData("")

    //status notify the app if a new data was created or no
    val status = MutableLiveData("")

    fun getSocials () = repository.getSocials()

    private fun addSocial (social: RedSocialModel) = repository.setSocials(social)

    //Add a new data and change de status to back to home
    fun createSocial() {
        if (!validateData()){
            status.value = WRONG
            return
        }

        val social = RedSocialModel(
            name.value!!,
            user.value!!,
        )

        addSocial(social)

        status.value = CREATED
    }

    //Check is the input text is empty
    private fun validateData(): Boolean {
        when{
            name.value.isNullOrBlank() -> return false
            user.value.isNullOrBlank() -> return false
        }
        return true
    }

    //Change the status in home to can create a new dat
    fun clearStatus() {
        status.value = INACTIVE
    }

    //set the data
    fun setSelectSocial(social: RedSocialModel) {
        name.value = social.name
        user.value = social.user
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val socialRepositoryApp = (this[APPLICATION_KEY] as RedSocialReviewerApplication).socialRepository

                RedSocialViewModel(socialRepositoryApp)
            }
        }

        const val CREATED = "Red social created"
        const val WRONG = "Wrong information"
        const val INACTIVE = ""
    }


}