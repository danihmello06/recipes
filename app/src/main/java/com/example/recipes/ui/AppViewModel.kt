package com.example.recipes.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.data.Recipe
import com.example.recipes.data.Search
import com.example.recipes.domain.RecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val recipesUseCase: RecipesUseCase
) : ViewModel() {

    private val _search = MutableLiveData<List<Search>>()
    val searchResult: LiveData<List<Search>> get() = _search

    private val _recipe = MutableLiveData<Recipe>()
    val recipeResult: LiveData<Recipe> get() = _recipe

    fun requestSearch(searchedWord: String) {
        viewModelScope.launch {
            val searchInfo = recipesUseCase.getSearchResult(searchedWord)
            _search.postValue(searchInfo)

        }
    }


    fun buildRecipe(searchedRecipe: String) {
        viewModelScope.launch {
            val recipeInfo = recipesUseCase.getRecipe(searchedRecipe)
            _recipe.postValue(recipeInfo)
        }

    }
}