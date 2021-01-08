package ru.cybereagleowl.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentMoviesDetails: Fragment() {
    lateinit var backIcon: ImageView
    lateinit var backText: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_movies_details, container, false)
        backIcon = rootView.findViewById(R.id.back_icon)
        backText = rootView.findViewById(R.id.back_text)
        val onBackClick = View.OnClickListener { activity?.onBackPressed() }
        backIcon.setOnClickListener(onBackClick)
        backText.setOnClickListener(onBackClick)
        return rootView
    }

    companion object {
        fun getInstance(): FragmentMoviesDetails {
            return FragmentMoviesDetails()
        }
    }
}