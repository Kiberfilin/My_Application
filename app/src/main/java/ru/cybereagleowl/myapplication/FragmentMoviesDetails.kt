package ru.cybereagleowl.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.cybereagleowl.myapplication.databinding.FragmentMoviesDetailsBinding

class FragmentMoviesDetails : Fragment() {
    private var _binding: FragmentMoviesDetailsBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    private lateinit var movieToDisplay: Movie
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesDetailsBinding.inflate(inflater, container, false)
        val onBackClick = View.OnClickListener { activity?.onBackPressed() }
        binding.apply {
            backIcon.setOnClickListener(onBackClick)
            backText.setOnClickListener(onBackClick)
        }
        return binding.root
    }

    private fun setReviewsInfo(reviews: Int) {
        val reviewsText = resources.getQuantityString(
            R.plurals.numberOfReviews,
            reviews,
            reviews
        )
        binding.reviewsTextView.text = reviewsText
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (this::movieToDisplay.isInitialized) {
            outState.putParcelable(TAG_FOR_SAVING_MOVIE, movieToDisplay)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        savedInstanceState?.getParcelable<Movie>(TAG_FOR_SAVING_MOVIE)?.apply {
            movieToDisplay = this
        }
        binding.actorsRvMoviesDetails.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = ActorAdapter(activity as Context, movieToDisplay.actors)
        }
        movieToDisplay.apply {
            binding.apply {
                movieDetailsBacgroundImgView.setImageResource(movieDetailsBacgroundPicture)
                ageTextView.text = age
                movieNameTextView.text = movieName
                genereTextView.text = genere
                manageRatingStars(
                    activity as Context,
                    rating,
                    star1ImageView,
                    star2ImageView,
                    star3ImageView,
                    star4ImageView,
                    star5ImageView,
                    R.drawable.ic_star_movies_details_14
                )
                setReviewsInfo(reviews)
                storylineContentTextView.text = storyLineText
            }
        }
    }

    companion object {
        fun getInstance(movie: Movie): FragmentMoviesDetails {
            val newFragment = FragmentMoviesDetails()
            newFragment.movieToDisplay = movie
            return newFragment
        }

        private const val TAG_FOR_SAVING_MOVIE = "TAG_FOR_SAVING_MOVIE"
    }
}