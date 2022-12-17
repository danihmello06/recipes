package danihmello.tcc.recipes.api

import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {

    companion object{
        const val BASE_URL = "https://recipescraping.herokuapp.com/"
    }

    @GET("/search")
    suspend fun searchRecipes(
        @Query("word") word: String
    ): List<SearchResponse>

    @GET("/recipe")
    suspend fun recipe(
        @Query("slug") slug: String,
        @Query("author") author: String
    ): RecipeResponse

}
