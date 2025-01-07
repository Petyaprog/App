package com.example.myapplication

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.ComponentActivity
import android.graphics.Color
import android.widget.ProgressBar
import android.widget.TextView
import java.util.Timer
import java.util.TimerTask

enum class TaskState {
    FREE,
    PRE_WORKING,
    CONNECTING,
    POST_WORKING,
    COMPLETED
}

class MainActivity : ComponentActivity() {

    private lateinit var but: Button
    private lateinit var tw: TextView
    private lateinit var bar: ProgressBar
    private lateinit var timer: Timer
    private var taskProgress = 0
    private var taskState: TaskState = TaskState.FREE

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        but = findViewById(R.id.button)
        tw = findViewById(R.id.textView2)
        bar = findViewById(R.id.progressBar)
        timer = Timer()

        but.setOnClickListener {
            timer.scheduleAtFixedRate(object : TimerTask() {
                override fun run() {
                    when (taskState) {
                        TaskState.FREE -> {
                            taskState = TaskState.PRE_WORKING
                            ++taskProgress

                            tw.text = "Working..."
                            bar.progress = taskProgress
                        }

                        TaskState.PRE_WORKING -> {
                            if (taskProgress < 50) {
                                ++taskProgress

                                bar.progress = taskProgress
                            } else {
                                taskState = TaskState.CONNECTING

                                tw.text = "Connecting to server..."

                                bar.isIndeterminate = true

                                Thread.sleep(5000)

                            }
                        }

                        TaskState.CONNECTING -> {
                            taskState = TaskState.POST_WORKING
                            ++taskProgress

                            tw.text = "Working..."
                            bar.isIndeterminate = false
                            bar.progress = taskProgress
                        }

                        TaskState.POST_WORKING -> {
                            if (taskProgress < 100) {
                                ++taskProgress

                                bar.progress = taskProgress
                            } else {
                                tw.text = "Completed!"
                                taskState = TaskState.COMPLETED
                            }
                        }

                        TaskState.COMPLETED -> {
                            timer.cancel()
                        }
                    }
                }
            }, 1000, 250)
        }
    }
}