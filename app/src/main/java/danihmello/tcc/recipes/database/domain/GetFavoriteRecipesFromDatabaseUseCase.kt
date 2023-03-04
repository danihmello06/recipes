package danihmello.tcc.recipes.database.domain

import danihmello.tcc.recipes.database.entity.FavoriteRecipeEntity
import javax.inject.Inject

class GetFavoriteRecipesFromDatabaseUseCase @Inject constructor(
    private val repository: FavoriteRecipeRepository
) {
    suspend fun getFavoriteRecipes(): List<FavoriteRecipeEntity> {
        return repository.searchRecipes()
    }
}