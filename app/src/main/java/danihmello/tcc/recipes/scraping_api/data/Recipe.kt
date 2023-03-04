package danihmello.tcc.recipes.scraping_api.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipe(
    var author: String?,
    var imageUrl: String?,
    var prepareTime: String?,
    var serves: String?,
    var slug: String?,
    var steps: List<Steps>? = null,
    var title: String?
): Parcelable {

    @Parcelize
    data class Steps(
        val title: String,
        val ingredients: List<String>,
        val preparation: List<String>
    ): Parcelable

}
