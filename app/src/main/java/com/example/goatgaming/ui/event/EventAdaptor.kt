package com.example.goatgaming.ui.event

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.goatgaming.R
import com.example.goatgaming.ui.event.Event


class EventAdaptor(private val eventList : List<Event>, private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<EventAdaptor.MyViewHolder>() {
    interface OnItemClickListener {
        fun onItemClick(event: Event)
    }
    private var listener: OnItemClickListener? = null
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.event_fields,
            parent,false)
        return MyViewHolder(itemView)

    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

      val currentitem = eventList[position]
        currentitem.imageResource?.let { holder.Image.setImageResource(it) }
   holder.eventName.text = currentitem.event_name
   holder.eventDate.text = currentitem.event_date.toString()
   holder.eventPrize.text = currentitem.event_prize_pool.toString()
  holder.eventEntry.text = currentitem.event_entry_fee.toString()
   holder.itemView.setOnClickListener {
       onItemClickListener.onItemClick(currentitem)
   }

    }
    override fun getItemCount(): Int {

        return eventList.size
    }
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val Image: ImageView = itemView.findViewById(R.id.eventImage)
     val eventName : TextView = itemView.findViewById(R.id.eventName)
      val eventDate : TextView = itemView.findViewById(R.id.eventDate)
      val eventEntry : TextView = itemView.findViewById(R.id.eventEntryPrice)
     val eventPrize : TextView = itemView.findViewById(R.id.eventPrizePool)

    }


}