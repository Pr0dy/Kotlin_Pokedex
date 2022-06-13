package com.app.pokedex_45486_44499.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.app.pokedex_45486_44499.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setup()
    }

    private fun setup(){
        findViewById<Button>(R.id.btn_auth).setOnClickListener {

            val username = findViewById<EditText>(R.id.editTextTextPersonName).text.toString()

            if (username.isEmpty()) {
                //findViewById<TextView>(R.id.tv_error).visibility = View.VISIBLE
            }
            val password = findViewById<EditText>(R.id.editTextTextPassword).text.toString()

            if (password.isEmpty()) {
                //findViewById<TextView>(R.id.tv_error).visibility = View.VISIBLE
            }

            //firebase

            //val isValid = username == password
            //if (isValid) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            //}
        }
    }
}