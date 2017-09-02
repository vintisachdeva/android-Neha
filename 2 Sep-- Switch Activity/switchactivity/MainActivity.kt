package com.bmpl.switchactivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nameEditText : EditText = findViewById(R.id.nameEditText) as EditText
        var emailEditText : EditText = findViewById(R.id.emailEditText) as EditText
        var passwordEditText : EditText = findViewById(R.id.passwordEditText) as EditText

        var  loginButton : Button = findViewById(R.id.loginButton) as Button

        loginButton.setOnClickListener {
            // Intent class--> to start an activity or to pass data between activities

            var name = nameEditText.text.toString()

            var intent : Intent = Intent(this, SecondActivity :: class.java)

            intent.putExtra("nm", name)
            startActivity(intent)
        }

    }
}
