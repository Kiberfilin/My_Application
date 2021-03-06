package ru.cybereagleowl.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.cybereagleowl.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val onClickAction: (movie: Movie) -> Unit
        get() = { movie -> onMovieCardClick(movie) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(
                    R.id.main_fragment_container,
                    FragmentMoviesList.getInstance(),
                    moviesListTag
                )
            }.commit()
        }
    }

    private fun onMovieCardClick(movie: Movie) {
        supportFragmentManager.beginTransaction().apply {
            replace(
                R.id.main_fragment_container,
                FragmentMoviesDetails.getInstance(movie),
                moviesDetailsTag
            )
            addToBackStack(null)
        }.commit()
    }

    companion object {
        const val moviesListTag = "FRAGMENT_MOVIES_LIST"
        const val moviesDetailsTag = "FRAGMENT_MOVIES_DETAILS"
    }
}