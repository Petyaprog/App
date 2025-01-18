package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.GridView
import android.widget.ListView
import android.widget.ScrollView
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var gridView: GridView

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.gridview)
        val numbers = MutableList(31, { "$it" })
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, numbers)
        gridView.adapter = adapter
        gridView.columnWidth = 100
        gridView.numColumns = 4
        gridView.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
            numbers.removeAt(position)
            adapter.notifyDataSetChanged()
        }

    }
}