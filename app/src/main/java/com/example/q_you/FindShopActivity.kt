package com.example.q_you

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.q_you.R
import kotlinx.android.synthetic.main.activity_find_shop.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_shop_list.*
import kotlinx.android.synthetic.main.activity_shop_list.json_list
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

public var av= arrayListOf<String>()
class FindShopActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_shop)

         read_json()
        btnhome.setOnClickListener {
            val intent = Intent(this, ShopListActivity::class.java)
            startActivity(intent)
        }
    }

    fun read_json() {
        var json : String? = null

        try {
            val inputStream: InputStream = assets.open("availableshops.json")
            json = inputStream.bufferedReader().use{it.readText()}

            var jsonarr = JSONArray(json)

            for (i in 0..jsonarr.length()-1)
            {
                var jsonobj = jsonarr.getJSONObject(i)

                av.add(jsonobj.getString("name"))

            }
            av.removeAll(arr)
            var adpt = ArrayAdapter(this, android.R.layout.simple_list_item_1, av)
            json_list.adapter = adpt
            //json_list.adapter = adpt2

            json_list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

                arr.add(av[position])

                val intent = Intent(this, ShopListActivity::class.java)
                startActivity(intent)


            }
        }
        catch (e: IOException) {

        }
    }

}
