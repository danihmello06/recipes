package danihmello.tcc.recipes.ui.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import danihmello.tcc.recipes.utils.Utils.loadImage
import danihmello.tcc.recipes.scraping_api.data.Search
import danihmello.tcc.recipes.databinding.SearchItemBinding

class SearchViewHolder(
    private val binding: SearchItemBinding,
    private val listener: danihmello.tcc.recipes.ItemSearchClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(itemSearch: Search) {
        setContent(itemSearch)
    }

    private fun setContent(itemSearch: Search) {
        with(binding) {
            searchTitle.text = itemSearch.title
            searchItemImage.loadImage(itemSearch.imageUrl)
            root.setOnClickListener {listener.onClick(itemSearch)}
        }
    }
}
