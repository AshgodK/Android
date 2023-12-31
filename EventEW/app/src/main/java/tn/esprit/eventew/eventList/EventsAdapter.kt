package tn.esprit.eventew.eventList

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import tn.esprit.eventew.Data.Event
import tn.esprit.eventew.DetailsActivity
import tn.esprit.eventew.R

class EventsAdapter(private val eventsList: List<Event>?): RecyclerView.Adapter<EventsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_single_item, parent, false)

        return EventsViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        val event = eventsList?.get(position)

        event?.let {
            val image = it.image
            val title = it.title
            val organizer = it.organizer
            val date = it.date
            val location = it.location
            val description = it.description

            holder.TitleEvent.text = title
            holder.LieuEvent.text = location
            holder.DateEvent.text = date
            Picasso.get().load("http:///10.0.2.2:5001/api/events/get-all-events/$image").into(holder.ImageEvent)

            holder.itemView.setOnClickListener {
                val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
                intent.apply {
                    putExtra("title", title)
                    putExtra("date", date)
                    putExtra("organizer", organizer)
                    putExtra("location", location)
                    putExtra("image", image)
                    putExtra("description", description)
                }
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return eventsList?.size ?: 0
    }
}
