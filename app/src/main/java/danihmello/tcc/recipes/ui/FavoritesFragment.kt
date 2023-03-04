package danihmello.tcc.recipes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import danihmello.tcc.recipes.R
import danihmello.tcc.recipes.scraping_api.data.Recipe
import danihmello.tcc.recipes.database.AppDatabase

class FavoritesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }


}