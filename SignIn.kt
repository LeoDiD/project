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

class SignIn : AppCompatActivity() {
    private lateinit var et_password2: EditText
    lateinit var et_username2: EditText
    lateinit var btn_signin: Button
    lateinit var tv_login: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.sign_in)

        // Button, username, and password initialization
        btn_signin = findViewById(R.id.btn_signin)
        et_username2 = findViewById(R.id.et_username2)
        et_password2 = findViewById(R.id.et_password2)
        tv_login = findViewById(R.id.tv_login)

        // Setting click listener for sign-in
        btn_signin.setOnClickListener {
            handleSignIn()
        }

        // Setting click listener for login
        tv_login.setOnClickListener {
            navigateToLogIn()
        }

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Handle sign in button click and navigate to MainPage
    private fun handleSignIn() {
        val username = et_username2.text.toString()
        val password = et_password2.text.toString()
        Log.i("test credentials", "Username: $username and Password: $password")
        navigateToMainPage()
    }

    // Navigate to the MainPage activity
    private fun navigateToMainPage() {
        val intent = Intent(this, MainPage::class.java)
        startActivity(intent)
    }

    // Navigate to the LogIn activity
    private fun navigateToLogIn() {
        val intent = Intent(this, LogIn::class.java)
        startActivity(intent)
    }
}
