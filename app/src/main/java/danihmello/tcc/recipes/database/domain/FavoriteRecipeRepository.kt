package danihmello.tcc.recipes.database.domain

import danihmello.tcc.recipes.database.dao.FavoriteRecipeDao
import danihmello.tcc.recipes.database.entity.FavoriteRecipeEntity
import javax.inject.Inject

class FavoriteRecipeRepository @Inject constructor(
    private val favoriteRecipeDao: FavoriteRecipeDao
) {

    suspend fun searchRecipes(): List<FavoriteRecipeEntity> {
        return favoriteRecipeDao.searchRecipes()
    }

    suspend fun saveRecipe(entity: FavoriteRecipeEntity) =
        run { favoriteRecipeDao.saveRecipe(entity) }

    suspend fun deleteRecipe(entity: FavoriteRecipeEntity) =
        run { favoriteRecipeDao.deleteRecipe(entity) }

}