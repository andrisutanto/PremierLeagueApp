package com.appgue.premierleagueapp.Model

import com.google.gson.annotations.SerializedName

/**
 * Created by Andri on 4/22/2018.
 */
class EventDetails {

        @SerializedName("events")
        var result: List<data>? = null

        class data{
            @SerializedName("strHomeFormation")
            var strHomeFormation : String? = null

            @SerializedName("strAwayFormation")
            var strAwayFormation : String? = null

            @SerializedName("strHomeGoalDetails")
            var strHomeGoalDetails : String? = null

            @SerializedName("strAwayGoalDetails")
            var strAwayGoalDetails : String? = null

            @SerializedName("intHomeShots")
            var intHomeShots : Int = 0

            @SerializedName("intAwayShots")
            var intAwayShots : Int = 0

            @SerializedName("strHomeLineupGoalkeeper")
            var strHomeLineupGoalkeeper : String? = null

            @SerializedName("strAwayLineupGoalkeeper")
            var strAwayLineupGoalkeeper : String? = null

            @SerializedName("strHomeLineupDefense")
            var strHomeLineupDefense : String? = null

            @SerializedName("strAwayLineupDefense")
            var strAwayLineupDefense : String? = null

            @SerializedName("strHomeLineupMidfield")
            var strHomeLineupMidfield : String? = null

            @SerializedName("strAwayLineupMidfield")
            var strAwayLineupMidfield : String? = null

            @SerializedName("strHomeLineupForward")
            var strHomeLineupForward : String? = null

            @SerializedName("strAwayLineupForward")
            var strAwayLineupForward : String? = null

            @SerializedName("strDate")
            var strDate : String? = null

            @SerializedName("strHomeTeam")
            var strHomeTeam : String? = null

            @SerializedName("strAwayTeam")
            var strAwayTeam : String? = null

            @SerializedName("intHomeScore")
            var intHomeScore : Int = 0

            @SerializedName("intAwayScore")
            var intAwayScore : Int = 0
        }
}