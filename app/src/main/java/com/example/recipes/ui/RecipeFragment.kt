package com.example.recipes.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.recipes.Utils.loadImage
import com.example.recipes.data.Recipe
import com.example.recipes.databinding.FragmentRecipeBinding
import com.example.recipes.ui.adapter.RecipeIngredientAdapter
import com.example.recipes.ui.adapter.RecipeStepAdapter
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
    }

    private fun AppViewModel.setupRecipeResponseObserver() {
        recipeResult.observe(
            viewLifecycleOwner
        ) {
            createRecipeContent(it)
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