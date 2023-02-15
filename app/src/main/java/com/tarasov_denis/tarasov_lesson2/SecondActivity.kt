package com.tarasov_denis.tarasov_lesson2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

// import com.tarasov_denis.tarasov_lesson2.SecondActivity.text.editText1
// import androidx.activity.result.ActivityResultLauncher
// import androidx.activity.result.contract.ActivityResultContracts

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val backToFirstActivity = findViewById<Button>(R.id.backToFirstActivity)


        backToFirstActivity.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

    }
}
