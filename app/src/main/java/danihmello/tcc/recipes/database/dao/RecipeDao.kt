package danihmello.tcc.recipes.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import danihmello.tcc.recipes.data.Recipe

@Dao
interface RecipeDao {

    @Query("SELECT * from Recipe")
    fun searchRecipes(): List<Recipe>

    @Insert
    fun saveRecipe(vararg recipe: Recipe)

}