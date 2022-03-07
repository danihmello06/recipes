package com.example.recipes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.data.Recipe
import com.example.recipes.databinding.FragmentIngredientsBinding

class IngredientsAdapter(private val recipeIngredients: List<Recipe.Ingredient>, private val context: Context) : RecyclerView.Adapter<IngredientsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FragmentIngredientsBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return recipeIngredients.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(recipeIngredients[position])
    }

    inner class ViewHolder(private val binding: FragmentIngredientsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Recipe.Ingredient) {
            with(binding) {
                itemNumber.text = item.amount.toString()
                itemUnity.text = item.unity
                itemContent.text = item.ingredientItem
            }
        }
    }
}

