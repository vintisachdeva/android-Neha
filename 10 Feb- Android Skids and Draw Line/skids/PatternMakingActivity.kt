package com.bmpl.android.skids

import android.content.ClipData
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.DragEvent
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_pattern_making.*

class PatternMakingActivity : AppCompatActivity(), View.OnDragListener, View.OnLongClickListener {

    var seletedImageTag : Any = 0

    override fun onLongClick(view: View?): Boolean {
        val data = ClipData.newPlainText("", "")
        val shadowBuilder = View.DragShadowBuilder(view)
        view!!.startDrag(data, shadowBuilder, view, 0)
        view.visibility = View.INVISIBLE
        seletedImageTag = view.tag
        return true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pattern_making)

        fullMoonImage.tag = R.drawable.full_moon
        octagonImage.tag = R.drawable.octagon
        triangleImage.tag = R.drawable.triangle

        fullMoonImage.setOnDragListener(this)
        octagonImage.setOnDragListener(this)
        triangleImage.setOnDragListener(this)

        fullMoonImage.setOnLongClickListener(this)
        octagonImage.setOnLongClickListener(this)
        triangleImage.setOnLongClickListener(this)



    }


    override fun onDrag(view: View?, dragEvent: DragEvent?): Boolean {
        var hit = false
        var normalShape = seletedImageTag
        var enterShape = R.drawable.question_mark

        val containerView = view as ImageView
        val draggedView = dragEvent!!.localState as ImageView

        when (dragEvent.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                Log.d("PatternMakingActivity", "onDrag: ACTION_DRAG_STARTED")
                hit = false
                return true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                Log.d("PatternMakingActivity", "onDrag: ACTION_DRAG_ENTERED")
                containerView.setImageResource(enterShape)
                return true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                Log.d("PatternMakingActivity", "onDrag: ACTION_DRAG_EXITED")
                containerView.setImageResource(enterShape)
                return true
            }
            DragEvent.ACTION_DROP -> {
                Log.d("PatternMakingActivity", "onDrag: ACTION_DROP")
                hit = true
                draggedView.post { draggedView.visibility = View.GONE }
                return true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                Log.d("PatternMakingActivity", "onDrag: ACTION_DRAG_ENDED")
                containerView.setImageResource(normalShape as Int)
                view.setVisibility(View.VISIBLE)
                if (!hit) {
                    draggedView.post { draggedView.visibility = View.VISIBLE }
                }
                return true
            }
            else -> return true
        }
    }
}