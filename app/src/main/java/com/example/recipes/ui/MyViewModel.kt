package com.example.recipes.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipes.api.SearchResponse
import com.example.recipes.data.Recipe
import com.example.recipes.data.Search
import com.example.recipes.domain.RecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val recipesUseCase: RecipesUseCase
) : ViewModel() {

    private val _search = MutableLiveData<List<Search>>()
    val searchResult: LiveData<List<Search>> get() = _search


    private var recipeInfo: List<Recipe> = listOf()

    fun requestSearch(searchedWord: String) {
        viewModelScope.launch {
            val searchInfo = recipesUseCase.getSearchResult(searchedWord)
            _search.postValue(searchInfo)

            Log.d("RESULTADO: ", searchInfo.toString())
        }
    }

    fun buildRecipe(searchedRecipe: String) {
        viewModelScope.launch {
            recipesUseCase.getRecipe(searchedRecipe)

        }

    }
}