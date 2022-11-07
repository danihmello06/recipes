package danihmello.tcc.recipes.domain

import danihmello.tcc.recipes.data.Recipe
import danihmello.tcc.recipes.data.Search


interface RecipesRepository {

    suspend fun getSearchResult(searchedWord: String): List<Search>

    suspend fun getRecipe(searchedRecipe: String): Recipe

}