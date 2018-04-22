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

    @GET("lookupevent.php?id=526848")
    fun request_detail(): Call<EventDetails>
            //@Query("id") idEvent: Int


}