package com.bmpl.quizapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter : BaseAdapter{

    private var context : Context
    var imageArray = intArrayOf()
    private var subjectArray = arrayOf<String>()
    private var layoutInflater : LayoutInflater

    constructor(menuActivity : MenuActivity, imageArray : IntArray, subjectArray : Array<String>){
        context = menuActivity
        this.imageArray = imageArray
        this.subjectArray = subjectArray
        //custom layout call
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    }


    override fun getView(position: Int, p1: View?, viewGroup: ViewGroup?): View {

        var view : View  = layoutInflater.inflate(R.layout.custom_adapter, viewGroup, false)
        var imageView : ImageView = view.findViewById(R.id.imageView) as ImageView
        var textView : TextView = view.findViewById(R.id.textView) as TextView

        imageView.setImageResource(imageArray[position])
        textView.text = subjectArray[position]

        return view
    }

    override fun getItem(p0: Int): Any {
        return imageArray[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return imageArray.size
    }

}