package com.example.espressokata

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class CustomMatcherActivity : AppCompatActivity() {


    private var customMatcherActivityEtUserName: EditText? = null
    private var customMatcherActivityEtPassword: EditText? = null
    private var customMatcherActivityBtLogin: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_matcher)

        setUpView()
    }

    private fun setUpView() {
        customMatcherActivityEtUserName = findViewById(R.id.customMatcherActivityEtUserName)
        customMatcherActivityEtPassword = findViewById(R.id.customMatcherActivityEtPassword)
        customMatcherActivityBtLogin = findViewById(R.id.customMatcherActivityBtLogin)

        customMatcherActivityBtLogin?.setOnClickListener(View.OnClickListener {
            val userName = customMatcherActivityEtUserName?.text.toString()
            val password = customMatcherActivityEtPassword?.text.toString()

            if (userName.length < 4) {
                customMatcherActivityEtUserName?.error = getString(R.string.login_activity_username_error)
                return@OnClickListener
            }
            if (password.length < 4) {
                customMatcherActivityEtPassword?.error = getString(R.string.login_activity_password_error)
                return@OnClickListener
            }
            doLoginBackEnd(userName, password)
        })
    }

    private fun doLoginBackEnd(userName: String, password: String) {
        if (userName == "Eder" && password == "1234") {
            val intent = Intent(applicationContext, SpinnerActivity::class.java)
            intent.putExtra("USER", userName)
            startActivity(intent)
        }
    }
}
