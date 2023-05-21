package danihmello.tcc.recipes.database.domain

import danihmello.tcc.recipes.database.entity.FavoriteRecipeEntity
import javax.inject.Inject

class DeleteFavoriteRecipeInDatabaseUseCase @Inject constructor(
    private val repository: FavoriteRecipeRepository
) {

    suspend fun deleteFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity) {
        return repository.deleteRecipe(favoriteRecipeEntity)
    }
}