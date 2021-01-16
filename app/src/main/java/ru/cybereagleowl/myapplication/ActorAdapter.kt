package ru.cybereagleowl.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActorAdapter(context: Context, private var actors: List<Actor>) :
    RecyclerView.Adapter<ActorViewHolder>() {
    private val inflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder =
        ActorViewHolder(inflater.inflate(R.layout.view_holder_actor, parent, false))

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bind(actors[position])
    }

    override fun getItemCount(): Int = actors.size
}

class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val actorImageView = itemView.findViewById<ImageView>(R.id.actor_image_view)
    private val actorTextView = itemView.findViewById<TextView>(R.id.actor_text_view)
    fun bind(actor: Actor) {
        actor.apply {
            actorImageView.setImageResource(picture)
            actorTextView.text = name
        }
    }
}
