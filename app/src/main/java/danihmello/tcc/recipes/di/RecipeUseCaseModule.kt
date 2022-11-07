package danihmello.tcc.recipes.di

import danihmello.tcc.recipes.domain.RecipesUseCase
import danihmello.tcc.recipes.domain.RecipesUseCaseImpl
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