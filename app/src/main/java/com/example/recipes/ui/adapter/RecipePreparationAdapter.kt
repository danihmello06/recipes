package com.example.recipes.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.databinding.PreparationItemBinding
import com.example.recipes.ui.adapter.viewholder.RecipePreparationViewHolder

class RecipePreparationAdapter(
    private val preparationList: List<String>
) : RecyclerView.Adapter<RecipePreparationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipePreparationViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecipePreparationViewHolder(
            PreparationItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecipePreparationViewHolder, position: Int) {
        holder.bind(preparationList[position], position + 1)
    }

    override fun getItemCount(): Int = preparationList.size
}