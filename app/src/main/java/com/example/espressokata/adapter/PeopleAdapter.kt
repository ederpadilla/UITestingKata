package com.example.espressokata.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.espressokata.R
import com.example.espressokata.model.Person

class PeopleAdapter(private val people: List<Person>) : RecyclerView.Adapter<PeopleAdapter.PersonaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_persona, parent, false)
        return PersonaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        holder.setUpData(people[position])
    }

    override fun getItemCount(): Int {
        return people.size
    }

    class PersonaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val mTvName: TextView = itemView.findViewById(R.id.mTvName)
        private val mTvAge : TextView = itemView.findViewById(R.id.mTvAge)

        fun setUpData(person: Person){
            mTvName.text =person.name
            mTvAge.text = person.age
        }
    }
}


