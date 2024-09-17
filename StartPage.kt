package com.example.resumaker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StartPage : AppCompatActivity() {

    lateinit var btn_getstarted : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.start_page)
        //button initialization
        btn_getstarted = findViewById(R.id.btn_getstarted)
        //setting click listener
        btn_getstarted.setOnClickListener{
            navigateToNextPage()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    //navigate function
    private fun navigateToNextPage() {
        val intent = Intent(this, LogIn::class.java)
        startActivity(intent)
        }
    }