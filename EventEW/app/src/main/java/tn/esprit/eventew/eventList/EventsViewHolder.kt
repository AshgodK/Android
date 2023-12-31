package tn.esprit.eventew.eventList

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.eventew.R

class EventsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val TitleEvent: TextView = itemView.findViewById<TextView>(R.id.title)
    val DateEvent : TextView = itemView.findViewById<TextView>(R.id.DateEvent)
    val LieuEvent : TextView = itemView.findViewById<TextView>(R.id.Adresse)
    val ImageEvent : ImageView = itemView.findViewById<ImageView>(R.id.ImageEvent)
}