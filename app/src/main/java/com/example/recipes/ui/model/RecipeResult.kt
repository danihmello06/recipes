package com.example.recipes.ui.model

import com.example.recipes.data.Recipe

sealed class RecipeResult {
    data class Failure(val throwable: Throwable) : RecipeResult()
    object Loading: RecipeResult()
    object Completed: RecipeResult()
}