package ru.cybereagleowl.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    val onClickAction: (movie: Movie) -> Unit = { movie -> onMovieCardClick(movie) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.main_fragment_container, FragmentMoviesList.getInstance(onClickAction), moviesListTag)
            }.commit()
        }
    }

    fun onMovieCardClick(movie: Movie) {
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