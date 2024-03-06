package com.example.kotlinmcb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2)


        val message = intent.getStringExtra("Mensaje de prueba")

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "Bienvenido a la App\n$message"
    }
}