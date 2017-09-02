package com.bmpl.switchactivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var textView : TextView = findViewById(R.id.nameTextView) as TextView

        var intent : Intent = intent

        textView.text = "Welcome " + intent.getStringExtra("nm")

        //var name = intent.getStringExtra("nm")

        //textView.text =  name
    }
}
