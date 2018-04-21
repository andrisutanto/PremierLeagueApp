package com.appgue.premierleagueapp

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
        var intHomeScore : Int = 0

        @SerializedName("intAwayScore")
        var intAwayScore : Int = 0

        @SerializedName("strDate")
        var strDate : String? = null
    }

}