package com.bmpl.firebaseapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.support.annotation.NonNull
import android.R.attr.password
import android.support.v4.app.FragmentActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAuth = FirebaseAuth.getInstance()

        registerUserButton.setOnClickListener {

            var email = emailEditText.text.toString()
            var password = passwordEditText.text.toString()

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, object : OnCompleteListener<AuthResult>() {
                    fun onComplete(task: Task<AuthResult>) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(this.toString(), "createUserWithEmail:success")
                            val user = mAuth.getCurrentUser()

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(this.toString(), "createUserWithEmail:failure", task.getException())
                            Toast.makeText(this@MainActivity, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()

                        }

                    }
                })
        }
    }
}