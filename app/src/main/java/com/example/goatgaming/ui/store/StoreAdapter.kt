package com.example.goatgaming.ui.store

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.goatgaming.R

class StoreAdapter(private val StoreList: List<StoreItem>) : RecyclerView.Adapter<StoreAdapter.StoreViewHolder>() {

    class StoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val StoreImage: ImageView = itemView.findViewById(R.id.store_image)
        val StoreName: TextView = itemView.findViewById(R.id.store_name)
        val StorePrice: TextView = itemView.findViewById(R.id.store_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.store_fields, parent, false)
        return StoreViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val currentItem = StoreList[position]
        holder.StoreImage.setImageResource(currentItem.imageResource)
        holder.StoreName.text = currentItem.name
        holder.StorePrice.text = currentItem.price
    }

    override fun getItemCount(): Int {
        return StoreList.size
    }
}
