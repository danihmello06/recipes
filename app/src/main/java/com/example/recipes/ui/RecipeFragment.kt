package com.example.recipes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.DEFAULT_ARGS_KEY
import androidx.navigation.fragment.navArgs
import com.example.recipes.databinding.FragmentRecipeBinding

class RecipeFragment : Fragment() {

    private var _binding: FragmentRecipeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by viewModels()

    private var recipeSlug: String? = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipeBinding.inflate(inflater, container, false)
        recipeSlug = viewModel.theSlug
        recipeSlug?.let { setContent(it) }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun setContent(slug: String) {
        binding.slug.text = slug
    }



}