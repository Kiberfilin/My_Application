package ru.cybereagleowl.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesList : Fragment() {
    private lateinit var onMovieCardClickAction: (movie: Movie) -> Unit
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_movies_list, container, false)
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.movie_list_rv)
        val actors: List<Actor> = mutableListOf(
            Actor(R.drawable.actor1, resources.getString(R.string.actor_1_string)),
            Actor(R.drawable.actor2, resources.getString(R.string.actor_2_string)),
            Actor(R.drawable.actor3, resources.getString(R.string.actor_3_string)),
            Actor(R.drawable.actor4, resources.getString(R.string.actor_4_string)),
            Actor(R.drawable.actor1, resources.getString(R.string.actor_1_string)),
            Actor(R.drawable.actor2, resources.getString(R.string.actor_2_string)),
            Actor(R.drawable.actor3, resources.getString(R.string.actor_3_string)),
            Actor(R.drawable.actor4, resources.getString(R.string.actor_4_string)),
            Actor(R.drawable.actor1, resources.getString(R.string.actor_1_string)),
            Actor(R.drawable.actor2, resources.getString(R.string.actor_2_string)),
            Actor(R.drawable.actor3, resources.getString(R.string.actor_3_string)),
            Actor(R.drawable.actor4, resources.getString(R.string.actor_4_string)),
            Actor(R.drawable.actor1, resources.getString(R.string.actor_1_string)),
            Actor(R.drawable.actor2, resources.getString(R.string.actor_2_string)),
            Actor(R.drawable.actor3, resources.getString(R.string.actor_3_string)),
            Actor(R.drawable.actor4, resources.getString(R.string.actor_4_string))
        )
        val listOfMovies = ArrayList<Movie>()
        listOfMovies.add(
            Movie(
                R.drawable.movie_card_picture_avengers_endgame,
                R.drawable.orig,
                false,
                "Action, Adventure, Drama",
                4.3F,
                125,
                "13+",
                "Avengers: End Game",
                137,
                resources.getString(R.string.storyline_content_string),
                actors
            )
        )
        listOfMovies.add(
            Movie(
                R.drawable.movie_card_picture_tenet,
                R.drawable.orig,
                true,
                "Action, Sci-Fi, Thriller",
                5F,
                98,
                "16+",
                "Tenet",
                97,
                "Tenet storyline Tenet storyline Tenet storyline Tenet storyline Tenet storyline Tenet storyline Tenet storyline Tenet storyline Tenet storyline Tenet storyline Tenet storyline Tenet storyline Tenet storyline Tenet storyline Tenet storyline ",
                actors
            )
        )
        listOfMovies.add(
            Movie(
                R.drawable.movie_card_picture_black_widow,
                R.drawable.orig,
                false,
                "Action, Adventure, Sci-Fi",
                4.3F,
                38,
                "13+",
                "Black Widow",
                102,
                "Black Widow storyline Black Widow storyline Black Widow storyline Black Widow storyline Black Widow storyline Black Widow storyline Black Widow storyline Black Widow storyline Black Widow storyline Black Widow storyline Black Widow storyline Black Widow storyline Black Widow storyline ",
                actors
            )
        )
        listOfMovies.add(
            Movie(
                R.drawable.movie_card_picture_wonder_woman_1984,
                R.drawable.orig,
                false,
                "Action, Adventure, Fantasy",
                5.0F,
                74,
                "13+",
                "Wonder Woman 1984",
                120,
                "Wonder Woman 1984 storyline Wonder Woman 1984 storyline Wonder Woman 1984 storyline Wonder Woman 1984 storyline Wonder Woman 1984 storyline Wonder Woman 1984 storyline Wonder Woman 1984 storyline Wonder Woman 1984 storyline Wonder Woman 1984 storyline Wonder Woman 1984 storyline Wonder Woman 1984 storyline Wonder Woman 1984 storyline ",
                actors
            )
        )
        recyclerView.adapter =
            MoviesListAdapter(rootView.context, listOfMovies, onMovieCardClickAction)
        recyclerView.layoutManager =
            GridLayoutManager(rootView.context, 2, GridLayoutManager.VERTICAL, false)
        return rootView
    }

    companion object {
        fun getInstance(onClickAction: (movie: Movie) -> Unit): FragmentMoviesList {
            val newFragment = FragmentMoviesList()
            newFragment.onMovieCardClickAction = onClickAction
            return newFragment
        }
    }
}