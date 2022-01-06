package com.example.dars_35.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dars_35.databinding.PhotoItemLayoutBinding
import com.example.dars_35.model.PhotoModel
import com.squareup.picasso.Picasso

class ImageAdapter(val items: List<PhotoModel>) : RecyclerView.Adapter<ImageAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: PhotoItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(PhotoItemLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ImageAdapter.ItemHolder, position: Int) {
        val item  = items[position]
        Picasso.get().load(item.url).into(holder.binding.imageView)
    }

    override fun getItemCount(): Int = items.count()
}