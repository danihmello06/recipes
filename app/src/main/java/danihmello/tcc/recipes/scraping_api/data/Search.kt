package danihmello.tcc.recipes.scraping_api.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Search(
    val author: String,
    val imageUrl: String,
    val index: Int,
    val slug: String,
    val title: String
) : Parcelable