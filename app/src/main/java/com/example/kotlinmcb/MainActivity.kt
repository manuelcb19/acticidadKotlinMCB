package com.example.kotlinmcb

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bodyLayout = findViewById<FrameLayout>(R.id.bodyLayout)
        val btnChangeColor = findViewById<Button>(R.id.btnChangeColor)
        val btnSwitchActivity = findViewById<Button>(R.id.btnSwitchActivity)

        btnChangeColor.setOnClickListener {
            val newColor = Color.rgb((0..255).random(), (0..255).random(), (0..255).random())
            bodyLayout.setBackgroundColor(newColor)
        }

        btnSwitchActivity.setOnClickListener {
            val intent = Intent(this, MainActivity_2::class.java)
            startActivity(intent)
        }
    }
}