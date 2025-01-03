package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var add: Button
    private lateinit var subtr: Button
    private lateinit var mul: Button
    private lateinit var divide: Button
    private lateinit var answer: TextView
    private lateinit var arg1: EditText
    private lateinit var arg2: EditText

    private fun calc(operation: ((Int, Int) -> Int)) =
        answer.setText(
            try{
                operation(arg1.text.toString().toInt(), arg2.text.toString().toInt()).toString()
        } catch (e: NumberFormatException) {"Input Error"}
            catch(e: ArithmeticException) {"Div by zero"}
        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add = findViewById(R.id.add)
        subtr = findViewById(R.id.subtr)
        mul = findViewById(R.id.mul)
        divide = findViewById(R.id.divide)
        answer = findViewById(R.id.answer)
        arg1 = findViewById(R.id.arg1)
        arg2 = findViewById(R.id.arg2)

        add.setOnClickListener { calc {a, b -> a + b}}
        subtr.setOnClickListener { calc {a, b -> a - b}}
        mul.setOnClickListener { calc { a, b -> a * b }}
        divide.setOnClickListener { calc { a, b -> a / b }}
    }
}
