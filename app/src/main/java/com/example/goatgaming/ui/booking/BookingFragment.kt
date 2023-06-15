package com.example.goatgaming.ui.booking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.goatgaming.MainActivity
import com.example.goatgaming.R
import com.example.goatgaming.databinding.FragmentBookingBinding
import com.example.goatgaming.ui.booking.Booking
import com.example.goatgaming.ui.booking.BookingAdaptor
import com.example.goatgaming.ui.event.Event
import com.example.goatgaming.ui.event.EventAdaptor
import com.example.goatgaming.ui.event.EventFragment
import java.util.Calendar


class BookingFragment : Fragment(),BookingAdaptor.OnItemClickListener {

    private var _binding: FragmentBookingBinding? = null
    private lateinit var bookingRecyclerview : RecyclerView
    private lateinit var bookingArrayList : List<Booking>
    companion object {

        fun newInstance() =
           BookingFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       

        _binding = FragmentBookingBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val rView: RecyclerView =binding.bookingList
        bookingRecyclerview = rView
        bookingRecyclerview.layoutManager = LinearLayoutManager(context)
        bookingRecyclerview.setHasFixedSize(true)
        bookingArrayList = arrayListOf<Booking>()



       
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bookingArrayList = createStoreList()

        bookingRecyclerview.adapter = BookingAdaptor(bookingArrayList, this)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun createStoreList(): List<Booking> {
        val calendar = Calendar.getInstance()
        calendar.set(2023, Calendar.JUNE, 8)
        val itemList = mutableListOf<Booking>()
        itemList.add(Booking("Play Station 5",calendar.time,"R50/hr", R.drawable.ps5))
        itemList.add(Booking("X-Box Series X",calendar.time,"R50/hr", R.drawable.xbox))
        itemList.add(Booking("Switch",calendar.time,"R50/hr", R.drawable.ns))
        itemList.add(Booking("Master race",calendar.time,"R50/hr", R.drawable.mr))



        return itemList
    }
    override fun onItemClick(booking: Booking) {
        val mainActivity = activity as MainActivity
        mainActivity.onItemClick(booking)
    }
}