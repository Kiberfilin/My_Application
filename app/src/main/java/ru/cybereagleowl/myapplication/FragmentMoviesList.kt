package ru.cybereagleowl.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentMoviesList: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_movies_list, container, false)
        return rootView
    }
    companion object {
        fun getInstance(): FragmentMoviesList {
            return FragmentMoviesList()
        }
    }
}