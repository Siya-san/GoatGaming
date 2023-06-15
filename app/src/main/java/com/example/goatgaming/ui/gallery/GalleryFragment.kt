package com.example.goatgaming.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.goatgaming.R
import com.example.goatgaming.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var galleryAdapter: GalleryAdapter
    private lateinit var galleryItems: List<GalleryItem>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)
        recyclerView = view.findViewById(R.id.galleryList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        galleryItems = createGalleryItems()
        galleryAdapter = GalleryAdapter(galleryItems)
        recyclerView.adapter = galleryAdapter
    }

    private fun createGalleryItems(): List<GalleryItem> {
        val items = mutableListOf<GalleryItem>()
        items.add(GalleryItem(R.drawable.gallery1, "CSGO 2020 CHAMPIONS"))
        items.add(GalleryItem(R.drawable.gallery2, "Bugha Fornite world champion"))
        items.add(GalleryItem(R.drawable.gallery3, "Brawlhalla World Champion"))
        // Add more items as needed
        return items
    }
}