package tn.esprit.eventew

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class DetailsActivity : AppCompatActivity() {

    lateinit var titleEvent: TextView
    lateinit var descriptionEvent: TextView
    lateinit var dateEvent: TextView
    lateinit var lieuEvent: TextView

    lateinit var imageEvent: ImageView
    lateinit var qrcode: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val inflater = LayoutInflater.from(this)
        val popupLayout: View = inflater.inflate(R.layout.popup_layout, null, false)
        val name = intent.getStringExtra("title")
        val date = intent.getStringExtra("date")
        val description = intent.getStringExtra("description")
        val image = intent.getStringExtra("image")
        val lieu = intent.getStringExtra("location")
        val organisationH = intent.getStringExtra("organisation")

        titleEvent = findViewById(R.id.title)
        descriptionEvent = findViewById(R.id.descriptionEvent)
        dateEvent = findViewById(R.id.DateEvent)
        lieuEvent = findViewById(R.id.Adresse)
       // organisation = findViewById(R.id.location) // Initialize the TextView

        imageEvent = findViewById(R.id.ImageEvent)

        titleEvent.text = name
        descriptionEvent.text = description
        dateEvent.text = date
        lieuEvent.text = lieu


         Picasso.get().load("http://10.0.2.2:5001/api/events/get-all-events/" + image).placeholder(R.drawable.jabami).into(imageEvent);

        // event button Qrcode

        // Gérez les clics sur les éléments du menu
    }

    fun backHome(view: View) {
        val intent = Intent(this, menuClient::class.java)
        startActivity(intent)
    }
}
