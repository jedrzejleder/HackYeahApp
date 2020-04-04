package com.example.q_you

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ticket.*
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

class TicketActivity : AppCompatActivity() {

    var arr = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket)
        buttonHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonKlepnijTicket.setOnClickListener {
            textViewImportedDay.text = "Monday"
            textViewImportedSN.text = "Biedra"
            textViewImportedTR.text = "4:20 PM"
            textViewImportedCode.text = "696969"

        }

        read_json()
    }

    fun read_json()
    {
        var json : String? = null

       try {
           val inputStream: InputStream = assets.open("tickets.json")
           json = inputStream.bufferedReader().use { it.readText() }

           var jsonArr = JSONArray(json)

            for(i in 0..jsonArr.length()-1)
            {
                var jsonObj = jsonArr.getJSONObject(i)
                arr.add(jsonObj.getString("day"))
                arr.add(jsonObj.getString("shop"))
                arr.add(jsonObj.getString("time"))
                arr.add(jsonObj.getString("code"))
            }

           textViewImportedDay.text = arr[0]
           textViewImportedSN.text = arr[1]
           textViewImportedTR.text = arr[2]
           textViewImportedCode.text = arr[3]
       }
       catch (e: IOException)
       {

       }


    }

}





























