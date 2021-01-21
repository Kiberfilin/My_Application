package ru.cybereagleowl.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesList : Fragment() {
    private var onMovieCardClickAction: ((movie: Movie) -> Unit)? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_movies_list, container, false)
        val recyclerView = rootView.findViewById<RecyclerView>(R.id.movie_list_rv)

        recyclerView.adapter =
            MoviesListAdapter(
                rootView.context,
                getListOfMovies(activity as Context),
                onMovieCardClickAction
            )
        recyclerView.layoutManager =
            GridLayoutManager(rootView.context, 2, GridLayoutManager.VERTICAL, false)
        return rootView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) onMovieCardClickAction = context.onClickAction
    }

    override fun onDetach() {
        onMovieCardClickAction = null
        super.onDetach()
    }

    companion object {
        fun getInstance(): FragmentMoviesList = FragmentMoviesList()
    }
}