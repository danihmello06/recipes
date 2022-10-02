package com.example.recipes.domain

import com.example.recipes.api.RecipeResponse
import com.example.recipes.api.SearchResponse
import com.example.recipes.data.Recipe
import com.example.recipes.data.Search


interface RecipesRepository {

    suspend fun getSearchResult(searchedWord: String): List<Search>

    suspend fun getRecipe(searchedRecipe: String): Recipe

}