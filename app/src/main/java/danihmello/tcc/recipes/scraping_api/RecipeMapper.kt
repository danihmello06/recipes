package danihmello.tcc.recipes.scraping_api

import danihmello.tcc.recipes.scraping_api.data.Recipe
import danihmello.tcc.recipes.scraping_api.data.Search

object RecipeMapper {

    fun mapSearch(searchResponse: List<SearchResponse>): List<Search> {
        return searchResponse.map { search ->
            Search(
                search.author,
                search.image_url,
                search.slug,
                search.title
            )
        }
    }

    fun mapRecipe(recipeResponse: RecipeResponse): Recipe {
        return Recipe(
            recipeResponse.author,
            recipeResponse.image_url,
            recipeResponse.prepare_time,
            recipeResponse.serves,
            recipeResponse.slug,
            recipeResponse.steps.map { step ->
                Recipe.Steps(
                    step.title,
                    step.ingredients,
                    formatStep(step.preparation)
                )
            },
            recipeResponse.title
        )
    }

    private fun formatStep(preparation: String): List<String> {
        return preparation.split('\n').filter { it.isNotBlank() }
    }
}
