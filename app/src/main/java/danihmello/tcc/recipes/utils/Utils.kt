package danihmello.tcc.recipes.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import coil.load
import danihmello.tcc.recipes.R

object Utils {

    fun ImageView.loadImage(
        imageUrl: String?,
        @DrawableRes placeholder: Int? = null,
        showPlaceholder: Boolean = true,
    ) {
        load(imageUrl) {
            if (showPlaceholder) {
                placeholder(placeholder ?: R.drawable.image_placeholder)
            }
            fallback(placeholder ?: R.drawable.image_placeholder)
            error(placeholder ?: R.drawable.image_placeholder)
        }
    }
}