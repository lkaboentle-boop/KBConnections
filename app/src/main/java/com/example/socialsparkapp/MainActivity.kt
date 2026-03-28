package com.example.socialsparkapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val tvTime = findViewById<TextView>(R.id.tvTime)
        val chkMorning = findViewById<CheckBox>(R.id.chkMorning)
        val chkAfternoon = findViewById<CheckBox>(R.id.chkAfternoon)
        val chkNight = findViewById<CheckBox>(R.id.chkNight)
        val chkMidMorning = findViewById<CheckBox>(R.id.chkMidMorning)
        val chkAfternoonSnack = findViewById<CheckBox>(R.id.chkAfternoonSnack)
        val chkDinner = findViewById<CheckBox>(R.id.chkDinner)
        val btnSuggestion = findViewById<Button>(R.id.btnSuggestion)
        val bntReset = findViewById<Button>(R.id.btnReset)
        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        var time = ""


        // Suggestion Button
        btnSuggestion.setOnClickListener {

            if (chkMorning.isChecked) {
                time = "Morning"
                Toast.makeText(this, "Suggestion Morning Sent", Toast.LENGTH_SHORT).show()
            } else if (chkAfternoon.isChecked) {
                time = "Afternoon"
            } else if (chkNight.isChecked) {
                time = "Night"
            } else if (chkMidMorning.isChecked) {
                time = "Mid-Morning"
            } else if (chkAfternoonSnack.isChecked) {
                time = "Afternoon Snack"
            } else if (chkDinner.isChecked) {
                time = "Dinner"
            } else {
                time = ""
            }


            if (time.isEmpty()) {
                Toast.makeText(this, "Please enter your time", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("timeOfDay", time)
                startActivity(intent)
                // Proceed to the ResultActivity
            }

        }
        // Reset Button
        bntReset.setOnClickListener {
            chkMorning.isChecked = false
            chkAfternoon.isChecked = false
            chkNight.isChecked = false
            chkMidMorning.isChecked = false
            chkAfternoonSnack.isChecked = false
            chkDinner.isChecked = false
            Toast.makeText(this, "Reset Successfully", Toast.LENGTH_SHORT).show()
            // Proceed to the ResultActivity
            tvTitle.text = "Welcome Bestie!"
            tvTime.text = "Please Select Your Time"
        }
    }
}

