package com.tarasov_denis.tarasov_lesson2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tarasov_denis.tarasov_lesson2.databinding.*
import com.tarasov_denis.tarasov_lesson2.CustomView
import java.util.*


// фильтр
// https://github.com/RajashekarRaju/Filter-Search-RecyclerView

/* открытие фрагмента из ресайклера
https://medium.com/inside-ppl-b7/recyclerview-inside-fragment-with-android-studio-680cbed59d84
https://qna.habr.com/q/1006389
 */

class VacanciesFragment : Fragment() {

   // private lateinit var recyclerView: RecyclerView? //<RecyclerAdapterVacancies.MyViewHolder>

   var query: String = ""
    private lateinit var listOfViews: List<CustomViews.MyViews> //= List<CustomViews.MyViews>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = FragmentVacanciesBinding.inflate(inflater, container, false)

      //  return inflater.inflate(R.layout.fragment_vacancies, container, false)
        return binding.root
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        // создаем список объектов для ресайклера
         listOfViews = CustomViews.Base().createListOfCustomViews(listOfTitles,listOfSubtitles)

        val layoutManager = LinearLayoutManager(context)
        val recyclerView: RecyclerView? = view?.findViewById(R.id.recycler_view)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = RecyclerAdapterVacancies(listOfViews)

        fun startForListener() {
            if (query.isNotEmpty()) {
                val listOfViewsShort = filtrateList(query)
                recyclerView?.adapter = RecyclerAdapterVacancies(listOfViewsShort)
            } else if (query.isEmpty()) {
                recyclerView?.adapter = RecyclerAdapterVacancies(listOfViews)
            }
        }

        val editText = view?.findViewById<AppCompatEditText>(R.id.search_edit_text)
        editText?.doOnTextChanged { text, _, _, _ ->
        query = text.toString().lowercase(Locale.getDefault())
        startForListener()
        }
    }

    // выполняем поиск
    private fun filtrateList(filterQuery: String): List<CustomViews.MyViews> {
        val filteredList = mutableListOf<CustomViews.MyViews>()
        for (currentVacancy in listOfViews) {

            if (currentVacancy.subtitle.lowercase(Locale.getDefault()).contains(filterQuery)) {
                filteredList.add(currentVacancy)
            }
        }
        return filteredList
    }

/*
    private fun filterWithQuery(query: String) {
        if (query.isNotEmpty()) {
            val filteredList: List<CustomViews.MyViews> = onFilterChanged(query)
          //  attachAdapter(filteredList)
            //toggleRecyclerView(filteredList)
        } else if (query.isEmpty()) {
            // attachAdapter(listOfViews2)
        }
    }

/*
    fun attachAdapter(list: List<CustomViews.MyViews>) {
        // adapter = SearchAdapter(list)
        recyclerView?.adapter = RecyclerAdapterVacancies(list)
        //  recyclerView?.adapter = RecyclerAdapterVacancies(list)
        // recyclerView?.adapter = searchAdapter
    }
 */

    private fun toggleRecyclerView(filteredList: Any) {
        if (listOfViews2.isEmpty()) {
            recyclerView.visibility = View.INVISIBLE
           // noSearchResultsFoundText.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.VISIBLE
           // noSearchResultsFoundText.visibility = View.INVISIBLE
        }
    }
 */

    val listOfTitles = listOf("Android trainee", "Web trainee", "Java back-end trainee", "IOS trainee", "Секретарша",
        "Водитель", "Стажер product manager", "Уборщица", "Стажер-дворник", "Flutter trainee", "Стажер 1С", "Designer trainee",
        "Стажер-грузчик", "Стажер-Java", "Стажер-летчик", "Стажер-копировщик", "Стажер-повар", "Стажер-инфоцыганин", "Стажер-психолог",
        "Стажер-инженер-кораблестроитель", "Back-end")
    val listOfSubtitles = listOf("Cтажировка по направлению Android","Cтажировка по веб-программированию", "Cтажировка по направлению Java",
        "Cтажировка по направлению IOS", "Стажировка для секретарши", "Стажировка по вождению", "Стажировка по продукт-менеджементу",
        "Стажировка для уборщица", "Стажировка для дворника", "Стажировка по флаттеру", "Стажировка по 1С", "Стажировка по дизайну",
        "Стажировка для грузчика", "Изучение java", "Летная стажировка", "Стажировка по копировальному делу", "Стажировка по кулинарному искусству",
        "Обучение по созданию курсов", "Стажировка для психологов", "Стажировка по направлению кораблестроение",
        "Java, Kotlin, Spring")

   // val listOfViews2 = CustomViews.Base().createListOfCustomViews(listOfTitles,listOfSubtitles)
   // val viewSample = CustomViews.MyViews("Web trainee","Cтажировка по веб-программированию" )
    // val listOfViewsShort = listOf(viewSample)   //List<CustomViews.MyViews>(viewSample)
}