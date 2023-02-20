package com.tarasov_denis.tarasov_lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tarasov_denis.tarasov_lesson2.databinding.ActivityMainBinding
import com.tarasov_denis.tarasov_lesson2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
   // lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

      //  binding = ActivitySecondBinding.inflate(layoutInflater)
       // setContentView(binding.root)

        val customView = findViewById<CustomView>(R.id.CustomView)
       customView.setTitle("(test) Android trainee") // set title
       customView.setSubTitle("(test) Cтажировка по направлению Android (test)") // set subTitle

/*
        binding.run {
            customView.setTitle("text") // set title
            customView.setSubTitle("text2") // set subTitle
        }
        */
    }

}