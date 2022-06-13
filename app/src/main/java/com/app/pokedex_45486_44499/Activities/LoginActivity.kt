package com.app.pokedex_45486_44499.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.pokedex_45486_44499.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    var username: EditText? = null
    var password: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mAuth = Firebase.auth
        username = findViewById(R.id.editTextTextPersonName)
        password = findViewById(R.id.editTextTextPassword)
        setup()
    }

    private fun setup(){
        findViewById<Button>(R.id.btn_auth).setOnClickListener {

            val usernameStr = findViewById<EditText>(R.id.editTextTextPersonName).text.toString().trim()
            val passwordStr = findViewById<EditText>(R.id.editTextTextPassword).text.toString().trim()

            if(usernameStr.isEmpty()){
                username?.setError("Email can't be empty!")
                return@setOnClickListener
            }

            if (passwordStr.isEmpty()){
                password?.setError("Password can't be empty!")
                return@setOnClickListener
            }

            mAuth.signInWithEmailAndPassword(usernameStr,passwordStr).addOnCompleteListener(
                OnCompleteListener {
                    if(it.isSuccessful){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Failed to login! Account does not exist, try again!", Toast.LENGTH_LONG).show()
                    }
                })
        }
    }


}