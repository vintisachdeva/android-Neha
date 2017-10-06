package com.bmpl.quizapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Handler class --> Android

        var handler = Handler()

        var run = Runnable {
            var intent = Intent(this, MenuActivity :: class.java)
            startActivity(intent)
            finish() // current activity --> destroy with the help of finish
        }

        var delayMilliseconds : Long = 2000

        handler.postDelayed(run, delayMilliseconds)

    }
}
