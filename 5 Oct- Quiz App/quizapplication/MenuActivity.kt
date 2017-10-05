package com.bmpl.quizapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var imageArray  =  intArrayOf(R.drawable.sciencenew, R.drawable.pi,
                                        R.drawable.geography, R.drawable.eng)

        var subjectArray = arrayOf("Science", "Math", "Geography", "English")

        var listView : ListView = findViewById(R.id.listView) as ListView

        listView.adapter = CustomAdapter(this, imageArray, subjectArray)

        listView.setOnItemClickListener { adapterView, view, position, id ->

            var intent = when (position) {
                0 -> Intent(this, ScienceActivity:: class.java)
                //1 -> Intent(this, MathActivity:: class.java)
                //2 -> Intent(this, GeographyActivity:: class.java)
                 else -> Intent(this, ScienceActivity :: class.java)
            }
            startActivity(intent)
        }

    }
}
