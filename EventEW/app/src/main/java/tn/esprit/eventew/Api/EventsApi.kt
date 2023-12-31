package tn.esprit.eventew.Api

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*
import tn.esprit.eventew.Data.Event


interface EventsApi {
    @Headers("Content-Type: application/json")
    @GET("api/events/get-all-events")
    fun listEvents(): Call<List<Event>>


    @Multipart
    @POST("/events/store")

    fun addEvents( @Body body: JsonObject ): Call<JsonObject>
}