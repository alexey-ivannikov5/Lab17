package ru.alexeyivannikov.lab17

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import ru.alexeyivannikov.lab17.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController


        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_music -> {
                    navController.navigate(R.id.musicFragment)
                    true
                }

                R.id.menu_books -> {
                    navController.navigate(R.id.booksFragment)
                    true
                }

                R.id.menu_news -> {
                    navController.navigate(R.id.newsFragment)
                    true
                }

                else -> false
            }
        }

        val badge = binding.bottomNav.getOrCreateBadge(R.id.menu_news)
        NotificationTimer.badge = badge

        NotificationTimer.start()
    }
}