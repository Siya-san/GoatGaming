package com.example.goatgaming.ui.giveaway

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.goatgaming.R
import com.example.goatgaming.ui.booking.Booking
import java.util.Calendar


class GiveawayFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var giveawayAdapter: GiveawayApadter
    private lateinit var giveawayItems: List<Giveaway>

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_giveaway, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        giveawayItems = createGiveawayList()
        giveawayAdapter = GiveawayApadter(giveawayItems)
        recyclerView.adapter = giveawayAdapter
    }




    private fun createGiveawayList(): List<Giveaway> {
        val calendar = Calendar.getInstance()
        calendar.set(2023, Calendar.JUNE, 8)
        val itemList = mutableListOf<Giveaway>()
        itemList.add(Giveaway( R.drawable.ps5,"Play Station 5",calendar.time))
        itemList.add(Giveaway(R.drawable.xbox,"X-Box Series X",calendar.time ))
        itemList.add(Giveaway( R.drawable.ns,"Switch",calendar.time))




        return itemList
    }
}