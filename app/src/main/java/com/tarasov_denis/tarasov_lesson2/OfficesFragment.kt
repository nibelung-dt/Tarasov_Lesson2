package com.tarasov_denis.tarasov_lesson2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tarasov_denis.tarasov_lesson2.databinding.FragmentMainBinding
import com.tarasov_denis.tarasov_lesson2.databinding.FragmentOfficesBinding


class OfficesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        val binding = FragmentOfficesBinding.inflate(inflater, container, false)
        // return inflater.inflate(R.layout.fragment_offices, container, false)
        return binding.root
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        val listOfCities = listOf(
            "Москва", "Минск", "Санкт-Петербург", "Ростов-на-Дону", "Казань",
            "Алматы", "Гомель", "Витебск", "Полоцк"
        )

        val layoutManager = LinearLayoutManager(context)
        val recyclerView: RecyclerView? = view?.findViewById(R.id.recycler_view_office)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.setHasFixedSize(true)

        recyclerView?.adapter = RecyclerAdapterOffices(listOfCities) { String ->
            // Log.d("Denis", String)
           // binding.bottomNavigationView.visibility = View.INVISIBLE
            MainActivity.selectedCity = String
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, DetailOfficeFragment()) //, args = bundle)
                .addToBackStack(null)
                .commit()

//  .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        }
    }
}







