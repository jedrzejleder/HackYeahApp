package com.example.q_you

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_shop_list.*
import kotlinx.android.synthetic.main.activity_ticket.*
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream
import java.lang.Exception
public var arr= arrayListOf<String>()

class ShopListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_list)


        read_json()

        findshopbtn.setOnClickListener {
            val intent = Intent(this, FindShopActivity::class.java)
            startActivity(intent)
            av.clear()
        }
    }

    fun read_json() {
        var json : String? = null

        try {
            val inputStream: InputStream = assets.open("myshops.json")
            json = inputStream.bufferedReader().use{it.readText()}

            var jsonarr = JSONArray(json)

            for (i in 0..jsonarr.length()-1)
            {
                var jsonobj = jsonarr.getJSONObject(i)

                arr.add(jsonobj.getString("name"))

            }

            var adpt = ArrayAdapter(this, android.R.layout.simple_list_item_1, arr.distinct())
            json_list.adapter = adpt

            json_list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

                val index = position
                val intent = Intent(this, CalendarActivity::class.java)
                intent.putExtra("shopname", index)
                startActivity(intent)

            }

        }
        catch (e: IOException) {

        }

    }



}
