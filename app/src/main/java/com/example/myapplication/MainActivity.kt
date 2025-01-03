package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var but1: Button
    private lateinit var tw: TextView
    private lateinit var et: EditText

    private fun button_click_handler(v: View) {
        val inputText = et.text.toString()
        tw.text = inputText
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        but1 = findViewById(R.id.button1)
        tw = findViewById(R.id.textView)
        et = findViewById(R.id.editTextText)

        but1.setOnClickListener(this::button_click_handler)

    }
}
