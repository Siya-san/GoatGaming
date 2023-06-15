package com.example.goatgaming.ui.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.goatgaming.databinding.FragmentBookingReviewBinding



class BookingReviewFragment : Fragment() {
    private lateinit var binding: FragmentBookingReviewBinding
    private lateinit var booking: Booking
    companion object {
        private const val ARG_CATEGORY = "arg_booking"

        fun newInstance(booking: Booking): BookingReviewFragment {
            var fragment =BookingReviewFragment()
            val args = Bundle()
            args.putParcelable(ARG_CATEGORY, booking)
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            booking = it.getParcelable(ARG_CATEGORY)!!
        }
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookingReviewBinding.inflate(inflater, container, false)

        binding.bookingName.setText(booking.booking_type)
        binding.bookingDate.setText(booking.booking_date.toString())
        binding.bookingRate.setText(booking.booking_rate)

        booking.imageResourceId?.let { binding.bookingImage.setImageResource(it) }
        return  binding.root
    }
    
}