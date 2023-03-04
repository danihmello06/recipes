package danihmello.tcc.recipes.scraping_api.domain

import danihmello.tcc.recipes.scraping_api.data.Recipe
import danihmello.tcc.recipes.scraping_api.data.Search

interface RecipesUseCase {
    suspend fun getSearchResult(searchedWord: String): List<Search>

    suspend fun getRecipe(searchedRecipe: String, author: String): Recipe
}