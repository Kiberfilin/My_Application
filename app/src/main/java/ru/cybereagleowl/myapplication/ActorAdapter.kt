package ru.cybereagleowl.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.cybereagleowl.myapplication.databinding.ViewHolderActorBinding
import ru.cybereagleowl.myapplication.databinding.ViewHolderMovieBinding

class ActorAdapter(context: Context, private var actors: List<Actor>) :
    RecyclerView.Adapter<ActorViewHolder>() {
    private val inflater = LayoutInflater.from(context)
    private lateinit var binding: ViewHolderActorBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        binding = ViewHolderActorBinding.inflate(inflater, parent, false)
        return ActorViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bind(actors[position])
    }

    override fun getItemCount(): Int = actors.size
}

class ActorViewHolder(private val binding: ViewHolderActorBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(actor: Actor) {
        binding.apply {
            actor.apply {
                actorImageView.setImageResource(picture)
                actorTextView.text = name
            }
        }
    }
}
