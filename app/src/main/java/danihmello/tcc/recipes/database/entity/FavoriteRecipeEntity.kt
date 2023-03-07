package danihmello.tcc.recipes.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteRecipeEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var author: String = "",
    var slug: String = "",
    var imageUrl: String = "",
    var title: String = "",
)