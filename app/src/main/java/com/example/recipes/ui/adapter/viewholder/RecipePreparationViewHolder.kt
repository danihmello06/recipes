package com.example.recipes.ui.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.databinding.PreparationItemBinding

class RecipePreparationViewHolder (
    private val binding: PreparationItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(preparationItem: String) {
        binding.preparationItem.text = preparationItem
    }

}