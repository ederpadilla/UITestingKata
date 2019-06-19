package com.example.espressokata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import java.util.ArrayList

class SpinnerActivity : AppCompatActivity() {


    private var spinnerActivitySp: Spinner? = null
    private var spinnerActivityTv: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        setUpView()
        setUpDataSpinner()
    }

    private fun setUpView() {
        spinnerActivityTv = findViewById(R.id.spinnerActivityTv)
        spinnerActivitySp = findViewById(R.id.spinnerActivitySp)

        spinnerActivitySp!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (position > 0) {
                    spinnerActivityTv!!.text = parent.selectedItem as CharSequence
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    private fun setUpDataSpinner() {
        val names = ArrayList<String>()
        names.add("Alberto")
        names.add("Manuel")
        names.add("Laura")
        names.add("Monica")
        names.add("Pablo")

        val dataAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, names)

        spinnerActivitySp!!.adapter = dataAdapter

    }
}
