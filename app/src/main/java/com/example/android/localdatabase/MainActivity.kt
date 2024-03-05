package com.example.android.localdatabase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var editTextName:EditText
    lateinit var editTextPassword:EditText
    lateinit var buttonSave:Button
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextPassword= findViewById(R.id.etPassword)
        editTextName= findViewById(R.id.etName)
        buttonSave= findViewById(R.id.btnSave)

        buttonSave.setOnClickListener{
            val sharedPref = getSharedPreferences("Login Data", MODE_PRIVATE)
            val editor  = sharedPref.edit()
            editor.putString("Name",editTextName.text.toString())
            editor.putString("Password",editTextPassword.text.toString())
            editor.apply()

            val i = Intent(this, HomeScreen::class.java)
            startActivity(i)
            finish()
            Toast.makeText(this,"Data Saved Successfully",Toast.LENGTH_LONG).show()

        }




        }
    }
