package com.example.espressokata

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import com.example.espressokata.util.CallbakInBackground
import com.example.espressokata.util.ExpressoIdlingResource
import com.example.espressokata.util.WebServiceMock

class IdlingActivity : AppCompatActivity() {

    private var idlingActivityTv: TextView? = null
    private var idlingActivityBt: Button? = null
    private var idlingActivityBtGoToSpinner: Button? = null

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_idling)

        setUpView()
    }

    private fun setUpView() {
        idlingActivityTv = findViewById<TextView>(R.id.idlingActivityTv)
        idlingActivityBt = findViewById<Button>(R.id.idlingActivityBt)
        idlingActivityBtGoToSpinner = findViewById<Button>(R.id.idlingActivityBtGoToSpinner)
        idlingActivityBt?.setOnClickListener { cargarDatos() }
        idlingActivityBtGoToSpinner?.setOnClickListener {
            // startActivity(new Intent(getApplicationContext(), SpinnerActivity.class));
        }
    }

    private fun cargarDatos() {
        ExpressoIdlingResource.increment()
        val webServiceMock = WebServiceMock()
        webServiceMock.login("Eder","1234", object : CallbakInBackground{
            override fun onSuccess(response: String) {
                if (!ExpressoIdlingResource.idlingResource.isIdleNow) {
                    ExpressoIdlingResource.decrement()
                }
                idlingActivityTv?.text = "Eder"

            }

            override fun onFailure(response: String) {
                Log.e("Activity","response $response")
            }

        })
    }

}
