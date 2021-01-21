package ru.cybereagleowl.myapplication

import android.content.Context

private fun getActors(context: Context): List<Actor> = mutableListOf(
    Actor(R.drawable.actor1, context.resources.getString(R.string.actor_1_string)),
    Actor(R.drawable.actor2, context.resources.getString(R.string.actor_2_string)),
    Actor(R.drawable.actor3, context.resources.getString(R.string.actor_3_string)),
    Actor(R.drawable.actor4, context.resources.getString(R.string.actor_4_string)),
    Actor(R.drawable.actor1, context.resources.getString(R.string.actor_1_string)),
    Actor(R.drawable.actor2, context.resources.getString(R.string.actor_2_string)),
    Actor(R.drawable.actor3, context.resources.getString(R.string.actor_3_string)),
    Actor(R.drawable.actor4, context.resources.getString(R.string.actor_4_string)),
    Actor(R.drawable.actor1, context.resources.getString(R.string.actor_1_string)),
    Actor(R.drawable.actor2, context.resources.getString(R.string.actor_2_string)),
    Actor(R.drawable.actor3, context.resources.getString(R.string.actor_3_string)),
    Actor(R.drawable.actor4, context.resources.getString(R.string.actor_4_string)),
    Actor(R.drawable.actor1, context.resources.getString(R.string.actor_1_string)),
    Actor(R.drawable.actor2, context.resources.getString(R.string.actor_2_string)),
    Actor(R.drawable.actor3, context.resources.getString(R.string.actor_3_string)),
    Actor(R.drawable.actor4, context.resources.getString(R.string.actor_4_string))
)

fun getListOfMovies(context: Context): ArrayList<Movie> {
    val actors = getActors(context)
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
            context.resources.getString(R.string.storyline_content_string),
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
    return listOfMovies
}