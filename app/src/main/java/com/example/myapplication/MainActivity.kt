package com.example.myapplication

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.ComponentActivity
import android.graphics.Color

class MainActivity : ComponentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val but: Button = findViewById(R.id.button)
        // Установка обработчика нажатия на кнопку
        but.setOnClickListener{
            // Инициализация TimePickerFragment
            val newFragment = TimePickerFragment()
            // Вывод timePickerDialog
            newFragment.show(fragmentManager, "Time Picker")
        }
    }
}