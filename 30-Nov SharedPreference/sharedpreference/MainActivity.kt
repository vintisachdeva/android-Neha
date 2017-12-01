package com.bmpl.sharedpreference

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count = 0
        saveButton.setOnClickListener {
            var name = nameEditText.text.toString()
            var phn = phnEditText.text.toString()

            var sharePreference = getSharedPreferences("details.txt", Context.MODE_APPEND).edit()
            var newName = name.plus(count)
            var newPhn = phn.plus(count)

            sharePreference.putString(newName, name)
            sharePreference.putString(newPhn, phn)
            sharePreference.commit()    // data write into file
            count++
        }

        loadButton.setOnClickListener{

            var sharedPreference = getSharedPreferences("details.txt", Context.MODE_APPEND)
            if(!textView.text.isEmpty()){
                textView.text = textView.text.toString().plus(sharedPreference.getString("nm", "No Data").plus(" " +sharedPreference.getString("phn", "No Data") + "\n"))
            }
            else
                textView.text = sharedPreference.getString("nm", "No Data").plus(" " +sharedPreference.getString("phn", "No Data") + "\n")
        }
    }
}
