package com.example.resumaker

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LogIn : AppCompatActivity() {

    private lateinit var et_password1: EditText
    lateinit var et_username1: EditText
    lateinit var btn_login: Button
    lateinit var tv_signin: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.log_in)

        // Initialize button, username, and password
        btn_login = findViewById(R.id.btn_login)
        et_username1 = findViewById(R.id.et_username1)
        et_password1 = findViewById(R.id.et_password1)
        tv_signin = findViewById(R.id.tv_signin)

        // Set click listener for login
        btn_login.setOnClickListener {
            handleLogin()
        }

        // Set click listener for signin
        tv_signin.setOnClickListener {
            navigateToSignIn()
        }

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Handle login button click and navigate to MainPage
    private fun handleLogin() {
        val username = et_username1.text.toString()
        val password = et_password1.text.toString()
        Log.i("test credentials", "Username: $username and Password: $password")
        navigateToMainPage()
    }

    // Navigate to the MainPage activity
    private fun navigateToMainPage() {
        val intent = Intent(this, MainPage::class.java)
        startActivity(intent)
    }

    // Navigate to the SignIn activity
    private fun navigateToSignIn() {
        val intent = Intent(this, SignIn::class.java)
        startActivity(intent)
    }
}
