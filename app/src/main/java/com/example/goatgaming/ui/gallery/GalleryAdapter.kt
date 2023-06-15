package com.example.goatgaming.ui.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Gallery
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.goatgaming.R

class GalleryAdapter(private val gallery: List<GalleryItem>) :
    RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val captionTextView: TextView = itemView.findViewById(R.id.image_caption)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.gallery_fields, parent, false)
        return GalleryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val currentItem = gallery[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.captionTextView.text = currentItem.caption
    }

    override fun getItemCount(): Int {
        return gallery.size
    }
}
