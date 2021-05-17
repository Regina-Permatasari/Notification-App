package com.regina.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    private lateinit var notificationManager: NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = NotificationManagerCompat.from(this )

        val btnSend1: Button = findViewById(R.id.btnSend1)
        btnSend1.setOnClickListener {
            val etTitle: EditText = findViewById(R.id.etTitle)
            val title = etTitle.text.toString()
            val etMessage: EditText = findViewById(R.id.etMessage)
            val message = etMessage.text.toString()
            val builder = NotificationCompat.Builder(this,BaseApplication.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_favorite)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)

            val notification = builder.build()
            notificationManager.notify(1, notification)
        }

        val btnSend2: Button = findViewById(R.id.btnSend2)
        btnSend2.setOnClickListener {
            val etTitle: EditText = findViewById(R.id.etTitle)
            val title = etTitle.text.toString()
            val etMessage: EditText = findViewById(R.id.etMessage)
            val message = etMessage.text.toString()
            val builder = NotificationCompat.Builder(this, BaseApplication.CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_favorite)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)

            val notification = builder.build()
            notificationManager.notify(2, notification)
        }
    }
}