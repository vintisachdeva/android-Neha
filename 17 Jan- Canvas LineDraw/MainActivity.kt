package com.bmpl.canvasandroid

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MotionEvent
import android.view.View

class MainActivity : AppCompatActivity(){

    lateinit var customView: CustomView

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        customView = CustomView(this)
        setContentView(customView)
    }

    class CustomView : View, View.OnTouchListener{

        var startMoveX  = 0.0f
        var startMoveY = 0.0f
        var stopMoveX = 0.0f
        var stopMoveY = 0.0f
        var canvas  = Canvas()
        var paint = Paint()


        constructor(context: Context) : super(context) {
            this.setOnTouchListener(this)
            paint.strokeWidth = 6.0f
            paint.color = Color.BLACK
            paint.style = Paint.Style.FILL_AND_STROKE
        }


        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)

            this.canvas = canvas!!
            canvas?.drawLine(startMoveX, startMoveY, stopMoveX, stopMoveY, paint)
        }

        override fun onTouch(view: View?, motionEvent: MotionEvent?): Boolean {
            Log.i("onTouch", "Inside onTouch")
            var value = motionEvent!!.actionMasked


            if(value == MotionEvent.ACTION_DOWN){
                startMoveX = motionEvent.x
                startMoveY = motionEvent.y
                invalidate()
            }
            if(value == MotionEvent.ACTION_MOVE){
                stopMoveX = motionEvent.x
                stopMoveY = motionEvent.y
                invalidate()
            }
            if(value == MotionEvent.ACTION_UP){
                stopMoveX = motionEvent.x
                stopMoveY = motionEvent.y
                invalidate()
             }
            return true
        }
    }
}