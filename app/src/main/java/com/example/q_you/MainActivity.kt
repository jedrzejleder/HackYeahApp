package com.example.q_you

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            if (editLogin.text.toString().equals("Customer") && editPassword.text.toString().equals("password")){
                Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ShopListActivity::class.java)
                startActivity(intent)

            } else Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show()
        }

        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            }
    }
}

