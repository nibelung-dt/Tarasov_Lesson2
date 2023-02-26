package com.tarasov_denis.tarasov_lesson2

import android.content.ContentValues.TAG
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.FragmentManager
import com.tarasov_denis.tarasov_lesson2.databinding.FragmentAutorizationBinding
import kotlinx.coroutines.delay


// authorization
// https://developer.alexanderklimov.ru/android/layout/textinputlayout.php
// https://developer.android.com/reference/com/google/android/material/textfield/TextInputLayout
/*
https://www.youtube.com/watch?v=Ct6HH7nwdmA&t=2155s
https://github.com/JohnnySC/PicsAndLoginTestApp/tree/master/app/src/main/res/layout

https://www.youtube.com/watch?v=kMGSnq0H8E8

вариант с созданием валидатора пароля. Используется паттерн observer и textwacher
https://github.com/gbindinazeez/PasswordValidator/blob/master/app/src/main/java/com/bignerdranch/android/passwordvalidator/Validator.kt

 */


/**
 * A simple [Fragment] subclass.
 * Use the [AuthorizationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

private const val username = "Denis"
private const val password = "kotlin"

class AuthorizationFragment : Fragment() {

/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
 */

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        val binding = FragmentAutorizationBinding.inflate(inflater, container, false)
// нужно использовать PasswordTransformationMethod, чтобы в EditView показывался и сразу скрывался каждый из введенных символов.
// Этот класс наследуется от TransformationMethod и TextWatcher
        // https://developer.android.com/reference/kotlin/android/text/method/PasswordTransformationMethod
        val textChangedListener = object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.enterPassword1.hint = "password"
                binding.enterButton.background = Color.parseColor("#80000000").toDrawable()

                binding.enterUsername1.hint = "username"
                binding.enterUsername.background = Color.parseColor("#80000000").toDrawable()
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.enterPassword.text.toString() != "") {
                    binding.enterButton.isEnabled = true
                    binding.enterButton.background = Color.parseColor("#000000").toDrawable()
                }
            }
        }


        binding.enterPassword.addTextChangedListener(textChangedListener)
        /*
        binding.enterPassword.addTextChangedListener(object : TextWatcher {
        })
         */

        binding.enterButton.setOnClickListener {
           // Log.d("to MainFragment", text)
         //   Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
            var isValid = validate(binding.enterUsername.text.toString(), username, binding.enterPassword.text.toString(), password)




            when(isValid) {
                "allValid" -> runProgressBar(binding)
                "passwordInvalid" -> {binding.enterPassword1.hint = "Неверный пароль" ; binding.enterPassword.background = Color.parseColor("#F83E24").toDrawable()}
                "usernameInvalid" -> {binding.enterUsername1.hint = "Неверный логин" ; binding.enterUsername.background = Color.parseColor("#F83E24").toDrawable()}
                "usernameAndPasswordInvalid" -> {binding.enterPassword1.hint = "Неверный пароль" ; binding.enterPassword.background = Color.parseColor("#F83E24").toDrawable() ;
                    binding.enterUsername1.hint = "Неверный логин" ; binding.enterUsername.background = Color.parseColor("#F83E24").toDrawable()}
            }
            /*
            if (binding.enterUsername.text.toString() == username && binding.enterPassword.text.toString() == password) {
                navigator().goToMainFragment()
            } else {
                binding.enterPassword1.hint = "Неверный пароль"
                binding.enterPassword.background = Color.parseColor("#F83E24").toDrawable()
            }

             */
        }
       // return inflater.inflate(R.layout.fragment_autorization, container, false)
        return binding.root
    }

    fun validate(username: String, usernameConst: String, password: String, passwordConst: String): String {
        return when {
             username == usernameConst &&  password == passwordConst -> "allValid"
             username == usernameConst &&  password != passwordConst -> "passwordInvalid"
             username != usernameConst &&  password == passwordConst -> "usernameInvalid"
             username != usernameConst &&  password != passwordConst -> "usernameAndPasswordInvalid"
            else -> "ok"
        }
    }

    fun runProgressBar(binding: FragmentAutorizationBinding) {
        binding.progressBar.visibility = View.VISIBLE
        binding.enterButton.isEnabled = false
        Handler(Looper.getMainLooper()).postDelayed(Runnable { navigator().goToMainFragment() }, 3000)

    }




}

/*

<!--    <com.google.android.material.textfield.TextInputLayout-->
<!--        android:layout_width="match_parent"-->
<!--        android:layout_height="match_parent">-->

<!--        <com.google.android.material.textfield.TextInputEditText-->
<!--            android:layout_width="match_parent"-->
<!--            android:layout_height="wrap_content"-->
<!--            android:hint="hint" />-->
<!--    </com.google.android.material.textfield.TextInputLayout>-->

<!--    <TextView-->
<!--        android:layout_width="match_parent"-->
<!--        android:layout_height="50dp"-->
<!--        android:text="Вход"-->
<!--        android:gravity="center"-->
<!--        android:textSize="30sp"/>-->

<!--    <EditText-->
<!--        android:id="@+id/editText1"-->
<!--        android:layout_width="match_parent"-->
<!--        android:layout_height="50dp"-->
<!--        android:layout_weight="1"-->
<!--        android:hint="TextView"-->
<!--        android:inputType="text"-->
<!--        android:gravity="center"-->
<!--        android:freezesText="true"/>-->

<!--    <EditText-->
<!--        android:id="@+id/editText2"-->
<!--        android:layout_width="match_parent"-->
<!--        android:layout_height="50dp"-->
<!--        android:layout_weight="1"-->
<!--        android:hint="TextView"-->
<!--        android:gravity="center"-->
<!--        android:freezesText="true"/>-->

<!--    <Button-->
<!--        android:id="@+id/enter"-->
<!--        android:layout_width="match_parent"-->
<!--        android:layout_height="wrap_content"-->
<!--        android:text="Войти" />-->
 */



/*

 int position=getArguments().getInt(KEY_POSITION, -1);
  View result;

  if (position==2) {
   ViewGroup doctorNo=new NoAssistFrameLayout(getActivity());
   inflater.inflate(R.layout.editor, doctorNo);
   result=doctorNo;
  }
  else {
   result=inflater.inflate(R.layout.editor, container, false);
  }

  EditText editor=result.findViewById(R.id.editor);

  editor.setHint(getTitle(getActivity(), position));

  if (position==1) {
   editor.
    setTransformationMethod(PasswordTransformationMethod.
     getInstance());
  }

  return(result);
 */