package com.example.q_you
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.q_you.models.FavShops

private const val TAG = "MapsAdapter"
class MapsAdapter(val context: Context, val favShops: List<FavShops>,val onClickListener: OnClickListener) : RecyclerView.Adapter<MapsAdapter.ViewHolder>() {

    interface  OnClickListener{
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(android.R.layout.simple_dropdown_item_1line,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = favShops.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val favShop = favShops[position]
        holder.itemView.setOnClickListener{
        Log.i(TAG,"Tapped on position $position")
            onClickListener.onItemClick(position)
        }
        val textViewTitle = holder.itemView.findViewById<TextView>(android.R.id.text1)
        textViewTitle.text="Supermarkets"
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
