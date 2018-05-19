package com.appgue.premierleagueapp.DB

/**
 * Created by Andri on 4/29/2018.
 */

data class Favorite(
        val id: Int,
        val idEvent: String,
        val teamHome: String,
        val teamAway: String,
        val tanggalFav: String,
        val ScoreHome: String,
        val ScoreAway: String,
        val idHomeTeam: String,
        val idAwayTeam: String
)