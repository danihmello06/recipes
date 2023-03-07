package danihmello.tcc.recipes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.room.Room
import dagger.hilt.android.AndroidEntryPoint
import danihmello.tcc.recipes.R
import danihmello.tcc.recipes.scraping_api.data.Recipe
import danihmello.tcc.recipes.database.AppDatabase
import danihmello.tcc.recipes.databinding.FragmentFavoritesBinding
import danihmello.tcc.recipes.ui.adapter.FavoriteAdapter
import danihmello.tcc.recipes.ui.model.FavoriteRecipeResult

@AndroidEntryPoint
class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!
    private val appViewModel: AppViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)

        appViewModel.getRecipesFromDB()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appViewModel.apply {
            setupGetFavoriteRecipesObserver()
        }
    }

    private fun AppViewModel.setupGetFavoriteRecipesObserver() {
        favoriteResult.observe(viewLifecycleOwner) {
            when (it) {
                is FavoriteRecipeResult.Completed -> {
                    favoriteResponse.value?.let { response ->
                        binding.favoriteRecycler.adapter = FavoriteAdapter(
                            response
                        )

                    }
                }
            }
        }
    }


}