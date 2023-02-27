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

}