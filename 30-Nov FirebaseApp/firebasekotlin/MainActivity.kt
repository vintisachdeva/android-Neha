package com.bmpl.firebasekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import jdk.nashorn.internal.runtime.ECMAException.getException
import org.junit.experimental.results.ResultMatchers.isSuccessful
import android.support.annotation.NonNull
import android.R.attr.password
import android.support.v4.app.FragmentActivity
import android.util.Log
import jdk.nashorn.internal.runtime.ECMAException.getException
import org.junit.experimental.results.ResultMatchers.isSuccessful
import android.R.attr.password




class MainActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    private lateinit var database : FirebaseDatabase

    private lateinit var myRef :DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()


        database = FirebaseDatabase.getInstance()

        myRef = database.getReference("message")

        mAuth.createUserWithEmailAndPassword("abc@gmail.com", "12345")
                .addOnCompleteListener(this, object : OnCompleteListener<AuthResult>() {
                    fun onComplete(task: Task<AuthResult>) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("MainActivity", "createUserWithEmail:success")
                            val user = mAuth.getCurrentUser()
                            //updateUI(user)
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("MainActivity", "createUserWithEmail:failure", task.getException())
                            Toast.makeText(this@MainActivity, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()
                            //updateUI(null)
                        }

                        // ...
                    }
                })

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, object : OnCompleteListener<AuthResult>() {
                    fun onComplete(task: Task<AuthResult>) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(FragmentActivity.TAG, "signInWithEmail:success")
                            val user = mAuth.getCurrentUser()
                            updateUI(user)
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(FragmentActivity.TAG, "signInWithEmail:failure", task.getException())
                            Toast.makeText(this@EmailPasswordActivity, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()
                            updateUI(null)
                        }

                        // ...
                    }
                })

        //var name = nameEditText.text.toString()

        myRef.setValue("Hello Firebase!!")

    }
}
