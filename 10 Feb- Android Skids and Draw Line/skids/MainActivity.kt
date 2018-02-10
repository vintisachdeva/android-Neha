package com.bmpl.android.skids

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var animationDrawable : AnimationDrawable = AnimationDrawable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        curtainImageView.setBackgroundResource(R.drawable.curtain_raiser_animation)

        animationDrawable = curtainImageView.background as AnimationDrawable

        animationDrawable.start()

        var handler = Handler()

        var runnable  = Runnable {
            startActivity(Intent(this, MenuActivity :: class.java))
        }

        handler.postDelayed(runnable, 2000)

    }
}
