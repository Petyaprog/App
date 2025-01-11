package com.example.myapplication

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var Text: EditText
    private lateinit var stats: TextView
    private lateinit var word_count: TextView
    private lateinit var save: Button
    private lateinit var load: Button
    private lateinit var clear: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Text = findViewById(R.id.editText)
        stats = findViewById(R.id.stats_view)
        word_count = findViewById(R.id.unsaved_changes_view)
        save = findViewById(R.id.save_button)
        load = findViewById(R.id.load_button)
        clear = findViewById(R.id.clear_button)

        var saved_text: String? = null
        Text.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val s = Text.text.toString().split("[^a-zA-Zа-яА-я0-9_]+".toRegex()).filter { it != "" }
                word_count.text = "${s.size}"

                if (Text.text.toString() != saved_text)
                    stats.text = "Unsaved changes"
                else stats.text = "All changes saved"
            }
        })

        save.setOnClickListener {
            saved_text = Text.text.toString()
            stats.text = "All changes saved"
        }

        load.setOnClickListener {
            Text.setText("$saved_text")
        }

        clear.setOnClickListener {
            Text.setText("")
        }
    }
}