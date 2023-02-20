package com.tarasov_denis.tarasov_lesson2


import android.content.Intent
import android.graphics.Typeface
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contacts = findViewById<Button>(R.id.contacts)
        val vacancy = findViewById<Button>(R.id.vacancy)
        val gallery = findViewById<Button>(R.id.gallery)
        val offices = findViewById<TextView>(R.id.offices)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)

        contacts.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        /*
        contacts.setOnClickListener {
            contacts.visibility = View.INVISIBLE
            vacancy.visibility = View.INVISIBLE
            gallery.visibility = View.INVISIBLE
            offices.visibility = View.INVISIBLE
            button1.visibility = View.INVISIBLE
            button2.visibility = View.INVISIBLE
            button3.visibility = View.INVISIBLE
            button4.visibility = View.INVISIBLE
            button5.visibility = View.INVISIBLE
            progressBar.visibility = View.VISIBLE
        }
*/
        vacancy.setOnClickListener {
            contacts.visibility = View.INVISIBLE
            vacancy.visibility = View.INVISIBLE
            gallery.visibility = View.INVISIBLE
            offices.visibility = View.INVISIBLE
            button1.visibility = View.INVISIBLE
            button2.visibility = View.INVISIBLE
            button3.visibility = View.INVISIBLE
            button4.visibility = View.INVISIBLE
            button5.visibility = View.INVISIBLE
            progressBar.visibility = View.VISIBLE
        }

        gallery.setOnClickListener {
            contacts.visibility = View.INVISIBLE
            vacancy.visibility = View.INVISIBLE
            gallery.visibility = View.INVISIBLE
            offices.visibility = View.INVISIBLE
            button1.visibility = View.INVISIBLE
            button2.visibility = View.INVISIBLE
            button3.visibility = View.INVISIBLE
            button4.visibility = View.INVISIBLE
            button5.visibility = View.INVISIBLE
            progressBar.visibility = View.VISIBLE
        }

        // Не разобрался, как добавить пробелы в spannable. "\n" не работает

        // <b>ИТ-решения для\nразвития бизнеса</b>\nРазработка программного\nобеспечения
        val header = findViewById<TextView>(R.id.header)
        val spannable = SpannableString("ИТ-решения для развития бизнеса Разработка программного обеспечения")
        spannable.setSpan(
            StyleSpan(Typeface.BOLD),
            20, // start
            22, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
       // header.text = spannable


           // val intent = Intent(this, SecondActivity::class.java)
           // startActivity(intent)

    }
}

