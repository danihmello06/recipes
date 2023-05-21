package danihmello.tcc.recipes.ui.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import danihmello.tcc.recipes.databinding.IngredientItemBinding

class RecipeIngredientViewHolder(
    private val binding: IngredientItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(ingredientItem: String) {
        binding.ingredientItem.text = ingredientItem
    }
}
