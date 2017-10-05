package com.bmpl.quizapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView

class ScienceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_science)

        var questionArray : Array<String> = resources.getStringArray(R.array.question)
        var options : Array<String> = resources.getStringArray(R.array.options)
        var answers : Array<String> = resources.getStringArray(R.array.answer)

        var nextButton : Button = findViewById(R.id.nextButton) as Button
        var questionTextView : TextView = findViewById(R.id.questionTextView) as TextView
        var radioButtonOption1 : RadioButton = findViewById(R.id.option1) as RadioButton
        var radioButtonOption2 : RadioButton = findViewById(R.id.option2) as RadioButton
        var radioButtonOption3 : RadioButton = findViewById(R.id.option3) as RadioButton
        var radioButtonOption4 : RadioButton = findViewById(R.id.option4) as RadioButton

        var position : Int = 0

        questionTextView.text = questionArray[position]
        radioButtonOption1.text = options[0]
        radioButtonOption2.text = options[1]
        radioButtonOption3.text = options[2]
        radioButtonOption4.text = options[3]

        nextButton.setOnClickListener {
            position++ // position = position 4 * pos  = 4
            questionTextView.text = questionArray[position]
            radioButtonOption1.text = options[4*position]           //4
            radioButtonOption1.text = options[4*position + 1]       //5
            radioButtonOption1.text = options[4*position + 2]       //6
            radioButtonOption1.text = options[4*position + 3]       //7
        }
    }
}
