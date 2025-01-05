package com.example.myapplication

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.ComponentActivity
import android.graphics.Color


class MainActivity : ComponentActivity() {

    private lateinit var bt: Button
    private lateinit var root_layout: LinearLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt = findViewById(R.id.button)
        root_layout = findViewById(R.id.root_layout)

        bt.setOnClickListener{
            // Для создания AlertDialog используется внутренний класс AlertDialog.Builder
            val builder = AlertDialog.Builder(this@MainActivity)

            // Заголовок AlertDialog задаётся при помощи метода setTitle
            builder.setTitle("App background color")

            // Текст AlertDialog задаётся при помощи метода setMessage
            builder.setMessage("Are you want to set the app background color to RED?")

            // Установка текста кнопки соглашения в диалоге и обработчика по нажатию
            builder.setPositiveButton("YES"){dialog, which ->
                // Действия при нажатии кнопки соглашения в диалоге: всплывающее сообщение и смена цвета фона
                Toast.makeText(applicationContext,"Ok, we change the app background.",Toast.LENGTH_SHORT).show()
                root_layout.setBackgroundColor(Color.RED)
            }

            // Установка текста кнопки отказа в диалоге и обработчика по нажатию
            builder.setNegativeButton("No"){dialog,which ->
                Toast.makeText(applicationContext,"You are not agree.",Toast.LENGTH_SHORT).show()
            }

            // Установка текста кнопки отмены в диалоге и обработчика по нажатию
            builder.setNeutralButton("Cancel"){_,_ ->
                Toast.makeText(applicationContext,"You cancelled the dialog.",Toast.LENGTH_SHORT).show()
            }

            // Создание настроенного экземпляра AlertDialog
            val dialog: AlertDialog = builder.create()

            // Вывод на экран созданного AlertDialog
            dialog.show()
        }
    }
}