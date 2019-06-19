package com.example.espressokata.util

import android.os.Handler

class WebServiceMock {

    fun login(user: String, password: String, callback: CallbakInBackground) {

        Handler().postDelayed({
            val check = true
            if (check) {
                callback.onSuccess("Correct User")
            } else {
                callback.onFailure("Wrong User")
            }
        }, 5000)
    }
}
