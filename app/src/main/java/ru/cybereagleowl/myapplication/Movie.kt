package ru.cybereagleowl.myapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var movieCardBacgroundPicture: Int = -1,
    var movieDetailsBacgroundPicture: Int = -1,
    var isLiked: Boolean = false,
    var genere: CharSequence = "",
    var rating: Float = 0.0F,
    var reviews: Int = 0,
    var age: CharSequence = "18+",
    var movieName: CharSequence = "",
    var duration: Int = 0,
    var storyLineText: CharSequence = "",
    var actors: List<Actor> = mutableListOf()
) : Parcelable
