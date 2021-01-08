package ru.cybereagleowl.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.main_fragment_container, FragmentMoviesList.getInstance(),"FRAGMENT_MOVIES_LIST")
            }.commit()
        }
    }
    fun onMovieCardClick(view: View) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_fragment_container, FragmentMoviesDetails.getInstance(),"FRAGMENT_MOVIES_DETAILS")
            addToBackStack(null)
        }.commit()
    }
}