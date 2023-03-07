package danihmello.tcc.recipes.database.domain

import danihmello.tcc.recipes.database.DatabaseMapper
import danihmello.tcc.recipes.database.entity.FavoriteRecipeEntity
import danihmello.tcc.recipes.scraping_api.data.Search
import javax.inject.Inject

class GetFavoriteRecipesFromDatabaseUseCase @Inject constructor(
    private val repository: FavoriteRecipeRepository
) {
    suspend fun getFavoriteRecipes(): List<Search> {
        return DatabaseMapper.mapDatabaseSearch(repository.searchRecipes())
    }
}