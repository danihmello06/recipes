package danihmello.tcc.recipes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.room.Room
import danihmello.tcc.recipes.utils.Utils.loadImage
import danihmello.tcc.recipes.data.Recipe
import danihmello.tcc.recipes.databinding.FragmentRecipeBinding
import danihmello.tcc.recipes.ui.adapter.RecipeStepAdapter
import danihmello.tcc.recipes.ui.model.RecipeResult
import dagger.hilt.android.AndroidEntryPoint
import danihmello.tcc.recipes.database.AppDatabase

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
        val recipeAuthor = arguments?.getString("AUTHOR") ?: "author"

        recipeViewModel.buildRecipe(recipeSlug, recipeAuthor)
//        buildDatabase()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipeViewModel.apply {
            setupRecipeResponseObserver()
        }
        binding.arrowBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun buildDatabase() {
        val db = Room.databaseBuilder(
            this.requireContext(),
            AppDatabase::class.java,
            "recipes.db"
        ).allowMainThreadQueries()   //TODO: Change this to coroutines
            .build()

        val recipeDao = db.recipeDao()
        recipeDao.saveRecipe(
            Recipe(
                author = "panelinha",
                imageUrl = "https://cdn.panelinha.com.br/receita/1519935983906-receita%20batata%20palha.jpg",
                prepareTime = "blabla",
                serves = "serves",
                slug="Batata-doce-palha-assada",
                steps = listOf(Recipe.Steps("", listOf(""), listOf(""))),
                title = "title"
            )
        )
        recipeViewModel.mockRecipe(recipeDao.searchRecipes())
    }

    private fun AppViewModel.setupRecipeResponseObserver() {
        recipeResult.observe(viewLifecycleOwner) {
            when(it) {
                is RecipeResult.Completed -> {
                    hideLoading()
                    recipeResponse.value?.let { response ->
                        createRecipeContent(response)
                    }
                }
                is RecipeResult.Loading -> {
                    showLoading()
                }
                is RecipeResult.Failure -> {
                    showErrorScreen()
                }
            }
        }
    }

    private fun showLoading() {
        with(binding) {
            recipeProgressBar.visibility = View.VISIBLE
            binding.recipeTitle.visibility = View.GONE
            binding.recipeImage.visibility = View.GONE
            binding.arrowBack.visibility = View.GONE
        }
    }

    private fun hideLoading() {
        with(binding) {
            recipeProgressBar.visibility = View.GONE
            binding.recipeTitle.visibility = View.VISIBLE
            binding.recipeImage.visibility = View.VISIBLE
            binding.arrowBack.visibility = View.VISIBLE
        }
    }

    private fun showErrorScreen() {
        with(binding) {
            recipeProgressBar.visibility = View.GONE
            recipeTitle.visibility = View.GONE
            recipeImage.visibility = View.GONE
            errorImage.visibility = View.VISIBLE
            errorMessage.visibility = View.VISIBLE
            binding.arrowBack.visibility = View.VISIBLE
        }
    }

    private fun createRecipeContent(recipe: Recipe) {
        with(binding) {
            recipeImage.loadImage(recipe.imageUrl)
            recipeTitle.text = recipe.title
            stepsRecycler.adapter = RecipeStepAdapter(recipe.steps!!)
        }
    }
}
