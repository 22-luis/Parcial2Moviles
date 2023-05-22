package com.molina.redsocialtracker

import android.app.Application
import com.molina.redsocialtracker.data.socials
import com.molina.redsocialtracker.repositories.RedSocialRepository

class RedSocialReviewerApplication : Application() {

    val socialRepository : RedSocialRepository by lazy {
        RedSocialRepository(socials)
    }
}