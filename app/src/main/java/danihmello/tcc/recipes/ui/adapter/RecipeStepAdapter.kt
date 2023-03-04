package danihmello.tcc.recipes.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import danihmello.tcc.recipes.scraping_api.data.Recipe
import danihmello.tcc.recipes.databinding.StepItemBinding
import danihmello.tcc.recipes.ui.adapter.viewholder.RecipeStepViewHolder

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
        val preparationAdapter = RecipePreparationAdapter(stepList[position].preparation)
        holder.bind(stepList[position], ingredientAdapter, preparationAdapter)
    }

    override fun getItemCount(): Int = stepList.size
}
