package com.hexinary.restaurantmenujournal.model

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hexinary.restaurantmenujournal.R

class MenuItemAdapter(val dataSet: ArrayList<Item>, val context: Context):RecyclerView.Adapter<MenuItemAdapter.CustomViewHolder>() {
    private val mContext = context

    class CustomViewHolder(val layoutUrlView: LinearLayout) : RecyclerView.ViewHolder(layoutUrlView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutUrlView = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_item, parent, false) as LinearLayout
        return CustomViewHolder(layoutUrlView)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.layoutUrlView.findViewById<TextView>(R.id.item_name).text = dataSet[position].itemName
        holder.layoutUrlView.findViewById<TextView>(R.id.restaurant_name).text = dataSet[position].restatrantName
        holder.layoutUrlView.findViewById<RatingBar>(R.id.rating).rating = dataSet[position].rating
    }
}