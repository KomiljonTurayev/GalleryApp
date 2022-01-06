package com.example.dars_35.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dars_35.databinding.PostItemLayoutBinding
import com.example.dars_35.model.PostModel

class PostAdapter(val items:List<PostModel>):RecyclerView.Adapter<PostAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: PostItemLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(PostItemLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
    val item = items[position]
        holder.binding.tvBody.text = item.body
        holder.binding.tvTitle.text = item.title
    }

    override fun getItemCount(): Int  = items.count()

}