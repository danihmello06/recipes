package com.example.recipes.ui.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.recipes.ItemSearchClickListener
import com.example.recipes.data.Search
import com.example.recipes.databinding.SearchItemBinding

class SearchViewHolder(
    private val binding: SearchItemBinding,
    private val listener: ItemSearchClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(itemSearch: Search) {
        binding.searchImage.layout(0,0,0,0) //HERE
        setContent(itemSearch)
    }

    private fun setContent(itemSearch: Search) {

        binding.apply {
            Glide.with(itemView)
                .load(itemSearch.imageUrl)
                .into(searchImage)
        }

        with(binding) {
            searchTitle.text = itemSearch.title
        }
    }
}