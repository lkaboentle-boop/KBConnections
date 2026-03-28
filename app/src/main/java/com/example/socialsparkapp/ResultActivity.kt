package com.example.socialsparkapp

import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val time = intent.getStringExtra("timeOfDay")
        val txtResult = findViewById<TextView>(R.id.txtResult)
        val imgResult = findViewById<ImageView>(R.id.imgResult)
        val btnSend = findViewById<Button>(R.id.btnSend)

        val suggestionText = when (time!!.trim()) {
            "Morning" -> "Send a 'Good Morning' Message to a family member or friend"
            "Mid-Morning" -> "Reach out to a friend or family member with a quick 'I love you'."
            "Afternoon" -> "Call a family member or friend and tell them about a funny meme."
            "Afternoon Snack" -> "Send a quick 'thinking about you' to a friend or family member"
            "Dinner" -> "Call a friend or family member for 5-minute to catch-up."
            "Night" -> "Send a 'Good Night,Sweet Dreams' Message to a family member or friend"

            else -> "Please enter valid Time(morning, mid-morning, afternoon, afternoon snack time, dinner night)"
        }
        txtResult.text = suggestionText

        btnSend.setOnClickListener {
            Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show()
            finish() // This takes you back to the MainActivity
        }
    }
}
