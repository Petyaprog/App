package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var allSpinners: Array<Array<Spinner>>
    val toChooseList: List<String> = listOf(" ", "X", "0")

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        allSpinners = Array(4) { Array(4) { Spinner(this) } }

        allSpinners[1][1] = findViewById(R.id.spinner1)
        allSpinners[1][2] = findViewById(R.id.spinner2)
        allSpinners[1][3] = findViewById(R.id.spinner3)
        allSpinners[2][1] = findViewById(R.id.spinner4)
        allSpinners[2][2] = findViewById(R.id.spinner5)
        allSpinners[2][3] = findViewById(R.id.spinner6)
        allSpinners[3][1] = findViewById(R.id.spinner7)
        allSpinners[3][2] = findViewById(R.id.spinner8)
        allSpinners[3][3] = findViewById(R.id.spinner9)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, toChooseList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        for (i in 1..3) {
            for (j in 1..3) {
                allSpinners[i][j].setAdapter(adapter)
            }
        }

    }
}