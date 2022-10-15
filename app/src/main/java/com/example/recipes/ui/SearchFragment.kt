package com.example.recipes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.recipes.ItemSearchClickListener
import com.example.recipes.data.Search
import com.example.recipes.databinding.FragmentSearchBinding
import com.example.recipes.ui.adapter.SearchAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        setupListener()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apply {
            setupSearchResponseObserver()
        }
    }

    private fun setupListener() {
        val searchView = binding.searchToolbar.searchButton
        searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {
                    query?.let {
                        viewModel.requestSearch(it)
                    }
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            }
        )
    }

    private fun AppViewModel.setupSearchResponseObserver() {
        searchResult.observe(
            viewLifecycleOwner
        ) {
//            binding.searchRecycler.setHasFixedSize(true)
            binding.searchRecycler.adapter = SearchAdapter(
                it, itemSearchClickListener()
            )
        }
    }

    private fun itemSearchClickListener() = object : ItemSearchClickListener {
        override fun onClick(searchItem: Search) {
            val bundle = bundleOf("SLUG" to searchItem.slug)
            findNavController().navigate(SearchFragmentDirections.actionHomesearchToRecipe().actionId, bundle)
        }

    }
}