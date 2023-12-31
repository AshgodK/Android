package tn.esprit.eventew.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tn.esprit.eventew.Api.EventsApi
import tn.esprit.eventew.Data.Event
import tn.esprit.eventew.R
import tn.esprit.eventew.eventList.EventsAdapter
import tn.esprit.eventew.utils.RetrofitClient

class HomeFragment : Fragment(){

    lateinit var recyclerEvents: RecyclerView
    lateinit var recyclerEventsAdapter: EventsAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        doList()
        return view
    }
    private fun doList() {

        val paramObject1 = JSONObject()

        val jsonParser = JsonParser()
        var gsonObject1 = jsonParser.parse(paramObject1.toString()) as JsonObject
        val retro = RetrofitClient().getRetroClinetInstance().create(EventsApi::class.java)

        // get all events  = listEvents()
        retro.listEvents().enqueue(object : Callback<List<Event>> {
            override fun onResponse(call: Call<List<Event>>, response: Response<List<Event>>) {
                if (response.isSuccessful) {
                    Toast.makeText(context, "List in ", Toast.LENGTH_SHORT).show()
                    recyclerEvents = view?.findViewById(R.id.recyclerNews) !!

                    // Get the list of events directly
                    val listEvents = response.body()

                    val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(context)
                    linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
                    recyclerEventsAdapter = EventsAdapter(listEvents)

                    recyclerEvents.adapter = recyclerEventsAdapter
                    recyclerEvents.layoutManager = linearLayoutManager
                } else {
                    // Handle unsuccessful response
                    Toast.makeText(context, "List out ", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Event>>, t: Throwable) {
                // Handle failure
                Toast.makeText(context, "List out ", Toast.LENGTH_SHORT).show()
            }
        })




    }
}