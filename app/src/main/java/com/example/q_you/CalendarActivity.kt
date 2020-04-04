package com.example.q_you

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_calendar.*
import org.json.JSONArray
import java.io.InputStream
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class CalendarActivity : AppCompatActivity() {

    private lateinit var sp: Spinner
    private lateinit var date: String
    private var times: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        datePicker.setOnDateChangeListener { view, year, month, dayOfMonth ->
            times.clear()
            var monthcorrect = month + 1
            var monthString = monthcorrect.toString()
            if (month < 10){
                monthString = "0" + monthcorrect.toString()
            }
            var daycorrect = dayOfMonth.toString()
            if (dayOfMonth < 10){
                daycorrect = "0" + dayOfMonth.toString()
            }
            date = daycorrect+ "-" + monthString + "-"+ year
            //dateView.setText("Wybrana data i godzina: " + date + " ")
            readJson(date)
            sp = timeSpinner
            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, times)
            sp.adapter = arrayAdapter
            sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    //timeView.setText(sp.selectedItem.toString())
                }

            }
        }

        confirmBtn.setOnClickListener {
            val intent = Intent(this, TransactionActivity::class.java)
            startActivity(intent)
        }

    }
    fun readJson(date: String){
        var json: String? = null
        try{
            val inputStream: InputStream = assets.open("calendar.json")
            json = inputStream.bufferedReader().use{it.readText()}
            var jsonArray = JSONArray(json)
            for (i in 0..jsonArray.length()){
                var jsonObject = jsonArray.getJSONObject(i)
                if (jsonObject.getString("date") == date){
                    for(i in 0..jsonObject.getJSONArray("times").length()){
                        times.add(jsonObject.getJSONArray("times")[i].toString())
                    }
                    Toast.makeText(this, jsonObject.getString("times"), Toast.LENGTH_LONG).show()
                }
            }
        }
        catch (e: Exception){

        }
    }
}





















