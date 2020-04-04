package com.example.q_you.utilities

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.q_you.R

class TimeAdapter (val times: ArrayList<String>) : RecyclerView.Adapter<TimeAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.time_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = times.size

    override fun onBindViewHolder(holder: TimeAdapter.ViewHolder, position: Int) {
        holder.time.text = times[position]
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val time: Button = itemView.findViewById(R.id.timeSelector)
    }
}

