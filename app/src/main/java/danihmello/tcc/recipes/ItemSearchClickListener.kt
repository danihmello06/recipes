package danihmello.tcc.recipes

import danihmello.tcc.recipes.scraping_api.data.Search

interface ItemSearchClickListener {
    fun onClick(searchItem: Search)
}