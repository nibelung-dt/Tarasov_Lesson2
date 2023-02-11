package com.tarasov_denis.tarasov_lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.tarasov_denis.tarasov_lesson2.SecondActivity.text.editText1


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goToSecondActivity = findViewById<Button>(R.id.goTo)
        val textView = findViewById<TextView>(R.id.textView)

        if (editText1 != "") {
            textView.setText(editText1)
        }

        goToSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
