package danihmello.tcc.recipes.ui.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import danihmello.tcc.recipes.databinding.PreparationItemBinding

class RecipePreparationViewHolder (
    private val binding: PreparationItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(preparationItem: String, position: Int) {
        binding.preparationItem.text = preparationItem
        binding.preparationNumber.text = position.toString()
    }

}