package danihmello.tcc.recipes.database.domain

import danihmello.tcc.recipes.database.entity.FavoriteRecipeEntity
import javax.inject.Inject

class SaveFavoriteRecipeToDatabaseUseCase @Inject constructor(
    private val repository: FavoriteRecipeRepository
) {

    suspend fun saveFavoriteRecipe(favoriteRecipeEntity: FavoriteRecipeEntity) {
        return repository.saveRecipe(favoriteRecipeEntity)
    }
}