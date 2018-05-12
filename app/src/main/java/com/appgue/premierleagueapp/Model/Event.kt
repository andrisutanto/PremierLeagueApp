package com.appgue.premierleagueapp.Model

import com.google.gson.annotations.SerializedName

/**
 * Created by Andri on 4/21/2018.
 */
class Event {

    @SerializedName("events")
    var data: List<EventsData>? = null

    inner class EventsData {
        @SerializedName("idEvent")
        var idEvent : Int = 0

        @SerializedName("strHomeTeam")
        var strHomeTeam : String? = null

        @SerializedName("strAwayTeam")
        var strAwayTeam : String? = null

        @SerializedName("intHomeScore")
        var intHomeScore : String? = null

        @SerializedName("intAwayScore")
        var intAwayScore : String? = null

        @SerializedName("idHomeTeam")
        var idHomeTeam : String? = null

        @SerializedName("idAwayTeam")
        var idAwayTeam : String? = null

        @SerializedName("strDate")
        var strDate : String? = null
    }

}