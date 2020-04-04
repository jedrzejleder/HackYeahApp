package com.example.q_you

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream
import org.json.JSONArray
import java.io.IOException

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var json : String? = null
        val inputStream=assets.open("login.json")
            json = inputStream.bufferedReader().use { it.readText() }
        var jsonarr = JSONArray(json)
        var jsonobja = jsonarr.getJSONObject(0)
        var log=jsonobja.getString("login")
        var pass = jsonobja.getString("password")

        btnLogin.setOnClickListener {
            if (editLogin.text.toString().equals(log) && editPassword.text.toString().equals(pass)){
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

