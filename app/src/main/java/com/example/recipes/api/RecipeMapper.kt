package com.example.recipes.api

import com.example.recipes.data.Recipe
import com.example.recipes.data.Search

object RecipeMapper {

    fun mapSearch(searchResponse: List<SearchResponse>): List<Search> {
        return searchResponse.map { search ->
            Search(
                search.slug,
                search.imageUrl,
                search.title
            )
        }
    }

    fun mapRecipe(recipeResponse: RecipeResponse): Recipe {
        return Recipe(
            recipeResponse.title,
            recipeResponse.imageUrl,
            recipeResponse.slug,
            recipeResponse.author,
            recipeResponse.serves,
            recipeResponse.prepareTime,
            recipeResponse.steps.map { step ->
                Recipe.Steps(
                    step.title,
                    step.ingredients,
                    step.preparation
                )
            }
        )
    }
}
