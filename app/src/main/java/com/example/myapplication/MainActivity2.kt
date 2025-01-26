package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity2 : ComponentActivity() {

    private lateinit var number2: TextView
    private lateinit var message2: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        number2 = findViewById(R.id.number)
        message2 = findViewById(R.id.message)

        val number = intent.getStringExtra("number") ?: "Не указано"
        val message = intent.getStringExtra("message") ?: "Не указано"

        // Устанавливаем данные в TextView
        this.number2.text = "Число: $number"
        this.message2.text = "Сообщение: $message"
    }
}