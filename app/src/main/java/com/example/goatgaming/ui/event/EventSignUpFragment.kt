package com.example.goatgaming.ui.event

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.goatgaming.R
import com.example.goatgaming.databinding.FragmentEventSignUpBinding


class EventSignUpFragment : Fragment() {
    private lateinit var binding: FragmentEventSignUpBinding
    private lateinit var event: Event
    companion object {
        private const val ARG_CATEGORY = "arg_event"

        fun newInstance(event: Event): EventSignUpFragment {
            var fragment = EventSignUpFragment()
            val args = Bundle()
            args.putParcelable(ARG_CATEGORY, event)
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            event = it.getParcelable(ARG_CATEGORY)!!
        }
    }


        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentEventSignUpBinding.inflate(inflater, container, false)
          
            binding.eventName.setText(event.event_name)
            binding.eventDate.setText(event.event_date.toString())
            binding.eventEntryPrice.setText(event.event_entry_fee.toString())
            binding.eventPrizePool.setText(event.event_prize_pool.toString())
            event.imageResource?.let { binding.eventImage.setImageResource(it) }
        return  binding.root
    }


}