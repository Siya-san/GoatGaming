package com.example.goatgaming.ui.event

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.goatgaming.MainActivity
import com.example.goatgaming.R
import com.example.goatgaming.databinding.FragmentEventBinding

import java.util.Calendar



class EventFragment : Fragment(), EventAdaptor.OnItemClickListener {
    private var _binding: FragmentEventBinding? = null
    private lateinit var eventRecyclerview : RecyclerView
    private lateinit var eventArrayList : List<Event>


    companion object {

        fun newInstance() =
            EventFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentEventBinding.inflate(inflater, container, false)
        val root: View = binding.root
binding.eventActionBar.createEvent.setOnClickListener {
    val mainActivity = activity as MainActivity
    mainActivity.createEvent()
}

        val rView: RecyclerView =binding.eventActionBar.eventList
        eventRecyclerview = rView
        eventRecyclerview.layoutManager = LinearLayoutManager(context)
        eventRecyclerview.setHasFixedSize(true)
        eventArrayList = arrayListOf<Event>()

        val event=Event



        return root
    }
    override fun onItemClick(event: Event) {
        val mainActivity = activity as MainActivity
        mainActivity.onItemClick(event)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventArrayList = createStoreList()

        eventRecyclerview.adapter = EventAdaptor(eventArrayList, this)
    }
    private fun createStoreList(): List<Event> {
        val calendar = Calendar.getInstance()
        calendar.set(2023, Calendar.JUNE, 8)
        val itemList = mutableListOf<Event>()
        itemList.add(Event("Super Smash bros",calendar.time,5000.00,100.0,R.drawable.event1))
        itemList.add(Event("Fornite",calendar.time,1500.00,100.0,R.drawable.event2))
        itemList.add(Event("COD: Warzone",calendar.time,1200.00,100.0,R.drawable.event3))
        itemList.add(Event("Tekken 7",calendar.time,1100.00,100.0,R.drawable.event4))
        itemList.add(Event("Mortal Kombat",calendar.time,8000.00,100.0,R.drawable.event5))


        return itemList
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}