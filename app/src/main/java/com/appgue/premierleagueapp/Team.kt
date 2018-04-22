package com.appgue.premierleagueapp

import com.google.gson.annotations.SerializedName

/**
 * Created by Andri on 4/22/2018.
 */

class Team {
    @SerializedName("teams")
    var teamresult: List<Team.data>? = null

    class data{
        @SerializedName("strTeamBadge")
        var strTeamBadge : String? = null
    }
}