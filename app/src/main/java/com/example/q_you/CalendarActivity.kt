package com.example.q_you

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_calendar.*
import java.util.*
import kotlin.collections.ArrayList

class CalendarActivity : AppCompatActivity() {

    private lateinit var sp: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        datePicker.setOnDateChangeListener { view, year, month, dayOfMonth ->
            dateView.setText("Wybrana data i godzina: " + year + "-" + month + "-"+ dayOfMonth + " ")
        }

        confirmBtn.setOnClickListener {
        }

        val times: ArrayList<String> = ArrayList()
        for (i in 1..9){
            times.add("11:0$i")
        }
        sp = timeSpinner
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, times)
        sp.adapter = arrayAdapter
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                timeView.setText(sp.selectedItem.toString())
            }

        }

    }
}
