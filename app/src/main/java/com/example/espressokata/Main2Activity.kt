package com.example.espressokata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


public class Main2Activity : AppCompatActivity() {
    private var activityMain2EtMiFirstEditText: EditText? = null
    private var activityMain2BtReset: Button? = null
    private var activityMain2TvMiFirstTest: TextView? = null
    private var activityMain2btChange: Button? = null
    private var activityMain2BtGoToLogin: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        setUpView()
    }

    private fun setUpView() {
        activityMain2EtMiFirstEditText = findViewById(R.id.activityMain2EtMiFirstEditText)
        activityMain2BtReset = findViewById(R.id.activityMain2BtReset)
        activityMain2TvMiFirstTest = findViewById(R.id.activityMain2TvMiFirstTest)
        activityMain2btChange = findViewById(R.id.activityMain2btChange)
        activityMain2BtGoToLogin = findViewById(R.id.activityMain2BtGoToLogin)

        activityMain2BtReset?.setOnClickListener { activityMain2TvMiFirstTest!!.text = "Reset" }

        activityMain2btChange?.setOnClickListener {
            activityMain2TvMiFirstTest?.text = activityMain2EtMiFirstEditText!!.text.toString()
        }

        activityMain2BtGoToLogin!!.setOnClickListener {
            //startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
    }
}
