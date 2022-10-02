package com.example.recipes.di

import com.example.recipes.api.RecipeApi
import com.example.recipes.api.RecipesRepositoryImpl
import com.example.recipes.domain.RecipesRepository
import com.example.recipes.domain.RecipesUseCase
import com.example.recipes.domain.RecipesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(RecipeApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideRecipeApi(retrofit: Retrofit): RecipeApi =
        retrofit.create(RecipeApi::class.java)

    @Provides
    @Singleton
    fun provideRecipesRepository(repository: RecipesRepositoryImpl): RecipesRepository {
        return repository
    }
}