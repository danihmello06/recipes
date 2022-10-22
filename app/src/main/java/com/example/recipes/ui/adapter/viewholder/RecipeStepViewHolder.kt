package com.example.recipes.ui.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.data.Recipe
import com.example.recipes.databinding.StepItemBinding
import com.example.recipes.ui.adapter.RecipeIngredientAdapter

class RecipeStepViewHolder(
    private val binding: StepItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        recipeStepItem: Recipe.Steps,
        ingredientAdapter: RecipeIngredientAdapter,
    ) {
        setContent(recipeStepItem, ingredientAdapter)
    }

    private fun setContent(
        stepItem: Recipe.Steps,
        ingredientAdapter: RecipeIngredientAdapter,
    ) {
        with(binding) {
            stepTitle.text = stepItem.title
            ingredientsRecycler.setHasFixedSize(false)
            preparationItem.text = stepItem.preparation
            ingredientsRecycler.adapter = ingredientAdapter
        }
    }
}