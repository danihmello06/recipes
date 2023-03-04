package danihmello.tcc.recipes.scraping_api.di

import danihmello.tcc.recipes.scraping_api.domain.RecipesUseCase
import danihmello.tcc.recipes.scraping_api.domain.RecipesUseCaseImpl
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