package com.example.recipes.ui.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.databinding.IngredientItemBinding

class RecipeIngredientViewHolder (
    private val binding: IngredientItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(ingredientItem: String) {
        binding.ingredientItem.text = ingredientItem
    }

}