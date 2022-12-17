package danihmello.tcc.recipes.api

import danihmello.tcc.recipes.data.Recipe
import danihmello.tcc.recipes.data.Search

object RecipeMapper {

    fun mapSearch(searchResponse: List<SearchResponse>): List<Search> {
        return searchResponse.map { search ->
            Search(
                search.author,
                search.image_url,
                search.index,
                search.slug,
                search.title
            )
        }
    }

    fun mapRecipe(recipeResponse: RecipeResponse): Recipe {
        return Recipe(
            recipeResponse.title,
            recipeResponse.image_url,
            recipeResponse.slug,
            recipeResponse.author,
            recipeResponse.serves,
            recipeResponse.prepare_time,
            recipeResponse.steps.map { step ->
                Recipe.Steps(
                    step.title,
                    step.ingredients,
                    formatStep(step.preparation)
                )
            }
        )
    }

    private fun formatStep(preparation: String): List<String> {
        return preparation.split('\n').filter { it.isNotBlank() }
    }
}
