package com.example.myapplication

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var status: TextView
    private lateinit var editText: EditText
    private lateinit var editText2: EditText

    @SuppressLint("SetTextI18n")
    private fun convert(Flag: Boolean) {
        val inchesInKilometer = 39370
        if (Flag) {
            val inchesOfString: String = editText.text.toString()
            val inchesOfFloat: Float? = inchesOfString.toFloatOrNull()
            if (inchesOfFloat != null) {
                status.text = ""
                var result: Float = inchesOfFloat / inchesInKilometer
                editText2.setText(result.toString())
            } else { status.text = "error" }
        } else {
            val kilometersOfString: String = editText2.text.toString()
            val kilometersOfFloat: Float? = kilometersOfString.toFloatOrNull()
            if (kilometersOfFloat != null) {
                status.text = ""
                val inches: Float = kilometersOfFloat * inchesInKilometer
                editText.setText(inches.toString())
            } else { status.text = "error" }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        status = findViewById(R.id.textView)
        editText = findViewById(R.id.editTextText)
        editText2 = findViewById(R.id.editTextText2)

        editText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (editText.isFocused) {
                    // true - 1st editText, false - 2nd editText
                    convert(true)
                }
            }
        })

        editText2.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (editText2.isFocused) {
                    // true - 1st editText, false - 2nd editText
                    convert(false)
                }
            }
        })
    }
}