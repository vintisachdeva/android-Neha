package com.bmpl.implicitintent_neha

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendButton.setOnClickListener {

            //Implicit Intent
        /*    var intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_TEXT,  "This is my app data")
            intent.setPackage("com.whatsapp")
            startActivity(intent) */
            //startActivity(Intent.createChooser(intent, "Select AnyOne"))

            var intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject")//subject
            intent.putExtra(Intent.EXTRA_TEXT, "This is for the body text")//body
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("abc@gmail.com"))// To
            startActivity(Intent.createChooser(intent, "select one"))
            //intent.setType("image/*")
        }

    }
}
