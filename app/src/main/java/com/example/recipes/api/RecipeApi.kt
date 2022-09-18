package com.example.recipes.api

import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {

    companion object{
        const val BASE_URL = "https://127.0.0.1:5000/"
    }

    @GET("search/")
    suspend fun searchRecipes(
        @Query("word") word: String
    ): SearchResponse

    @GET("recipe/")
    suspend fun recipe(
        @Query("slug") slug: String
    ): RecipeResponse


}