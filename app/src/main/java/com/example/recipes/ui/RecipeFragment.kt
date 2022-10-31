package com.example.recipes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.recipes.utils.Utils.loadImage
import com.example.recipes.data.Recipe
import com.example.recipes.databinding.FragmentRecipeBinding
import com.example.recipes.ui.adapter.RecipeStepAdapter
import com.example.recipes.ui.adapter.SearchAdapter
import com.example.recipes.ui.model.RecipeResult
import com.example.recipes.ui.model.SearchResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeFragment : Fragment() {

    private var _binding: FragmentRecipeBinding? = null
    private val binding get() = _binding!!
    private val recipeViewModel: AppViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipeBinding.inflate(inflater, container, false)

        val recipeSlug = arguments?.getString("SLUG") ?: "slug"
        recipeViewModel.buildRecipe(recipeSlug)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipeViewModel.apply {
            setupRecipeResponseObserver()
        }
        binding.arrowBack.setOnClickListener {
            activity?.onBackPressed()
//            findNavController().navigate(RecipeFragmentDirections.actionRecipeToHomesearch())
        }
    }

    private fun AppViewModel.setupRecipeResponseObserver() {
        recipeResult.observe(viewLifecycleOwner) {
            when(it) {
                is RecipeResult.Completed -> {
                    hideLoading()
                    showElements()
                    recipeResponse.value?.let { response ->
                        createRecipeContent(response)
                    }
                }
                is RecipeResult.Loading -> {
                    showLoading()
                    hideElements()
                }
                is RecipeResult.Failure -> {
                    hideLoading()
                }
            }
        }
    }

    private fun hideElements() {
        binding.recipeTitle.visibility = View.GONE
        binding.recipeImage.visibility = View.GONE
    }

    private fun showElements() {
        binding.recipeTitle.visibility = View.VISIBLE
        binding.recipeImage.visibility = View.VISIBLE
    }

    private fun showLoading() {
        with(binding) {
            recipeProgressBar.visibility = View.VISIBLE
        }
    }

    private fun hideLoading() {
        with(binding) {
            recipeProgressBar.visibility = View.GONE
        }
    }

    private fun createRecipeContent(recipe: Recipe) {
        with(binding) {
            recipeImage.loadImage(recipe.imageUrl)
            recipeTitle.text = recipe.title
            stepsRecycler.adapter = RecipeStepAdapter(recipe.steps)
        }
    }


}