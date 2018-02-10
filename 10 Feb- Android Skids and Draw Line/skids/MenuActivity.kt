package com.bmpl.android.skids

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    var animationDrawable : AnimationDrawable = AnimationDrawable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var animation = AnimationUtils.loadAnimation(this, R.anim.move_upward)

        //Glide.with(this).load(R.drawable.clouds).into(cloudImage)

        mazeBalloon.startAnimation(animation)
        patternMakingBalloon.startAnimation(animation)
        shadowMatcherBalloon.startAnimation(animation)

        patternMakingBalloon.setOnClickListener{
            startActivity(Intent(this, PatternMakingActivity :: class.java))
        }
    }
}