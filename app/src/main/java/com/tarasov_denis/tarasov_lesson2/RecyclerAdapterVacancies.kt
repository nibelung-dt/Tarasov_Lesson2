package com.tarasov_denis.tarasov_lesson2


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
        // holder.setIsRecyclable(false)
        // listOfViews[0].title
        holder.title.text = listOfViews[position].title //.toString()
        holder.subTitle.text = listOfViews[position].subtitle

      //  Log.d("onBindViewHolder", "запустилось")
       // holder.largeTextView.text = names[position].question
       // holder.smallTextView.text = names[position].numberQuestion

/*
        holder.relLayout1.setOnClickListener { v ->
            // holder.relLayout1.background =
            if (!touch1 && !listenersDisabled) {
                holder.relLayout1.setBackgroundColor(Color.parseColor("#C0FEDF")) // зеленый
                holder.image1.setVisibility(View.VISIBLE)

                holder.text1_2.text = names[position].percents[0]
                holder.text2_2.text = names[position].percents[1]
                holder.text3_2.text = names[position].percents[2]
                holder.text4_2.text = names[position].percents[3]

                touch1 = true
                listenersDisabled = true
            } else if (touch1 && listenersDisabled) {
                holder.relLayout1.setBackgroundColor(Color.parseColor("#DAFCFB"))

                holder.text1_2.text = ""
                holder.text2_2.text = ""
                holder.text3_2.text = ""
                holder.text4_2.text = ""

                holder.image1.setVisibility(View.INVISIBLE)
                touch1 = false
                listenersDisabled = false
            }
        }
 */
    }

    override fun getItemCount() = listOfViews.size
}