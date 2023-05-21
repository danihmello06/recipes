package danihmello.tcc.recipes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import danihmello.tcc.recipes.data.Search
import danihmello.tcc.recipes.databinding.FragmentSearchBinding
import danihmello.tcc.recipes.ui.adapter.SearchAdapter
import danihmello.tcc.recipes.ui.model.SearchResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AppViewModel by viewModels()
    private var wordSearched: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        wordSearched = arguments?.getString("WORD") ?: "word"
        viewModel.requestSearch(wordSearched)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apply {
            setupSearchResponseObserver()
        }

        binding.searchArrowBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun AppViewModel.setupSearchResponseObserver() {
        searchResult.observe(viewLifecycleOwner) {
            when(it) {
                is SearchResult.Completed -> {
                    searchResponse.value?.let { response ->
                        setTitle(wordSearched)
                        hideLoading()
                        binding.searchRecycler.setHasFixedSize(false)
                        binding.searchRecycler.adapter = SearchAdapter(
                            response, itemSearchClickListener()
                        )
                    }
                }
                is SearchResult.Loading -> {
                    showLoading()
                }
                is SearchResult.Failure -> {
                    hideLoading()
                    buildErrorScreen()
                }
            }
        }
    }

    private fun showLoading() {
        with(binding) {
            searchProgressBar.visibility = View.VISIBLE
            searchBgImage.visibility = View.GONE
            searchBgGradient.visibility = View.GONE
            showingResultsText.visibility = View.GONE
            searchRecipeTitle.visibility = View.GONE
            searchArrowBack.visibility = View.GONE
            searchErrorText.visibility = View.GONE
        }
    }

    private fun hideLoading() {
        with(binding) {
            searchProgressBar.visibility = View.GONE
            searchBgImage.visibility = View.VISIBLE
            searchBgGradient.visibility = View.VISIBLE
            showingResultsText.visibility = View.VISIBLE
            searchRecipeTitle.visibility = View.VISIBLE
            searchArrowBack.visibility = View.VISIBLE
            searchErrorText.visibility = View.GONE
        }
    }

    private fun buildErrorScreen() {
        with(binding) {
            searchBgImage.visibility = View.GONE
            searchBgGradient.visibility = View.GONE
            showingResultsText.visibility = View.GONE
            searchRecipeTitle.visibility = View.GONE
            searchRecycler.visibility = View.GONE
            searchProgressBar.visibility = View.GONE
            searchErrorText.visibility = View.VISIBLE
            searchArrowBack.visibility = View.VISIBLE
        }
    }

    private fun setTitle(title: String) {
        binding.searchRecipeTitle.text = title
    }

    private fun itemSearchClickListener() = object :
        danihmello.tcc.recipes.ItemSearchClickListener {
        override fun onClick(searchItem: Search) {
            val bundle = bundleOf("SLUG" to searchItem.slug, "AUTHOR" to searchItem.author)
            findNavController().navigate(SearchFragmentDirections.actionSearchToRecipe().actionId, bundle)
        }
    }
}
