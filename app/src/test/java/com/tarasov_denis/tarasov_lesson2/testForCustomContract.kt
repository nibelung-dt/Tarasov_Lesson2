package com.tarasov_denis.tarasov_lesson2


import org.junit.Test

import org.junit.Assert.*

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract


class TestForCustomContract {

    val contract = CustomContract()
    // contract.createIntent(SecondActivity.class, "ddd")

    @Test
    fun testCreateIntent() {
        val expectedResult = "hello"

       // assertEquals(4, 2 + 2)
    }



}