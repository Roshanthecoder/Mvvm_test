package com.example.test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.databinding.ItemRowBinding
import com.example.test.models.PostListResponseItem

class MainAdapter(private val list: ArrayList<PostListResponseItem>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PostListResponseItem) {
            binding.textView.text = item.title
            binding.textView2.text = item.body
            binding.textView3.text = item.userId.toString()
            binding.textView4.text = item.id.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val laybinding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(laybinding)
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}