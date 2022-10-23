package com.example.recipes.ui.model

import com.example.recipes.data.Search

sealed class SearchResult {

    data class Failure(val throwable: Throwable) : SearchResult()
    object Loading: SearchResult()
    object Completed: SearchResult()
}