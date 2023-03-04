package danihmello.tcc.recipes.scraping_api

import danihmello.tcc.recipes.scraping_api.data.Recipe
import danihmello.tcc.recipes.scraping_api.data.Search
import danihmello.tcc.recipes.scraping_api.domain.RecipesRepository
import javax.inject.Inject

class RecipesRepositoryImpl @Inject constructor(
    private val service: RecipeApi
) : RecipesRepository {

    override suspend fun getSearchResult(searchedWord: String): List<Search> {
        val response = service.searchRecipes(searchedWord)
        return RecipeMapper.mapSearch(response)
    }

    override suspend fun getRecipe(searchedRecipe: String, author: String): Recipe {
        val response = service.recipe(searchedRecipe, author)
        return RecipeMapper.mapRecipe(response)
    }
}