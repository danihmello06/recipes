package danihmello.tcc.recipes.ui.model

sealed class RecipeResult {
    data class Failure(val throwable: Throwable) : RecipeResult()
    object Loading: RecipeResult()
    object Completed: RecipeResult()
}