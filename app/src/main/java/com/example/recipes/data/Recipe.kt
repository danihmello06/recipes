package com.example.recipes.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipe(
    val title: String,
    val imageUrl: String,
    val slug: String,
    val author: String,
    val serves: String,
    val prepareTime: String,
    val steps: Steps
): Parcelable {

    @Parcelize
    data class Steps(
        val title: String,
        val ingredients: List<String>,
        val preparation: String
    ): Parcelable



}