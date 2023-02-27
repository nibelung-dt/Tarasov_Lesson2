package com.tarasov_denis.tarasov_lesson2


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapterVacancies(private val listOfViews: List<CustomViews.MyViews>) : RecyclerView
.Adapter<RecyclerAdapterVacancies.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val binding = CustomViewBinding
       val title: TextView = itemView.findViewById(R.id.title)
       val subTitle: TextView = itemView.findViewById(R.id.subtitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_view, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = listOfViews[position].title //.toString()
        holder.subTitle.text = listOfViews[position].subtitle
    }

    override fun getItemCount() = listOfViews.size
}