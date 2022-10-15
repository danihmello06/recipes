package com.example.recipes.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.data.Recipe
import com.example.recipes.databinding.StepItemBinding
import com.example.recipes.ui.adapter.viewholder.RecipeStepViewHolder

class RecipeStepAdapter(
    private val stepList: List<Recipe.Steps>
) : RecyclerView.Adapter<RecipeStepViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeStepViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecipeStepViewHolder(
            StepItemBinding.inflate(layoutInflater, parent, false),
        )
    }

    override fun onBindViewHolder(holder: RecipeStepViewHolder, position: Int) {
        val ingredientAdapter = RecipeIngredientAdapter(stepList[position].ingredients)
        holder.bind(stepList[position], ingredientAdapter)
    }

    override fun getItemCount(): Int = stepList.size
}