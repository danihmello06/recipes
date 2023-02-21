package danihmello.tcc.recipes.database

import androidx.room.Database
import androidx.room.RoomDatabase
import danihmello.tcc.recipes.data.Recipe
import danihmello.tcc.recipes.database.dao.RecipeDao

@Database(entities = [Recipe::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun recipeDao(): RecipeDao
}