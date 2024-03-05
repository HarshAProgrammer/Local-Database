package com.example.android.localdatabase

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeScreen : AppCompatActivity() {
    lateinit var resultTextView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        resultTextView = findViewById(R.id.tvResult)

        val sharedPref = getSharedPreferences("Login Data", MODE_PRIVATE)
        val name  = sharedPref.getString("Name","")
        val password  = sharedPref.getString("Password","")

        resultTextView.text = "Name is :${name}  \nPassword is :${password}"



    }
}