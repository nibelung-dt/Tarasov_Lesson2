package com.tarasov_denis.tarasov_lesson2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.tarasov_denis.tarasov_lesson2.SecondActivity.text.editText1
// import androidx.activity.result.ActivityResultLauncher
// import androidx.activity.result.contract.ActivityResultContracts

class SecondActivity : AppCompatActivity() {

    object text {
        var editText1 = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val contract = CustomContract()

        val backToFirstActivity = findViewById<Button>(R.id.backToFirstActivity)
        val editView = findViewById<EditText>(R.id.editView)


        backToFirstActivity.setOnClickListener {
            editText1 = editView.getText().toString()
            startActivity(contract.createIntent(this, editText1))
        }

    }
}
