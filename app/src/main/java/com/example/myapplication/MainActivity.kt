package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var listView: ListView
    private lateinit var seekBar: SeekBar
    private lateinit var adapter: ArrayAdapter<String>
    private val squaresList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        seekBar = findViewById(R.id.seekBar)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, squaresList)
        listView.adapter = adapter

        // Установка слушателя на SeekBar
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                updateList(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Не требуется
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Не требуется
            }
        })
    }

    private fun updateList(value: Int) {
        squaresList.clear() // Очищаем текущий список
        if (value > 0) {
            for (i in 1..value) {
                squaresList.add((i * i).toString()) // Добавляем квадрат числа
            }
        }
        adapter.notifyDataSetChanged() // Обновляем адаптер
    }
}