package com.example.espressokata

import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.espressokata.adapter.PeopleAdapter
import com.example.espressokata.model.Person

import java.util.ArrayList

class RecyclerViewActivity : AppCompatActivity() {

    private var people = mutableListOf<Person>()
    private var rv: RecyclerView? = null
    private var adapter: PeopleAdapter? = null
    private var recyclerActivityBtWebView: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        setUpList()
        setUpView()

    }

    private fun setUpView() {
        recyclerActivityBtWebView = findViewById(R.id.recyclerActivityBtWebView)
        rv = findViewById(R.id.recyclerActivityRv)
        val layoutManager = LinearLayoutManager(applicationContext)
        rv!!.layoutManager = layoutManager
        adapter = PeopleAdapter(people)
        rv!!.adapter = adapter

        recyclerActivityBtWebView!!.setOnClickListener {
            //startActivity(new Intent(getApplicationContext(), IdlingActivity.class));
        }
    }


    private fun setUpList() {
        people = ArrayList()
        people.add(Person("Alberto", "30"))
        people.add(Person("Maria", "29"))
        people.add(Person("Monica", "45"))
        people.add(Person("Roberto", "20"))
        people.add(Person("Luis", "50"))
        people.add(Person("Alba", "45"))
        people.add(Person("Adolfo", "33"))
        people.add(Person("Estrella", "22"))
        people.add(Person("Manuel", "20"))
        people.add(Person("Alfonso", "50"))

        people.add(Person("Mariano", "30"))
        people.add(Person("Maria", "29"))
        people.add(Person("Monica", "45"))
        people.add(Person("Roberto", "20"))
        people.add(Person("Luis", "50"))
        people.add(Person("Alba", "45"))
        people.add(Person("Adolfo", "33"))
        people.add(Person("Estrella", "22"))
        people.add(Person("Manuel", "20"))
        people.add(Person("Pablo", "50"))
    }
}
