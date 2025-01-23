package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File

class MainActivity : ComponentActivity() {

    private lateinit var filepath: EditText
    private lateinit var result: TextView
    private lateinit var perform: Button

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        filepath = findViewById(R.id.editTextText)
        result = findViewById(R.id.textView)
        perform = findViewById(R.id.button)

        val fileName = "fileName"
        val fileContent = "Привет"
        this.openFileOutput(fileName, Context.MODE_PRIVATE).write(fileContent.toByteArray())

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            perform.setOnClickListener {
                if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
                    result.text = File(
                        Environment.getExternalStorageDirectory(),
                        filepath.text.toString()
                    ).readText()
                }
            }
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        }

    }

}