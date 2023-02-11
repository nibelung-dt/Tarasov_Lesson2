package com.tarasov_denis.tarasov_lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.tarasov_denis.tarasov_lesson2.SecondActivity.text.editText1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goToSecondActivity = findViewById<Button>(R.id.goTo)

        val textView = findViewById<TextView>(R.id.textView)

        if (editText1 != "") {
            Toast.makeText(applicationContext, editText1, Toast.LENGTH_SHORT).show()
            textView.setText(editText1)
        }

        goToSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

// val changeLanguageButton = findViewById<Button>(R.id.changeLanguage)
/*
        changeLanguageButton.setOnClickListener {
            //fun changeLanguage() {
                // Toast.makeText(this, editText1)
                Toast.makeText(applicationContext, editText1, Toast.LENGTH_SHORT).show()
                textView.setText(editText1)
                // Toast.makeText(applicationContext, text, duration).show(
        }
*/

    }

}

/*
    1) смена языка
    2) сохранение переменных

    добавить в build.gradle:
    resConfigs "en", "fr"
 */