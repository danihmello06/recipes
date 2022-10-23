package com.example.recipes.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.data.Recipe
import com.example.recipes.data.Search
import com.example.recipes.domain.RecipesUseCase
import com.example.recipes.ui.model.RecipeResult
import com.example.recipes.ui.model.SearchResult
import com.example.recipes.utils.CustomCoroutineScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val recipesUseCase: RecipesUseCase,
) : ViewModel(), CustomCoroutineScope {

    override val fragmentExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            _searchResult.postValue(SearchResult.Failure(throwable))
            _recipeResult.postValue(RecipeResult.Failure(throwable))
        }

    private val _searchResult = MutableLiveData<SearchResult>()
    val searchResult: LiveData<SearchResult> get() = _searchResult

    private val _searchResponse = MutableLiveData<List<Search>>()
    val searchResponse: LiveData<List<Search>> get() = _searchResponse

    private val _recipeResult = MutableLiveData<RecipeResult>()
    val recipeResult: LiveData<RecipeResult> get() = _recipeResult

    private val _recipeResponse = MutableLiveData<Recipe>()
    val recipeResponse: LiveData<Recipe> get() = _recipeResponse

    fun requestSearch(searchedWord: String) {
        viewModelScope.safeLaunch {
            _searchResult.postValue(SearchResult.Loading)
            val searchInfo = recipesUseCase.getSearchResult(searchedWord)
            _searchResponse.postValue(searchInfo)
            _searchResult.postValue(SearchResult.Completed)
        }
    }

    fun buildRecipe(searchedRecipe: String) {
        viewModelScope.safeLaunch {
            _recipeResult.postValue(RecipeResult.Loading)
            val recipeInfo = recipesUseCase.getRecipe(searchedRecipe)
            _recipeResponse.postValue(recipeInfo)
            _recipeResult.postValue(RecipeResult.Completed)
        }
    }
}