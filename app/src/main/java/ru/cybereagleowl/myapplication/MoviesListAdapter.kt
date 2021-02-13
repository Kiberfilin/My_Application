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
import ru.cybereagleowl.myapplication.databinding.ViewHolderMovieBinding

class MoviesListAdapter(
    context: Context,
    private var movies: List<Movie>,
    private val onMovieCardClickAction: ((movie: Movie) -> Unit)?
) : RecyclerView.Adapter<MoviesListItemViewHolder>() {
    private val inflater = LayoutInflater.from(context)
    private lateinit var binding: ViewHolderMovieBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListItemViewHolder {
        binding = ViewHolderMovieBinding.inflate(inflater, parent, false)
        return MoviesListItemViewHolder(binding).also { holder ->
            binding.movieCardConstraintLayout
                .setOnClickListener { onMovieCardClickAction?.invoke(movies[holder.adapterPosition]) }
        }
    }

    override fun onBindViewHolder(holder: MoviesListItemViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size
}

class MoviesListItemViewHolder(
    private val binding: ViewHolderMovieBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Movie) {
        val colorRedForLike = ContextCompat.getColor(itemView.context, R.color.colorRedHeart)
        val colorGrayForLike = ContextCompat.getColor(itemView.context, R.color.colorGrayHeart)
        binding.apply {
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
        }
    }

    private fun setReviewsInfo(reviews: Int) {
        val reviewsText = itemView.resources.getQuantityString(
            R.plurals.numberOfReviews,
            reviews,
            reviews
        )
        binding.reviewsTextView.text = reviewsText
    }
}