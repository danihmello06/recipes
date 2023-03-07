package danihmello.tcc.recipes.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import danihmello.tcc.recipes.database.entity.FavoriteRecipeEntity
import danihmello.tcc.recipes.scraping_api.data.Recipe

@Dao
interface FavoriteRecipeDao {

    @Query("SELECT * from FavoriteRecipeEntity")
    suspend fun searchRecipes(): List<FavoriteRecipeEntity>

    @Insert
    suspend fun saveRecipe(entity: FavoriteRecipeEntity)

    @Delete
    suspend fun deleteRecipe(entity: FavoriteRecipeEntity)

}