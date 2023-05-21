package danihmello.tcc.recipes.ui.model

sealed class SearchResult {

    data class Failure(val throwable: Throwable) : SearchResult()
    object Loading : SearchResult()
    object Completed : SearchResult()
}
