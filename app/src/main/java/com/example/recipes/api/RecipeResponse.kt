package com.example.recipes.api

class RecipeResponse(
    val title: String,
    val imageUrl: String,
    val slug: String,
    val author: String,
    val serves: String,
    val prepareTime: String,
    val steps: List<StepsResponse>
)

class StepsResponse(
    val title: String,
    val ingredients: List<String>,
    val preparation: String
)
