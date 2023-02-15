package com.tarasov_denis.tarasov_lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goToSecondActivity = findViewById<Button>(R.id.goTo)

        goToSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}

/*
https://github.com/murgupluoglu/flagkit-android
https://github.com/murgupluoglu/flagkit-android/blob/master/Flags.md


 */
