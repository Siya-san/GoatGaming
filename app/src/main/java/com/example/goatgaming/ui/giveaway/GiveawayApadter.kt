package com.example.goatgaming.ui.giveaway

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.goatgaming.R

import com.example.goatgaming.ui.giveaway.Giveaway

class GiveawayApadter(private val giveaway: List<Giveaway>) :
    RecyclerView.Adapter<GiveawayApadter.GiveawayViewHolder>() {

    class GiveawayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.giveaway_image)
        val name: TextView = itemView.findViewById(R.id.giveaway_name)
        val date: TextView = itemView.findViewById(R.id.giveaway_end_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiveawayViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.giveaway_fields, parent, false)
        return GiveawayViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GiveawayViewHolder, position: Int) {
        val currentItem = giveaway[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.name.text = currentItem.giveaway_name
        holder.date.text = currentItem.giveaway_edate.toString()
    }

    override fun getItemCount(): Int {
        return giveaway.size
    }
}