package com.example.recipes.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.ItemSearchClickListener
import com.example.recipes.data.Search
import com.example.recipes.databinding.SearchItemBinding.inflate
import com.example.recipes.ui.adapter.viewholder.SearchViewHolder

class SearchAdapter(
    private val searchList: List<Search>,
    private val searchClickListener: ItemSearchClickListener
) : RecyclerView.Adapter<SearchViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SearchViewHolder(
            inflate(layoutInflater, parent, false),
            searchClickListener
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(searchList[position])
    }

    override fun getItemCount(): Int = searchList.size

}