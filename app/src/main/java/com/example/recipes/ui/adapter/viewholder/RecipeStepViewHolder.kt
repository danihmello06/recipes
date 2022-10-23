package com.example.recipes.ui.adapter.viewholder

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.data.Recipe
import com.example.recipes.databinding.StepItemBinding
import com.example.recipes.ui.adapter.RecipeIngredientAdapter
import com.example.recipes.ui.adapter.RecipePreparationAdapter

class RecipeStepViewHolder(
    private val binding: StepItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        recipeStepItem: Recipe.Steps,
        ingredientAdapter: RecipeIngredientAdapter,
        preparationAdapter: RecipePreparationAdapter
    ) {
        setContent(recipeStepItem, ingredientAdapter, preparationAdapter)
    }

    private fun setContent(
        stepItem: Recipe.Steps,
        ingredientAdapter: RecipeIngredientAdapter,
        preparationAdapter: RecipePreparationAdapter
    ) {
        with(binding) {
            if(stepItem.title.isNullOrBlank()) {
                stepTitle.visibility = View.GONE
            } else {
                stepTitle.visibility = View.VISIBLE
                stepTitle.text = stepItem.title
            }
            ingredientsRecycler.adapter = ingredientAdapter
            preparationRecycler.adapter = preparationAdapter
        }
    }
}