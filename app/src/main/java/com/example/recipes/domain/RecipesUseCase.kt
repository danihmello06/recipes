package com.example.recipes.domain

import com.example.recipes.data.Recipe
import com.example.recipes.data.Search

interface RecipesUseCase {
    suspend fun getSearchResult(): List<Search>

    suspend fun getRecipe(): Recipe
}