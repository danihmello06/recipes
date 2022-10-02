package com.example.recipes.api

import android.util.Log
import com.example.recipes.data.Recipe
import com.example.recipes.data.Search
import com.example.recipes.domain.RecipesRepository
import javax.inject.Inject

class RecipesRepositoryImpl @Inject constructor(
    private val service: RecipeApi
) : RecipesRepository {

    override suspend fun getSearchResult(searchedWord: String): List<Search> {
        val response = service.searchRecipes(searchedWord)
        return RecipeMapper.mapSearch(response)
    }

    override suspend fun getRecipe(searchedRecipe: String): Recipe {
        val response = service.recipe(searchedRecipe)
        return RecipeMapper.mapRecipe(response)
    }
}