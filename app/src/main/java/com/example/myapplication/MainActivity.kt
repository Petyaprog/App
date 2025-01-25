package com.example.myapplication

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.core.app.NotificationCompat

class MainActivity : ComponentActivity() {

    private lateinit var button: Button

    @SuppressLint("MissingInflatedId", "SetTextI18n", "PrivateResource")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)

        val channelId = "my_channel_id"
        val channelName = "My Channel"

        // Создание NotificationManager
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Создание канала уведомлений (для Android 8.0 и выше)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        button.setOnClickListener {
            // Создание уведомления
            val notification = NotificationCompat.Builder(this, channelId)
                .setContentTitle("Заголовок уведомления")
                .setContentText("Текст уведомления")
                .setSmallIcon(android.R.drawable.sym_def_app_icon) // Замените на ваш иконку
                .setAutoCancel(true) // Уведомление исчезнет при нажатии
                .build()

            // Отправка уведомления
            notificationManager.notify(1, notification)
        }
    }

}