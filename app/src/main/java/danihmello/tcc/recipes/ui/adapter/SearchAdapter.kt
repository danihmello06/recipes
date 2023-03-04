package danihmello.tcc.recipes.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import danihmello.tcc.recipes.scraping_api.data.Search
import danihmello.tcc.recipes.databinding.SearchItemBinding
import danihmello.tcc.recipes.ui.adapter.viewholder.SearchViewHolder

class SearchAdapter(
    private val searchList: List<Search>,
    private val searchClickListener: danihmello.tcc.recipes.ItemSearchClickListener
) : RecyclerView.Adapter<SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SearchViewHolder(
            SearchItemBinding.inflate(layoutInflater, parent, false),
            searchClickListener
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(searchList[position])
    }

    override fun getItemCount(): Int = searchList.size

}
