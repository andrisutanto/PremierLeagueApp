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
        val teamHomeBadge: String,
        val HomeGoals: String,
        val AwayGoals: String,
        val HomeFormation: String,
        val AwayFormation: String,
        val HomeShots: String,
        val AwayShots: String,
        val HomeGoalkeeper: String,
        val AwayGoalkeeper: String,
        val HomeDefense: String,
        val AwayDefense: String,
        val HomeMidfield: String,
        val AwayMidfield: String,
        val HomeForward: String,
        val AwayForward: String,
        val ScoreHome: String,
        val ScoreAway: String
)