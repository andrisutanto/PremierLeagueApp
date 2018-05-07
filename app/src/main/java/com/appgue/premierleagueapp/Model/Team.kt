package com.appgue.premierleagueapp.Model

import com.google.gson.annotations.SerializedName

/**
 * Created by Andri on 4/22/2018.
 */

class Team {
    @SerializedName("teams")
    var teamresult: List<data>? = null

    class data{
        @SerializedName("strTeamBadge")
        var strTeamBadge : String? = null
    }
}