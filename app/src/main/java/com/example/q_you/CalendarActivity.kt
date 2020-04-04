package com.example.q_you

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.q_you.utilities.TimeAdapter
import kotlinx.android.synthetic.main.activity_calendar.*
import kotlinx.android.synthetic.main.time_view.*
import java.util.*
import kotlin.collections.ArrayList

class CalendarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        datePicker.setOnDateChangeListener { view, year, month, dayOfMonth ->
            dateView.setText("Wybrana data: " + year + "-" + month + "-"+ dayOfMonth + " ")
        }

        confirmBtn.setOnClickListener {
        }

        val times: ArrayList<String> = ArrayList()
        for (i in 1..9){
            times.add("11:0$i")
        }

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val myAdapter = TimeAdapter(times)
        recyclerView.adapter = myAdapter

    }
}
