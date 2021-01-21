package ru.cybereagleowl.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MoviesListAdapter(
    context: Context,
    private var movies: List<Movie>,
    private val onMovieCardClickAction: ((movie: Movie) -> Unit)?
) : RecyclerView.Adapter<MoviesListItemViewHolder>() {
    private val inflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListItemViewHolder =
        MoviesListItemViewHolder(
            inflater.inflate(R.layout.view_holder_movie, parent, false),
            onMovieCardClickAction
        )

    override fun onBindViewHolder(holder: MoviesListItemViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size
}

class MoviesListItemViewHolder(
    itemView: View,
    private val onMovieCardClickAction: ((movie: Movie) -> Unit)?
) : RecyclerView.ViewHolder(itemView) {
    private val movieCardBackgroundPicture: ImageView
    private val likeIconImageView: ImageView
    private val genereTextView: TextView
    private val reviewsTextView: TextView
    private val ageTextView: TextView
    private val durationTextView: TextView
    private val movieNameTextView: TextView
    private val star1ImageView: ImageView
    private val star2ImageView: ImageView
    private val star3ImageView: ImageView
    private val star4ImageView: ImageView
    private val star5ImageView: ImageView
    private val movieCardMaskImageView: ImageView
    private val movieCardConstraintLayout: ConstraintLayout

    init {
        itemView.apply {
            movieCardBackgroundPicture = findViewById(R.id.movie_card_background_picture)
            likeIconImageView = findViewById(R.id.like_icon_image_view)
            genereTextView = findViewById(R.id.genere_text_view)
            star1ImageView = findViewById(R.id.star_1_image_view)
            star2ImageView = findViewById(R.id.star_2_image_view)
            star3ImageView = findViewById(R.id.star_3_image_view)
            star4ImageView = findViewById(R.id.star_4_image_view)
            star5ImageView = findViewById(R.id.star_5_image_view)
            reviewsTextView = findViewById(R.id.reviews_text_view)
            ageTextView = findViewById(R.id.age_text_view)
            movieNameTextView = findViewById(R.id.movie_name_text_view)
            durationTextView = findViewById(R.id.duration_text_view)
            movieCardMaskImageView = findViewById(R.id.movie_card_mask)
            movieCardConstraintLayout = findViewById(R.id.movie_card_constraint_layout)
        }
    }

    fun bind(item: Movie) {
        val colorRedForLike = ContextCompat.getColor(itemView.context, R.color.colorRedHeart)
        val colorGrayForLike = ContextCompat.getColor(itemView.context, R.color.colorGrayHeart)
        movieCardBackgroundPicture.setImageResource(item.movieCardBacgroundPicture)
        likeIconImageView.setImageResource(R.drawable.like_icon_gray)
        if (item.isLiked) likeIconImageView.setColorFilter(colorRedForLike)
        else likeIconImageView.setColorFilter(colorGrayForLike)
        genereTextView.text = item.genere
        manageRatingStars(
            itemView.context,
            item.rating,
            star1ImageView,
            star2ImageView,
            star3ImageView,
            star4ImageView,
            star5ImageView,
            R.drawable.ic_star_movies_list_8
        )
        setReviewsInfo(item.reviews)
        ageTextView.text = item.age
        movieNameTextView.text = item.movieName
        durationTextView.text =
            itemView.resources.getString(R.string.duration_in_min, item.duration)
        movieCardConstraintLayout.setOnClickListener { onMovieCardClickAction?.invoke(item) }
    }

    private fun setReviewsInfo(reviews: Int) {
        val reviewsText = itemView.resources.getQuantityString(
            R.plurals.numberOfReviews,
            reviews,
            reviews
        )
        reviewsTextView.text = reviewsText
    }
}