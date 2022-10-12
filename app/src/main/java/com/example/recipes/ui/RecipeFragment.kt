package com.example.recipes.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.DEFAULT_ARGS_KEY
import androidx.navigation.fragment.navArgs
import com.example.recipes.databinding.FragmentRecipeBinding
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
            Log.d("RECIPE DATA: ", it.toString())
        }
    }

}