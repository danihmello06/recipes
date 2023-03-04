package danihmello.tcc.recipes.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import danihmello.tcc.recipes.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import danihmello.tcc.recipes.R
import danihmello.tcc.recipes.database.AppDatabase

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navController: NavController by lazy { findNavController(R.id.navHostFragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        setBottomNavigation()
    }

    private fun setBottomNavigation() {
        with(binding.bottomNavigationView) {
            setupWithNavController(navController)

            setOnItemSelectedListener {
                navController.navigate(it.itemId)
                true
            }

        }
    }

}