package com.example.kotlinmcb

import LoginFragment
import RegistroFragment
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class AuthActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        auth = FirebaseAuth.getInstance()

       /* if (auth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }*/
        if (savedInstanceState != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, LoginFragment())
                .commit()
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, LoginFragment())
                .commit()
        }
    }

    fun switchToRegistroFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, RegistroFragment())
            .addToBackStack(null)
            .commit()
    }

    fun onLoginSuccess() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}