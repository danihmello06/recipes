package com.example.recipes.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipe(
    val id: String,
    val title: String,
    val url: String,
    val ingredient: Ingredient,
    val instruction: Instruction
): Parcelable {

    @Parcelize
    data class Ingredient(
        val amount: Double,
        val unity: String,
        val ingredientItem: String
    ): Parcelable

    @Parcelize
    data class Instruction(
        val instructionStep: String
    ): Parcelable

}