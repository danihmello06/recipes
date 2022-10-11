package com.example.recipes.ui.adapter.viewholder

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.example.recipes.ItemSearchClickListener
import com.example.recipes.R
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
        }
    }

    private fun ImageView.loadImage(
        imageUrl: String?,
        @DrawableRes placeholder: Int? = null,
        showPlaceholder: Boolean = true,
    ) {
        load(imageUrl) {
            if (showPlaceholder) {
                placeholder(placeholder ?: R.drawable.image_placeholder)
            }
            fallback(placeholder ?: R.drawable.image_placeholder)
            error(placeholder ?: R.drawable.image_placeholder)
        }
    }
}