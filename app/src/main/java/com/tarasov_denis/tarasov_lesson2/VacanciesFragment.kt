package com.tarasov_denis.tarasov_lesson2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tarasov_denis.tarasov_lesson2.databinding.*
import com.tarasov_denis.tarasov_lesson2.CustomView

/**
 * A simple [Fragment] subclass.
 * Use the [VacanciesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

// фильтр
// https://github.com/RajashekarRaju/Filter-Search-RecyclerView

/* открытие фрагмента из ресайклера
https://medium.com/inside-ppl-b7/recyclerview-inside-fragment-with-android-studio-680cbed59d84

https://qna.habr.com/q/1006389

 */


class VacanciesFragment : Fragment() {
   // private lateinit var layoutManager: RecyclerView.LayoutManager
   // private lateinit var RecyclerView.Adapter<RecyclerAdapterVacancies.MyViewHolder>
    private lateinit var adapter: RecyclerAdapterVacancies
   // private var layoutManager: RecyclerView.LayoutManager? = null
   // private var adapter: RecyclerView.Adapter<RecyclerAdapterVacancies.MyViewHolder>? = null

/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

 */

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = FragmentVacanciesBinding.inflate(inflater, container, false)
/*
        val listOfTitles = listOf("Android trainee", "Web trainee", "Java back-end trainee", "IOS trainee")
        val listOfSubtitles = listOf("Cтажировка по направлению Android","Cтажировка по веб-программированию", "Cтажировка по направлению Java", "Cтажировка по направлению IOS")

        val recyclerView: RecyclerView? = view?.findViewById(R.id.recyclerView)
       // binding.recyclerView: RecyclerView = LinearLayoutManager(this)

        // recyclerView?.layoutManager = LinearLayoutManager(context)
        val manager = LinearLayoutManager(context)

        recyclerView?.layoutManager = manager
        recyclerView?.setHasFixedSize(true)
        val adapter = RecyclerAdapterVacancies(listOfTitles, listOfSubtitles)
        recyclerView?.adapter = adapter

 */
      //  recyclerView?.adapter = RecyclerAdapterVacancies(listOfTitles, listOfSubtitles)

      //  return inflater.inflate(R.layout.fragment_vacancies, container, false)
        return binding.root
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        // создаем список объектов вакансий для ресайклера
        val listOfTitles = listOf("Android trainee", "Web trainee", "Java back-end trainee", "IOS trainee", "Секретарша",
        "Водитель", "Стажер product maneger", "Уборщица", "Стажер-дворник", "Flutter trainee", "Стажер 1С", "Designer trainee",
        "Стажер-грузчик", "Стажер", "Стажер-летчик", "Стажер-копировщик", "Стажер-повар", "Стажер-инфоцыганин", "Стажер-психолог",
        "Стажер-инженер-кораблестроитель")
        val listOfSubtitles = listOf("Cтажировка по направлению Android","Cтажировка по веб-программированию", "Cтажировка по направлению Java",
            "Cтажировка по направлению IOS", "Стажировка для секретарши", "Стажировка по вождению", "Стажировка по продукт-менеджементу",
        "Стажировка для уборщица", "Стажировка для дворника", "Стажировка по флаттеру", "Стажировка по 1С", "Стажировка по дизайну",
        "Стажировка для грузчика", "Просто стажировка", "Летная стажировка", "Стажировка по копировальному делу", "Стажировка по кулинарному искусству",
        "Обучение по созданию курсов", "Стажировка для психологов", "Стажировка по направлению кораблестроение")
        val listOfViews = CustomViews.Base().createListOfCustomViews(listOfTitles,listOfSubtitles)



        val layoutManager = LinearLayoutManager(context)
       // recyclerView = view.findViewById(R.id.recycler_view)
        val recyclerView: RecyclerView? = view?.findViewById(R.id.recycler_view)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.setHasFixedSize(true)
      //  recyclerView?.adapter = RecyclerAdapterVacancies(listOfTitles, listOfSubtitles)
        recyclerView?.adapter = RecyclerAdapterVacancies(listOfViews)
/*
        val recyclerView: RecyclerView? = view?.findViewById(R.id.recycler_view)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerAdapterVacancies(listOfTitles, listOfSubtitles)

 */


        }
    }


// app:layoutManager="LinearLayoutManager"


// RecyclerView: No adapter attached

/*
        binding.CustomView.setTitle("Android trainee")
        binding.CustomView.setSubTitle("Cтажировка по направлению Android")

        binding.CustomView2.setTitle("Web trainee")
        binding.CustomView2.setSubTitle("Cтажировка по веб-программированию")

        binding.CustomView3.setTitle("Java back-end trainee")
        binding.CustomView3.setSubTitle("Cтажировка по направлению Java")

        binding.CustomView4.setTitle("IOS trainee")
        binding.CustomView4.setSubTitle("Cтажировка по направлению IOS")

 */

/*
копия разметки

<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:id="@+id/fragment_vacancies"
    android:orientation="vertical"
    tools:context=".VacanciesFragment">


    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/recyclerView"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />
    </androidx.constraintlayout.widget.ConstraintLayout>
<!--    -->
<!--    <androidx.recyclerview.widget.RecyclerView-->
<!--        android:id="@+id/recyclerView"-->
<!--        android:layout_width="wrap_content"-->
<!--        android:layout_height="wrap_content"-->
<!--        android:layout_marginBottom="8dp"-->
<!--        android:layout_marginEnd="8dp"-->
<!--        android:layout_marginStart="8dp"-->
<!--        android:layout_marginTop="8dp"-->
<!--        tools:listitem="@layout/custom_view"-->
<!--        android:scrollbars="horizontal"-->
<!--        />-->

</FrameLayout>


<!--<com.tarasov_denis.tarasov_lesson2.CustomView-->
<!--android:id="@+id/CustomView"-->
<!--android:layout_width="398dp"-->
<!--android:layout_height="82dp"-->
<!--android:layout_marginBottom="20dp"-->
<!--    />-->
 */

