package com.tarasov_denis.tarasov_lesson2

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterOffices(
    private val cities: List<String>, private val onItemClicked: (String) -> Unit): RecyclerView.Adapter<RecyclerAdapterOffices.ViewHolderOffice>() {


    class ViewHolderOffice(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val city: TextView = itemView.findViewById(R.id.title)
        val layout: RelativeLayout = itemView.findViewById(R.id.layout)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderOffice {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.city_layout, parent, false)

        return  ViewHolderOffice(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderOffice, position: Int) {
        holder.setIsRecyclable(false)
        holder.city.text = cities[position]
        val selectedCity = cities[position]

        holder.layout.setOnClickListener{
            onItemClicked(selectedCity)
        }

    }

    override fun getItemCount(): Int = cities.size

}