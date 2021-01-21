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

class FragmentMoviesDetails : Fragment() {
    private lateinit var backIcon: ImageView
    private lateinit var backText: TextView
    private lateinit var movieCardBackgroundPicture: ImageView
    private lateinit var ageTextView: TextView
    private lateinit var movieNameTextView: TextView
    private lateinit var genereTextView: TextView
    private lateinit var star1ImageView: ImageView
    private lateinit var star2ImageView: ImageView
    private lateinit var star3ImageView: ImageView
    private lateinit var star4ImageView: ImageView
    private lateinit var star5ImageView: ImageView
    private lateinit var reviewsTextView: TextView
    private lateinit var storylineContentTextView: TextView
    private lateinit var actorsRecyclerView: RecyclerView

    private lateinit var movieToDisplay: Movie
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_movies_details, container, false)
        rootView.apply {
            backIcon = findViewById(R.id.back_icon)
            backText = findViewById(R.id.back_text)
            movieCardBackgroundPicture = findViewById(R.id.movie_details_bacground_img_view)
            ageTextView = findViewById(R.id.age_text_view)
            movieNameTextView = findViewById(R.id.movie_name_text_view)
            genereTextView = findViewById(R.id.genere_text_view)
            star1ImageView = findViewById(R.id.star_1_image_view)
            star2ImageView = findViewById(R.id.star_2_image_view)
            star3ImageView = findViewById(R.id.star_3_image_view)
            star4ImageView = findViewById(R.id.star_4_image_view)
            star5ImageView = findViewById(R.id.star_5_image_view)
            reviewsTextView = findViewById(R.id.reviews_text_view)
            storylineContentTextView = findViewById(R.id.storyline_content_text_view)
            actorsRecyclerView = findViewById(R.id.actors_rv_movies_details)
        }
        val onBackClick = View.OnClickListener { activity?.onBackPressed() }
        backIcon.setOnClickListener(onBackClick)
        backText.setOnClickListener(onBackClick)
        return rootView
    }

    private fun setReviewsInfo(reviews: Int) {
        val reviewsText = resources.getQuantityString(
            R.plurals.numberOfReviews,
            reviews,
            reviews
        )
        reviewsTextView.text = reviewsText
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
        actorsRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = ActorAdapter(activity as Context, movieToDisplay.actors)
        }
        movieToDisplay.apply {
            movieCardBackgroundPicture.setImageResource(movieDetailsBacgroundPicture)
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

    companion object {
        fun getInstance(movie: Movie): FragmentMoviesDetails {
            val newFragment = FragmentMoviesDetails()
            newFragment.movieToDisplay = movie
            return newFragment
        }

        private const val TAG_FOR_SAVING_MOVIE = "TAG_FOR_SAVING_MOVIE"
    }
}