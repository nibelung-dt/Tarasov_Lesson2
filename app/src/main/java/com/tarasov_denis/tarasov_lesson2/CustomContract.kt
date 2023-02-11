package com.tarasov_denis.tarasov_lesson2

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

const val DATA = "data"
const val INPUT_DATA = "input_data"

class CustomContract : ActivityResultContract<String, String?>() {

    override fun createIntent(context: Context, input: String): Intent {
        val intent = Intent(context, MainActivity::class.java)
        intent.putExtra(INPUT_DATA, input)
        return intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        return when (resultCode) {
            Activity.RESULT_OK -> intent?.getStringExtra(DATA)
            else -> null
        }
    }
    
}