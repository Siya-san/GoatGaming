package com.example.goatgaming.ui.store
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.goatgaming.MainActivity
import com.example.goatgaming.R
import com.example.goatgaming.databinding.FragmentCartBinding
import com.example.goatgaming.databinding.FragmentEventBinding
import com.example.goatgaming.ui.event.Event
import com.example.goatgaming.ui.event.EventAdaptor
import java.util.Calendar


class CartFragment : Fragment() {
    private var _binding: FragmentCartBinding? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var cartAdapter: CartAdapter
    private lateinit var cartItemList: List<CartItem>

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val rView: RecyclerView =binding.cartRecyclerView
        recyclerView = rView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cartItemList = createCartItemList()
        cartAdapter = CartAdapter(cartItemList)
        recyclerView.adapter = cartAdapter
    }

    private fun createCartItemList(): List<CartItem> {
        val itemList = mutableListOf<CartItem>()
        itemList.add(CartItem("Merch 1", "$9.99", 2))
        itemList.add(CartItem("Merch 2", "$14.99", 1))
        itemList.add(CartItem("Merch 3", "$19.99", 3))
        return itemList
    }
}
