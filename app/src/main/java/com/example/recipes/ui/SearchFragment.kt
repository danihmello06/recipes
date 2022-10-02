package com.example.recipes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipes.R
import com.example.recipes.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

//    private fun MyViewModel.setupResponseObserver() {
//        searchResult.observe(viewLifecycleOwner) {
//            binding.searchRecycler.adapter = SearchAdapter(
//                it, itemSearchClickListener()
//            )
//        }
//    }
//
//    private fun itemSearchClickListener() = object : ItemSearchClickListener {
//
//    }
}