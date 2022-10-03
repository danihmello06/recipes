package com.example.recipes.ui.adapter.viewholder

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.ItemSearchClickListener
import com.example.recipes.data.Search
import com.example.recipes.databinding.SearchItemBinding

class SearchViewHolder(
    private val binding: SearchItemBinding,
    private val listener: ItemSearchClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(itemSearch: Search) {
        setContent(itemSearch)
    }

    private fun setContent(itemSearch: Search) {
        with(binding) {
            searchImage.setImageURI(itemSearch.imageUrl!! as Uri)
            searchTitle.text = itemSearch.title
        }
    }
}