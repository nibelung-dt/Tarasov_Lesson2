package com.tarasov_denis.tarasov_lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.tarasov_denis.tarasov_lesson2.databinding.ActivityMainBinding
import com.tarasov_denis.tarasov_lesson2.navigator



// splashscreen https://habr.com/ru/post/345380/
/*
навигация
https://developer.android.com/guide/navigation/navigation-conditional

про фрагменты
https://www.kodeco.com/1364094-android-fragments-tutorial-an-introduction-with-kotlin#toc-anchor-012

https://github.com/codexpedia/android_basic_single_activity_fragments/blob/main/app/src/main/java/com/example/cupcake/MainActivity.kt

 сделать splashscreen с помощью handler
 https://www.youtube.com/watch?v=SJCpIr7uHyE

 */


/*
1) экран авторизации
2) главная страница
3) экран со списком вакансий
4) экран со списком офисов
5) экран с информацией по отдельным офисам
 */

/*
ок 1) сделать программный запуск фрагмента Авторизации
ок 2) настроить запуск фрагментов через кнопки
ок 3) сделать binding
ок 4) заставить работать свой интерфейс Navigator
ок 5) создать тулбар
ок 6) сделать так, чтобы тулбар не показывался в окне авторизации
ок 7) navigation bar должен отображаться на всех трех фрагментах
ок 8) доработать фрагмент с вакансиями
ok 9) научиться получать текст из EditView окна авторизации

---25.02---
ок 10) настроить TextWatcher для окна авторизации
ок 11) при неверном пароле поле “Пароль” должно переходить в состояние ошибки, подсвечивать подсказку красным “неверный пароль”
ок 12) кнопка "Войти" должна быть полупрозрачной, если она в неактивном состоянии
ок 13) добавил валидацию логина
ок 13) создать прогрессбар для окна авторизации
ок 14) подвинуть контейнер под тулбар (потратил на это больше часа:(
ок 15) сделать экран со списком вакансий на RecyclerView (минимум 20 элементов)

---26.02---
ок 16) менять title у тулбара
ок 17) RecyclerView не отображает вакансии через мои CustomView
ок 18) сделать экран со списком офисов на RecyclerView
ок 19) создать фрагмент для подробной информации о каждом офисе

20) при нажатии на вьюшку с офисом переходим на экран детальной информации об офисе (DetailOfficeFragment)
21) на тулбаре DetailOfficeFragment должна появить кнопка "назад"
21) на экране с вакансиями реализовать возможность фильтра элементов по ключевому слову технологии (Android, Java и т.д.)


22) сделать splashscreen

23) кнопка "Войти" должна быть по умолчанию полупрозрачной и иметь цвет #2987E4, а у меня она серая
24) исправить цвета у navigation bar
25) сделать сохранение состояния фрагментов при перевороте экрана


FragmentManager.popBackStack()
setPrimaryNavigationFragment()

supportFragmentManager.commit {
  replace<ExampleFragment>(R.id.fragment_container)
  setReorderingAllowed(true)
  addToBackStack("replacement")
}


 */


class MainActivity : AppCompatActivity(), Navigator {

    private lateinit var binding: ActivityMainBinding

    /*
    final Fragment fragment1 = new HomeFragment();
final Fragment fragment2 = new DashboardFragment();
final Fragment fragment3 = new NotificationsFragment();
final FragmentManager fm = getSupportFragmentManager();
Fragment active = fragment1;

     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        // setContentView(R.layout.activity_main)
        // setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
       // title = "Aston intensive"


        binding.bottomNavigationView.visibility = View.INVISIBLE
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.mainPage -> {
                    goToMainFragment()
                    true
                }
                R.id.vacancyPage -> {
                    goToVacancies()
                    true
                }
                R.id.officePage -> {
                    goToOffices()
                    true
                }
                else -> false
            }
        }
      //  val fragmentManager = FragmentManager()
       // val binding = ActivityMainBinding.inflate(layoutInflater)
      //  setContentView(binding.root)

         val authorizationFragment = AuthorizationFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, authorizationFragment)
            .commit()


    }
/*
    fun setTitleToolbar(title: String) {
        binding.toolbar.title = title
    }
 */
    override fun goToMainFragment() {
        binding.toolbar.title = "Главная страница"
        launchFragmentForOnce(MainFragment())
        binding.bottomNavigationView.visibility = View.VISIBLE
    }

    override fun goToOffices() {
        binding.toolbar.title = "Офисы"
        launchFragment(OfficesFragment())
    }

    override fun goToVacancies() {
        binding.toolbar.title = "Вакансии"
        launchFragment(VacanciesFragment())
    }

    fun launchFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container_view, fragment)
            .commit()
        // нужно, чтобы в стэке всегда был только один фрагмент - главная страница
    }

    fun launchFragmentForOnce(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            //.addToBackStack(null)
            .replace(R.id.fragment_container_view, fragment)
            .commit()
        // как не добавлять в бэкстэк?
    }


}

// копия разметки
// <androidx.constraintlayout.widget.ConstraintLayout
/*
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
 */

/*
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">


    <androidx.appcompat.widget.Toolbar
    android:id="@+id/toolbar"
    android:layout_width="0dp"
    android:layout_height="?android:attr/actionBarSize"
    android:background="#2987E4"
    tools:title="Aston intensive"
    app:titleTextColor="@color/white"
    app:navigationIconTint="@color/white" />

    <androidx.fragment.app.FragmentContainerView
        android:id="@+id/fragment_container_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        tools:context=".MainActivity">

    </androidx.fragment.app.FragmentContainerView>

<!--    android:name="com.tarasov_denis.tarasov_lesson2.MainFragment"-->
    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottomNavigationView"
        android:layout_width="367dp"
        android:layout_height="62dp"
        android:layout_marginStart="34dp"
        android:layout_marginEnd="51dp"
        app:menu="@menu/bottom_nav_menu">
<!--        android:background="#2987E4"-->

    </com.google.android.material.bottomnavigation.BottomNavigationView>


</LinearLayout>
 */