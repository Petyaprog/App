package com.example.myapplication

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var butAnswer: Button
    private lateinit var tvAnswer: TextView
    private lateinit var rgAnswers: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        butAnswer = findViewById(R.id.butAnswer)
        tvAnswer = findViewById(R.id.tvAnswer)
        rgAnswers = findViewById(R.id.rgAnswers)

        butAnswer.setOnClickListener{

            if (rgAnswers.checkedRadioButtonId == R.id.rbEllipsoid) tvAnswer.text = "Правильно"
            else tvAnswer.text = "Неправильно"
        }

    }
}