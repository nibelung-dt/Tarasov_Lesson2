package com.tarasov_denis.tarasov_lesson2

import androidx.fragment.app.Fragment

// typealias ResultListener<T> = (T) -> Unit

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {

    // fun goBack()

    fun goToMainFragment()

    fun goToOffices()

    fun goToVacancies()

/*
    // fun closeApp()
    class Base : Navigator {
        override fun goBack() {

        }

        override fun goToMainFragment() {
            val fragment_main = MainFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, fragment_main)
                .commit()
        }
    }

 */

}