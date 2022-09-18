package com.example.recipes.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Search(
    val slug: String,
    val imageUrl: String,
    val title: String
) : Parcelable