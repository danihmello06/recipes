package danihmello.tcc.recipes.ui.model

sealed class FavoriteRecipeResult {

    data class Failure(val throwable: Throwable) : FavoriteRecipeResult()
    object Loading: FavoriteRecipeResult()
    object Completed: FavoriteRecipeResult()
}