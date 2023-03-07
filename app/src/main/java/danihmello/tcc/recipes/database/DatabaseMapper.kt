package danihmello.tcc.recipes.database

import danihmello.tcc.recipes.database.entity.FavoriteRecipeEntity
import danihmello.tcc.recipes.scraping_api.data.Search

object DatabaseMapper {

    fun mapDatabaseSearch(favoriteRecipes: List<FavoriteRecipeEntity>): List<Search> {
        return favoriteRecipes.map { recipe ->
            Search(
                recipe.author,
                recipe.imageUrl,
                recipe.slug,
                recipe.title
            )
        }
    }

    fun mapFavoriteToDatabase(
        author: String,
        imageUrl: String,
        slug: String,
        title: String
    ): FavoriteRecipeEntity {
        return FavoriteRecipeEntity(
            0,
            author,
            slug,
            imageUrl,
            title
        )
    }
}