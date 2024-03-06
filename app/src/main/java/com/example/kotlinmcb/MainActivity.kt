package com.example.kotlinmcb

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bodyLayout = findViewById<FrameLayout>(R.id.bodyLayout)
        val btnChangeColor = findViewById<Button>(R.id.btnChangeColor)
        val btnSwitchActivity = findViewById<Button>(R.id.btnSwitchActivity)
        val editTextMessage = findViewById<EditText>(R.id.editTextMessage)
        val btnGoToLogin = findViewById<Button>(R.id.btnGoToLogin)

        btnChangeColor.setOnClickListener {
            val newColor = Color.rgb((0..255).random(), (0..255).random(), (0..255).random())
            bodyLayout.setBackgroundColor(newColor)
        }

        btnSwitchActivity.setOnClickListener {
            val message = editTextMessage.text.toString()
            val intent = Intent(this, MainActivity_2::class.java)
            intent.putExtra("EXTRA_MESSAGE", message)
            startActivity(intent)
        }

        // Configurar el botón para ir al fragments.LoginFragment
        btnGoToLogin.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
    }
}
