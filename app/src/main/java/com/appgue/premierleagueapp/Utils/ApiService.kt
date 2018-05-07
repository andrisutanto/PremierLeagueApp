package com.appgue.premierleagueapp.Utils

import com.appgue.premierleagueapp.Model.Event
import com.appgue.premierleagueapp.Model.EventDetails
import com.appgue.premierleagueapp.Model.Team
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Andri on 4/21/2018.
 */
interface ApiService {

    @GET("eventspastleague.php?id=4328")
    fun requestPrevMatch(): Call<Event>

    @GET("eventsnextleague.php?id=4328")
    fun requestNextMatch(): Call<Event>

    @GET("lookupevent.php?")
    fun requestDetail(
            @Query("id") idEvent: Int
    ): Call<EventDetails>

    @GET("lookupteam.php?")
    fun requestTeam(
            @Query("id") idTeam: Int
    ): Call<Team>

}