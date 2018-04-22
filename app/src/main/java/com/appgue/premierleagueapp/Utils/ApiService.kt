package com.appgue.premierleagueapp.Utils

import com.appgue.premierleagueapp.Event
import com.appgue.premierleagueapp.EventDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Andri on 4/21/2018.
 */
interface ApiService {

    @GET("eventspastleague.php?id=4328")
    fun request_prevMatch(): Call<Event>

    @GET("eventsnextleague.php?id=4328")
    fun request_nextMatch(): Call<Event>

    @GET("lookupevent.php?")
    fun request_detail(
            @Query("id") idEvent: Int
    ): Call<EventDetails>

}