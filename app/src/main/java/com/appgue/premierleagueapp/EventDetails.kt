package com.appgue.premierleagueapp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Andri on 4/22/2018.
 */
class EventDetails {

        @SerializedName("events")
        var result: List<EventDetails.data>? = null

        class data{
            @SerializedName("strHomeFormation")
            var strHomeFormation : String? = null

            @SerializedName("strAwayFormation")
            var strAwayFormation : String? = null

            @SerializedName("strHomeGoalDetails")
            var strHomeGoalDetails : String? = null

            @SerializedName("strAwayGoalDetails")
            var strAwayGoalDetails : String? = null
        }
}