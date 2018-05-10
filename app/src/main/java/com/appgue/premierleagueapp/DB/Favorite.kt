package com.appgue.premierleagueapp.DB

/**
 * Created by Andri on 4/29/2018.
 */

data class Favorite(
        val id: Int,
        val teamHome: String,
        val teamAway: String,
        val tanggalFav: String,
        val teamAwayBadge: String,
        val teamHomeBadge: String)