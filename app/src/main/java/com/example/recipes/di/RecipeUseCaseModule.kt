package com.example.recipes.di

import com.example.recipes.domain.RecipesUseCase
import com.example.recipes.domain.RecipesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RecipeUseCaseModule {

    @Binds
    @Singleton
    fun provideRecipesUseCase(recipesUseCase: RecipesUseCaseImpl): RecipesUseCase

}