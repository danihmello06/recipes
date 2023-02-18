package danihmello.tcc.recipes.data

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize
@Entity
@Parcelize
data class Recipe(
    val author: String,
    val imageUrl: String,
    val prepareTime: String,
    val serves: String,
    val slug: String,
    val steps: List<Steps>,
    val title: String
): Parcelable {

    @Parcelize
    data class Steps(
        val title: String,
        val ingredients: List<String>,
        val preparation: List<String>
    ): Parcelable

}
