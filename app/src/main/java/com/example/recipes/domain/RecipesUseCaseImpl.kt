package com.example.recipes.domain

import com.example.recipes.data.Recipe
import com.example.recipes.data.Search
import javax.inject.Inject

class RecipesUseCaseImpl @Inject constructor(
    private val repository: RecipesRepository
): RecipesUseCase {

    override suspend fun getSearchResult(): List<Search> {
        return repository.getSearchResult()
    }

    override suspend fun getRecipe(): Recipe {
        return repository.getRecipe()
    }
}