package ru.cybereagleowl.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.cybereagleowl.myapplication.databinding.FragmentMoviesDetailsBinding
import ru.cybereagleowl.myapplication.databinding.FragmentMoviesListBinding

class FragmentMoviesList : Fragment() {
    private var _binding: FragmentMoviesListBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    private var onMovieCardClickAction: ((movie: Movie) -> Unit)? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesListBinding.inflate(inflater, container, false)
        binding.apply {
            movieListRv.adapter =
                MoviesListAdapter(
                    root.context,
                    getListOfMovies(activity as Context),
                    onMovieCardClickAction
                )
            movieListRv.layoutManager =
                GridLayoutManager(root.context, 2, GridLayoutManager.VERTICAL, false)
        }
        return binding.root
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