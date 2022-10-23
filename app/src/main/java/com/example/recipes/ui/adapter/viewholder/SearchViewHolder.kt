package com.example.recipes.ui.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.ItemSearchClickListener
import com.example.recipes.utils.Utils.loadImage
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
            searchTitle.text = itemSearch.title

            searchImage.loadImage(itemSearch.imageUrl)

            root.setOnClickListener {listener.onClick(itemSearch)}

        }
    }


}