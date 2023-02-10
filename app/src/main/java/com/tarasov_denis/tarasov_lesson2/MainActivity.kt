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
        val changeLanguageButton = findViewById<Button>(R.id.changeLanguage)

        goToSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        changeLanguageButton.setOnClickListener {
            fun changeLanguage() {

            }
        }


    }

}

/*
    1) смена языка
    2) сохранение переменных
 */