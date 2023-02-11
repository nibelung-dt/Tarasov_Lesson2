package com.tarasov_denis.tarasov_lesson2

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

const val DATA = "data"
const val INPUT_DATA = "input_data"

// https://proandroiddev.com/activity-result-api-the-clean-way-697bb120c98d

class CustomContract : ActivityResultContract<String, String?>() {

    override fun createIntent(context: Context, input: String): Intent {
        val intent = Intent(context, MainActivity::class.java)
        intent.putExtra(INPUT_DATA, input)
        return intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        return when (resultCode) {
            //Transforming our result to required format before returning it
            Activity.RESULT_OK -> intent?.getStringExtra(DATA)
            else -> null
        }
    }



}