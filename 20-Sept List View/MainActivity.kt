package com.bmpl.listview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var androidVersionNames = arrayOf("Froyo", "GingerBread", "HoneyComb",
                                            "Ice-cream Sandwich", "JellyBean",
                                            "Kitkat", "Lollipop", "Marshmallow",
                                            "Nougat", "Oreo", "Ice-cream Sandwich",
                                            "JellyBean", "Kitkat", "Lollipop",
                                            "Marshmallow","Nougat", "Oreo")

        var listView : ListView = findViewById(R.id.listView) as ListView

        var arrayAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, androidVersionNames)

        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { adapterView, view, index, id ->

            if(index==0){
                clicked("you clicked on Froyo API 9")
            } else if(index == 1){
                clicked("you clicked on Froyo API 10")
            }
        }
    }

    fun clicked(msg : String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}
