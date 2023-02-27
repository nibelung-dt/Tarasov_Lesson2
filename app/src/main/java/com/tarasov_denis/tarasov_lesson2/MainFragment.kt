package com.tarasov_denis.tarasov_lesson2

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.tarasov_denis.tarasov_lesson2.databinding.FragmentMainBinding
// import android.view.View
// import android.view.ViewGroup

/*

2.	Главная страница
-	за основу главного экрана взять экран из домашнего задания №3, без кнопок  списка офисов.

На экране должен отображаться bottom navigation bar. С 3 вкладками: главная страница, список вакансий,
список офисов.

Ресурсы для иконок меню можно брать произвольно. Цвет меню - цвет главной темы из ДЗ №3
-	при нажатии на системную кнопку “назад” (на тулбаре кнопки назад быть не должно,
речь про кнопку “назад” в нижней навигационной панели”) должен осуществляться выход из приложения

https://www.geeksforgeeks.org/bottom-navigation-bar-in-android/

 */

// https://www.geeksforgeeks.org/bottom-navigation-bar-in-android/

/*
фрагменты с навигацией
https://github.com/mitchtabian/Navigation-Components-Example/blob/master/app/src/main/java/com/codingwithmitch/navigationcomponentsexample/MainFragment.kt

про navComponent
https://developer.android.com/guide/navigation/navigation-getting-started

 https://startandroid.ru/ru/courses/architecture-components/27-course/architecture-components/557-urok-24-android-navigation-component-vvedenie.html
https://www.fandroid.info/12-navigation-architecture-component/

 */

class MainFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainBinding.inflate(inflater, container, false)

       // return inflater.inflate(R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}