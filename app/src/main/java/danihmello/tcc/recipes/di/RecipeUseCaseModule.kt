package danihmello.tcc.recipes.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import danihmello.tcc.recipes.domain.RecipesUseCase
import danihmello.tcc.recipes.domain.RecipesUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RecipeUseCaseModule {

    @Binds
    @Singleton
    fun provideRecipesUseCase(recipesUseCase: RecipesUseCaseImpl): RecipesUseCase
}
