package com.example.recipes.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.databinding.IngredientItemBinding
import com.example.recipes.ui.adapter.viewholder.RecipeIngredientViewHolder

class RecipeIngredientAdapter(
    private val ingredientList: List<String>
) : RecyclerView.Adapter<RecipeIngredientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeIngredientViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecipeIngredientViewHolder(
            IngredientItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecipeIngredientViewHolder, position: Int) {
        holder.bind(ingredientList[position])
    }

    override fun getItemCount(): Int = ingredientList.size

}