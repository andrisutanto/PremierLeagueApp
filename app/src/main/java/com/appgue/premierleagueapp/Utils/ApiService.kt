package com.appgue.premierleagueapp.Utils

import com.appgue.premierleagueapp.Event
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Andri on 4/21/2018.
 */
interface ApiService {

    @GET("eventspastleague.php?id=4328")
    fun request_prevMatch(): Call<Event>

    @GET("eventsnextleague.php?id=4328")
    fun request_nextMatch(): Call<Event>

    @GET("lookupevent.php?id=441613")
    fun request_event(): Call<Event>
}