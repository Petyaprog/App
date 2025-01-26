package com.example.myapplication

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.core.app.NotificationCompat

class MainActivity : ComponentActivity() {

    private lateinit var button: Button
    private lateinit var number: EditText
    private lateinit var message: EditText

    @SuppressLint("MissingInflatedId", "SetTextI18n", "PrivateResource")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        number = findViewById(R.id.number1)
        message = findViewById(R.id.message1)

        val channelId = "my_channel_id"
        val channelName = "My Channel"

        val notificationManager = getSystemService(NotificationManager::class.java)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java).apply {
                putExtra("number", number.text.toString())
                putExtra("message", message.text.toString())
            }
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

            val notification = NotificationCompat.Builder(this, channelId)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setAutoCancel(true)
                .setContentTitle("Заголовок")
                .setContentText("Переход")
                .setContentIntent(pendingIntent)
                .build()
            notificationManager.notify(1, notification)
        }
    }
}
