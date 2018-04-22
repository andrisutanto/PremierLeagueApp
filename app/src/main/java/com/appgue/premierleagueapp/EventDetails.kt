package com.appgue.premierleagueapp

import com.google.gson.annotations.SerializedName

/**
 * Created by Andri on 4/22/2018.
 */
class EventDetails {
    @SerializedName("events")
    var data: List<EventDetails>? = null

    inner class EventDetails {
        @SerializedName("strHomeFormation")
        var strHomeFormation : String? = null

        @SerializedName("strAwayFormation")
        var strAwayFormation : String? = null

        @SerializedName("strHomeGoalDetails")
        var strHomeGoalDetails : String? = null

        @SerializedName("strAwayGoalDetails")
        var strAwayAwayGoalDetails : String? = null
    }
}
