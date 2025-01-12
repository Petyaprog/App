package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var but: Button
    private lateinit var tw: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        but = findViewById(R.id.button)

        but.setOnClickListener {
            val myintent = Intent(this, MainActivity2::class.java)
            startActivityForResult(myintent, 1)
        }
    }

    @Deprecated("Deprecated in Java")
    @SuppressLint("MissingSuperCall", "SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        tw = findViewById(R.id.textView)
        if (data == null) return
        when(requestCode) {
            1 -> tw.text = data.getStringExtra("name")
            else -> tw.text = "Different request code $requestCode"
        }
    }
}