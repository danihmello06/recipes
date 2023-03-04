package danihmello.tcc.recipes.ui.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import danihmello.tcc.recipes.scraping_api.data.Recipe
import danihmello.tcc.recipes.databinding.StepItemBinding
import danihmello.tcc.recipes.ui.adapter.RecipeIngredientAdapter
import danihmello.tcc.recipes.ui.adapter.RecipePreparationAdapter

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
                stepItemBarFirst.visibility = View.GONE
                stepItemBarSecond.visibility = View.GONE
                stepTitle.visibility = View.GONE
            } else {
                stepItemBarFirst.visibility = View.VISIBLE
                stepItemBarSecond.visibility = View.VISIBLE
                stepTitle.visibility = View.VISIBLE
                stepTitle.text = stepItem.title.uppercase()
            }
            ingredientsRecycler.adapter = ingredientAdapter
            preparationRecycler.adapter = preparationAdapter
        }
    }
}
