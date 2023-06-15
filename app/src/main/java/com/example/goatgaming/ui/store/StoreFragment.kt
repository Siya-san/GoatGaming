package com.example.goatgaming.ui.store
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.goatgaming.MainActivity
import com.example.goatgaming.R

import com.example.goatgaming.databinding.FragmentStoreBinding

class StoreFragment : Fragment() {
    private var _binding: FragmentStoreBinding? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var storeAdapter: StoreAdapter
    private lateinit var storeList: List<StoreItem>

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentStoreBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val rView: RecyclerView =binding.appBarMain.recyclerView
        recyclerView = rView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
binding.appBarMain.fab.setOnClickListener {
    val mainActivity = activity as MainActivity
    mainActivity.goToCart() }

        return root
    }





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        storeList = createStoreList()
        storeAdapter = StoreAdapter(storeList)
        recyclerView.adapter = storeAdapter
    }

    private fun createStoreList(): List<StoreItem> {
        val itemList = mutableListOf<StoreItem>()
      itemList.add(StoreItem(R.drawable.store1, "T-Shirt", "$69.69"))
      itemList.add(StoreItem(R.drawable.store2, "Gamer T-Shirt 2", "$14.69"))
      itemList.add(StoreItem(R.drawable.store3, "Grandma Shirt", "$19.99"))
      itemList.add(StoreItem(R.drawable.store4, "Shower", "R00.00"))
        return itemList
    }
}
