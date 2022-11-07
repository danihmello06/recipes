package danihmello.tcc.recipes.domain

import danihmello.tcc.recipes.data.Recipe
import danihmello.tcc.recipes.data.Search
import javax.inject.Inject

class RecipesUseCaseImpl @Inject constructor(
    private val repository: RecipesRepository
): RecipesUseCase {

    override suspend fun getSearchResult(searchedWord: String): List<Search> {
        return repository.getSearchResult(searchedWord)
    }

    override suspend fun getRecipe(searchedRecipe: String): Recipe {
        return repository.getRecipe(searchedRecipe)
    }
}