package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.ComponentActivity

class MainActivity2 : ComponentActivity() {

    private lateinit var but: Button
    private lateinit var editText: EditText

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        but = findViewById(R.id.button2)
        editText = findViewById(R.id.editTextText)

        but.setOnClickListener {
            val intent = Intent()
            intent.putExtra("name", editText.text.toString())
            setResult(1, intent)
            finish()
        }
    }
}