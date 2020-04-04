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
        read_json()
    }

    fun read_json()
    {
        var json : String? = null

       try {
           val inputStream: InputStream = assets.open("tickets.json")
           json = inputStream.bufferedReader().use { it.readText() }

           var jsonArr = JSONArray(json)
           val bundle: Bundle? = intent.extras
           val index  = bundle!!.getInt("listIndex")

            for(i in 0..jsonArr.length()-1)
            {
                var jsonObj = jsonArr.getJSONObject(i)
                arr.add(jsonObj.getString("day"))
                arr.add(jsonObj.getString("shop"))
                arr.add(jsonObj.getString("time"))
                arr.add(jsonObj.getString("code"))
            }

           if (index == 0){
               textViewImportedDay.text = arr[0]
               textViewImportedSN.text = arr[1]
               textViewImportedTR.text = arr[2]
               textViewImportedCode.text = arr[3]
           }
           else if (index == 1){
               textViewImportedDay.text = arr[4]
               textViewImportedSN.text = arr[5]
               textViewImportedTR.text = arr[6]
               textViewImportedCode.text = arr[7]
           }
           else if (index == 2){
               textViewImportedDay.text = arr[8]
               textViewImportedSN.text = arr[9]
               textViewImportedTR.text = arr[10]
               textViewImportedCode.text = arr[11]
           }

       }
       catch (e: IOException)
       {

       }


    }

}





























