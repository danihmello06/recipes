package danihmello.tcc.recipes.database

import androidx.room.Database
import androidx.room.RoomDatabase
import danihmello.tcc.recipes.database.dao.FavoriteRecipeDao
import danihmello.tcc.recipes.database.entity.FavoriteRecipeEntity

@Database(entities = [FavoriteRecipeEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun favoriteRecipeDao(): FavoriteRecipeDao

    companion object {
        const val DATABASE_NAME = "recipeapp-db"
    }
}