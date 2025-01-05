package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var tw: TextView
    private lateinit var et: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tw = findViewById(R.id.textView1)
        et = findViewById(R.id.editText1)

        var counter = 0

        et.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                var text = s.toString()
                when {
                    text.contains("question") -> {
                        text = text.replaceFirst("question", "answer")
                        counter++
                        tw.text = "$counter"
                        et.setText(text)
                        et.setSelection(et.length())
                    }

                    text.contains("request") -> {
                        text = text.replaceFirst("request", "response")
                        counter++
                        tw.text = "$counter"
                        et.setText(text)
                        et.setSelection(et.length())
                    }

                    text.contains("problem") -> {
                        text = text.replaceFirst("problem", "task")
                        counter++
                        tw.text = "$counter"
                        et.setText(text)
                        et.setSelection(et.length())
                    }
                }
            }
        })
    }
}
