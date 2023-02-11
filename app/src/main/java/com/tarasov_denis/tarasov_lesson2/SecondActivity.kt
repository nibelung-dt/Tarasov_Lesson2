package com.tarasov_denis.tarasov_lesson2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.tarasov_denis.tarasov_lesson2.SecondActivity.text.editText1

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
        val editText = editView.getText() // введенный текст запишется в переменную?
        editText1 = editText.toString()

        backToFirstActivity.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            //startActivity(intent)
            editText1 = editText.toString()
            startActivity(contract.createIntent(this, editText.toString()))
            Toast.makeText(applicationContext, editText1, Toast.LENGTH_SHORT).show()


        }
/*
        val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            // Handle the returned Uri
        }
*/

//        editView.freezesText = true

    }
}

// getText
// 	setFreezesText