package com.example.espressokata

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LoginActivity : AppCompatActivity() {

    private var loginActivityEtUserName: EditText? = null
    private var loginActivityEtPassword: EditText? = null
    private var loginActivityTvError: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setUpView()
    }

    private fun setUpView() {
        loginActivityEtUserName = findViewById(R.id.loginActivityEtUserName)
        loginActivityEtPassword = findViewById(R.id.loginActivityEtPassword)
        val loginActivityBtLogin = findViewById<Button>(R.id.loginActivityBtLogin)
        loginActivityTvError = findViewById(R.id.loginActivityTvError)

        loginActivityBtLogin.setOnClickListener(View.OnClickListener {
            loginActivityTvError!!.visibility = View.GONE
            val userName = loginActivityEtUserName!!.text.toString()
            val password = loginActivityEtPassword!!.text.toString()

            if (userName.length < 4) {
                loginActivityTvError!!.setText(R.string.login_activity_username_error)
                loginActivityTvError!!.visibility = View.VISIBLE
                return@OnClickListener
            }
            if (password.length < 4) {
                loginActivityTvError!!.setText(R.string.login_activity_password_error)
                loginActivityTvError!!.visibility = View.VISIBLE
                return@OnClickListener
            }
            doLoginBackEnd(userName, password)
        })
    }

    private fun doLoginBackEnd(userName: String, password: String) {

        if (userName == "Eder" && password == "1234") {
            val intent =  Intent(applicationContext, RecyclerViewActivity::class.java)
            intent.putExtra("USER", userName)
            startActivity(intent)
        }

    }
}
