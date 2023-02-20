package com.tarasov_denis.tarasov_lesson2

import androidx.constraintlayout.widget.ConstraintLayout
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import com.tarasov_denis.tarasov_lesson2.databinding.CustomViewBinding


class CustomView (
    context: Context,
    attrs: AttributeSet?
) : ConstraintLayout(context, attrs) {

   private var binding: CustomViewBinding =
       CustomViewBinding.inflate(LayoutInflater.from(context), this) //, false)

/*
    init {
        addView(binding.root)
        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomView, 0, 0
        )

        binding.apply {
            //  val title = typedArray.getString(R.styleable.CustomView)
            //  val subTitle = typedArray.getString(R.styleable.CustomSwitch_cs_subtitle)
            titleTV.text = title
            subTitleTV.text = subTitle
        }
    }
 */

    fun setTitle(text: String) {
       // binding.title.text = text
        val title = findViewById<TextView>(R.id.title)
        title.text = text
    }

    fun setSubTitle(text: String) {
       // binding.subtitle.text = text
        val subtitle = findViewById<TextView>(R.id.subtitle) // textSubtitle
       subtitle.text = text
    }


/*
    binding.apply {
        val title = typedArray.getString(R.styleable.CustomView_android_title)
        val subTitle = typedArray.getString(R.styleable.CustomView_subtitle)
    }
 */

}