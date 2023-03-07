package danihmello.tcc.recipes.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import danihmello.tcc.recipes.scraping_api.data.Search
import danihmello.tcc.recipes.databinding.SearchItemBinding
import danihmello.tcc.recipes.ui.adapter.viewholder.FavoriteViewHolder
import danihmello.tcc.recipes.ui.adapter.viewholder.SearchViewHolder

class FavoriteAdapter(
    private val searchList: List<Search>,
) : RecyclerView.Adapter<FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FavoriteViewHolder(
            SearchItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(searchList[position])
    }

    override fun getItemCount(): Int = searchList.size

}
