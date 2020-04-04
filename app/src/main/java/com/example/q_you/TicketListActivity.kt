package com.example.q_you

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_ticket.*
import kotlinx.android.synthetic.main.activity_ticket_list.*
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

class TicketListActivity : AppCompatActivity() {

    var arr = arrayListOf<String>()
    var day = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_list)

        read_json()
    }

    fun read_json() {
        var json: String? = null

        try {
            val inputStream: InputStream = assets.open("tickets.json")
            json = inputStream.bufferedReader().use { it.readText() }

            var jsonArr = JSONArray(json)

            for (i in 0..jsonArr.length() - 1) {
                var jsonObj = jsonArr.getJSONObject(i)

                arr.add(jsonObj.getString("shop"))
                day.add(jsonObj.getString("day"))
            }

            var adpt = ArrayAdapter(this, android.R.layout.simple_list_item_1, arr)
            json_list.adapter = adpt

            json_list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
                val intent = Intent(this, TicketActivity::class.java)
                startActivity(intent)
            }

        } catch (e: IOException) {

        }
    }
}

















