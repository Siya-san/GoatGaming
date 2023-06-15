package com.example.goatgaming.ui.booking

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.goatgaming.R
import com.example.goatgaming.ui.booking.Booking
import com.example.goatgaming.ui.booking.BookingAdaptor

class BookingAdaptor (private val bookingList : List<Booking>, private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<BookingAdaptor.MyViewHolder>() {
    interface OnItemClickListener {
        fun onItemClick(booking: Booking)
    }
    private var listener: OnItemClickListener? = null
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.booking_fields,
            parent,false)
        return MyViewHolder(itemView)

    }
    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = bookingList[position]

   holder.bookingName.text = currentitem.booking_type
   holder.bookingDate.text = currentitem.booking_date.toString()
   holder.bookingRate.text = currentitem.booking_rate
        currentitem.imageResourceId?.let { holder.imageResourceId.setImageResource(it) }
   holder.itemView.setOnClickListener {
       onItemClickListener.onItemClick(currentitem)
   }

    }
    override fun getItemCount(): Int {

        return bookingList.size
    }
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

     val bookingName : TextView = itemView.findViewById(R.id.bookingName)
     val bookingDate : TextView = itemView.findViewById(R.id.bookingDate)
     val bookingRate : TextView = itemView.findViewById(R.id.bookingRate)
     val imageResourceId : ImageView = itemView.findViewById(R.id.bookingImage)

    }


}