package danihmello.tcc.recipes.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
@Entity
@Parcelize
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0,
    var author: String?,
    var imageUrl: String?,
    var prepareTime: String?,
    var serves: String?,
    var slug: String?,
    @Ignore var steps: List<Steps>? = null,
    var title: String?
): Parcelable {

    constructor(): this (
        id = null,
        author = null,
        imageUrl = null,
        prepareTime = null,
        serves = null,
        slug = null,
        steps = null,
        title = null
    )

    @Parcelize
    data class Steps(
        val title: String,
        val ingredients: List<String>,
        val preparation: List<String>
    ): Parcelable

}
