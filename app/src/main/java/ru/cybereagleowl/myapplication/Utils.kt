package ru.cybereagleowl.myapplication

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.widget.ImageView
import androidx.core.content.ContextCompat

fun manageRatingStars(
    context: Context,
    movieRating: Float,
    star1ImageView: ImageView,
    star2ImageView: ImageView,
    star3ImageView: ImageView,
    star4ImageView: ImageView,
    star5ImageView: ImageView,
    starDrawableId: Int
) {
    Log.d("manageRatingStars", "movieRating = $movieRating")
    val colorRed = ContextCompat.getColor(context, R.color.colorRedStar)
    val colorGray = ContextCompat.getColor(context, R.color.colorGrayStar)

    star1ImageView.setImageResource(starDrawableId)
    star2ImageView.setImageResource(starDrawableId)
    star3ImageView.setImageResource(starDrawableId)
    star4ImageView.setImageResource(starDrawableId)
    star5ImageView.setImageResource(starDrawableId)

    if (movieRating in 1.0F..5.0F) star1ImageView.setColorFilter(colorRed) else star1ImageView.setColorFilter(colorGray)
    Log.d("manageRatingStars", "movieRating in 1.0F..5.0F = ${movieRating in 1.0F..5.0F}")
    if (movieRating in 2.0F..5.0F) star2ImageView.setColorFilter(colorRed) else star2ImageView.setColorFilter(colorGray)
    Log.d("manageRatingStars", "movieRating in 2.0F..5.0F = ${movieRating in 2.0F..5.0F}")
    if (movieRating in 3.0F..5.0F) star3ImageView.setColorFilter(colorRed) else star3ImageView.setColorFilter(colorGray)
    Log.d("manageRatingStars", "movieRating in 3.0F..5.0F = ${movieRating in 3.0F..5.0F}")
    if (movieRating in 4.0F..5.0F) star4ImageView.setColorFilter(colorRed) else star4ImageView.setColorFilter(colorGray)
    Log.d("manageRatingStars", "movieRating in 4.0F..5.0F = ${movieRating in 4.0F..5.0F}")
    if (movieRating in 5.0F..5.0F) star5ImageView.setColorFilter(colorRed) else star5ImageView.setColorFilter(colorGray)
    Log.d("manageRatingStars", "movieRating in 5.0F..5.0F = ${movieRating in 5.0F..5.0F}")
}