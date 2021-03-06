package com.appgue.premierleagueapp

import android.app.Fragment
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.appgue.premierleagueapp.DB.database
import com.appgue.premierleagueapp.Fragments.FavoriteFragment
//import com.appgue.premierleagueapp.DB.Favorite
//import com.appgue.premierleagueapp.DB.database
import com.appgue.premierleagueapp.Model.EventDetails
import com.appgue.premierleagueapp.Model.Team
import com.appgue.premierleagueapp.Utils.InitRetrofit
import retrofit2.Call
import retrofit2.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert


class DetailActivity : AppCompatActivity() {
    private lateinit var TeamHomeFavorite : String
    private lateinit var TeamAwayFavorite : String
    private lateinit var TeamHomeBadgeFavorite : String
    private lateinit var TeamAwayBadgeFavorite : String
    private lateinit var tvTanggalPertandinganFavorite : String
    private lateinit var HomeGoals : String
    private lateinit var AwayGoals : String
    private lateinit var HomeFormation : String
    private lateinit var AwayFormation : String
    private lateinit var HomeShots : String
    private lateinit var AwayShots : String
    private lateinit var HomeGoalkeeper : String
    private lateinit var AwayGoalkeeper : String
    private lateinit var HomeDefense : String
    private lateinit var AwayDefense : String
    private lateinit var HomeMidfield : String
    private lateinit var AwayMidfield : String
    private lateinit var HomeForward : String
    private lateinit var AwayForward : String
    private lateinit var ScoreHome : String
    private lateinit var ScoreAway : String
    private lateinit var idHomeTeam : String
    private lateinit var idAwayTeam : String
    private lateinit var id : String
    private lateinit var tipe : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tipe = intent.getStringExtra("tipe")

        if (tipe == "sql")
            {
            id = intent.getStringExtra("id")
            btnFavorite.setOnClickListener{
                deleteFavorite()
            }
        } else {
            btnFavorite.setOnClickListener{
                addToFavorite()
            }
        }

        val idEvent = intent.getStringExtra("idEvent").toInt()
        idHomeTeam = intent.getStringExtra("idHomeTeam")
        idAwayTeam = intent.getStringExtra("idAwayTeam")

        tvIdEvent.text = intent.getStringExtra("idEvent")
        tvId.text = intent.getStringExtra("idEvent")

        loadDetail(idEvent)
        loadLogoHome(idHomeTeam.toInt())
        loadLogoAway(idAwayTeam.toInt())
    }


    private fun loadDetail(idEvent: Int) {

        val api = InitRetrofit().getInitInstance()
        val call = api.requestDetail(idEvent)

        call.enqueue(object : Callback<EventDetails> {
            override fun onResponse(call: Call<EventDetails>?, response: retrofit2.Response<EventDetails>?) {
                if (response != null) {
                    if (response.isSuccessful) {
                        if(response.body()?.result?.get(0)?.strHomeGoalDetails != null){
                        tvHomeGoalDetails.text = response.body()?.result?.get(0)?.strHomeGoalDetails
                        HomeGoals = response.body()?.result?.get(0)?.strHomeGoalDetails.toString()}
                        else HomeGoals = " "

                        if(response.body()?.result?.get(0)?.strAwayGoalDetails != null){
                        tvAwayGoalDetails.text = response.body()?.result?.get(0)?.strAwayGoalDetails
                        AwayGoals = response.body()?.result?.get(0)?.strAwayGoalDetails.toString()}
                        else AwayGoals = " "

                        if(response.body()?.result?.get(0)?.strHomeFormation != null){
                            tvFormationHomeDetail.text = response.body()?.result?.get(0)?.strHomeFormation
                            HomeFormation = response.body()?.result?.get(0)?.strHomeFormation.toString()}
                        else {tvFormationHomeDetail.text = "no formation"
                            HomeFormation = "no formation"}

                        if(response.body()?.result?.get(0)?.strAwayFormation != null){
                            tvFormationAwayDetail.text = response.body()?.result?.get(0)?.strAwayFormation
                            AwayFormation = response.body()?.result?.get(0)?.strAwayFormation.toString()}
                        else {tvFormationAwayDetail.text = "no formation"
                            AwayFormation = "no formation"}

                        if(response.body()?.result?.get(0)?.intHomeShots != null){
                        tvHomeShots.text = response.body()?.result?.get(0)?.intHomeShots.toString()
                        HomeShots = response.body()?.result?.get(0)?.intHomeShots.toString()}
                        else HomeShots = " "

                        if(response.body()?.result?.get(0)?.intAwayShots != null){
                        tvAwayShots.text = response.body()?.result?.get(0)?.intAwayShots.toString()
                        AwayShots = response.body()?.result?.get(0)?.intAwayShots.toString()}
                        else AwayShots = " "

                        if(response.body()?.result?.get(0)?.strHomeLineupGoalkeeper !=null){
                        tvHomeGoalkeeper.text = response.body()?.result?.get(0)?.strHomeLineupGoalkeeper
                        HomeGoalkeeper = response.body()?.result?.get(0)?.strHomeLineupGoalkeeper.toString()}
                        else HomeGoalkeeper = " "

                        if(response.body()?.result?.get(0)?.strAwayLineupGoalkeeper != null){
                        tvAwayGoalkeeper.text = response.body()?.result?.get(0)?.strAwayLineupGoalkeeper
                        AwayGoalkeeper = response.body()?.result?.get(0)?.strAwayLineupGoalkeeper.toString()}
                        else AwayGoalkeeper = " "

                        if(response.body()?.result?.get(0)?.strHomeLineupDefense != null){
                        tvHomeDefense.text = response.body()?.result?.get(0)?.strHomeLineupDefense
                        HomeDefense = response.body()?.result?.get(0)?.strHomeLineupDefense.toString()}
                        else HomeDefense = " "

                        if(response.body()?.result?.get(0)?.strAwayLineupDefense != null){
                        tvAwayDefense.text = response.body()?.result?.get(0)?.strAwayLineupDefense
                        AwayDefense = response.body()?.result?.get(0)?.strAwayLineupDefense.toString()}
                        else AwayDefense = " "

                        if(response.body()?.result?.get(0)?.strHomeLineupMidfield != null){
                        tvHomeMidfield.text = response.body()?.result?.get(0)?.strHomeLineupMidfield
                        HomeMidfield = response.body()?.result?.get(0)?.strHomeLineupMidfield.toString()}
                        else HomeMidfield = " "

                        if(response.body()?.result?.get(0)?.strAwayLineupMidfield != null){
                        tvAwayMidfield.text = response.body()?.result?.get(0)?.strAwayLineupMidfield
                        AwayMidfield = response.body()?.result?.get(0)?.strAwayLineupMidfield.toString()}
                        else AwayMidfield = " "

                        if(response.body()?.result?.get(0)?.strHomeLineupForward != null){
                        tvHomeForward.text = response.body()?.result?.get(0)?.strHomeLineupForward
                        HomeForward = response.body()?.result?.get(0)?.strHomeLineupForward.toString()}
                        else HomeForward = " "

                        if(response.body()?.result?.get(0)?.strAwayLineupForward != null){
                        tvAwayForward.text = response.body()?.result?.get(0)?.strAwayLineupForward
                        AwayForward = response.body()?.result?.get(0)?.strAwayLineupForward.toString()}
                        else AwayForward = " "

                        tvTanggalPertandinganDetail.text = response.body()?.result?.get(0)?.strDate
                        tvTanggalPertandinganFavorite = response.body()?.result?.get(0)?.strDate.toString()

                        tvTeamHomeDetail.text = response.body()?.result?.get(0)?.strHomeTeam
                        TeamHomeFavorite = response.body()?.result?.get(0)?.strHomeTeam.toString()

                        tvTeamAwayDetail.text = response.body()?.result?.get(0)?.strAwayTeam
                        TeamAwayFavorite = response.body()?.result?.get(0)?.strAwayTeam.toString()

                        if(response.body()?.result?.get(0)?.intHomeScore != null){
                        tvScoreHomeDetail.text = response.body()?.result?.get(0)?.intHomeScore.toString()
                        ScoreHome = response.body()?.result?.get(0)?.intHomeScore.toString()}
                        else ScoreHome = " "

                        if(response.body()?.result?.get(0)?.intAwayScore != null){
                        tvScoreAwayDetail.text = response.body()?.result?.get(0)?.intAwayScore.toString()
                        ScoreAway = response.body()?.result?.get(0)?.intAwayScore.toString()}
                        else ScoreAway = " "
                    }
                }
            }

            override fun onFailure(call: Call<EventDetails>?, t: Throwable?) {

            }
        })
    }


    private fun loadLogoHome(idHomeTeam: Int) {

        val api = InitRetrofit().getInitInstance()
        val call = api.requestTeam(idHomeTeam)

        call.enqueue(object : Callback<Team> {
            override fun onResponse(call: Call<Team>?, response: retrofit2.Response<Team>?) {
                if (response != null) {
                    val URIimgHome = response.body()?.teamresult?.get(0)?.strTeamBadge
                    TeamHomeBadgeFavorite = response.body()?.teamresult?.get(0)?.strTeamBadge.toString()
                    if (response.isSuccessful) {
                        Picasso.with(this@DetailActivity)
                                .load(URIimgHome)
                                .placeholder(R.drawable.placeholder)
                                .into(imgHomeDetail)
                    }
                }
            }

            override fun onFailure(call: Call<Team>?, t: Throwable?) {

            }
        })
    }

    private fun loadLogoAway(idAwayTeam: Int) {

        val api = InitRetrofit().getInitInstance()
        val call = api.requestTeam(idAwayTeam)

        call.enqueue(object : Callback<Team> {
            override fun onResponse(call: Call<Team>?, response: retrofit2.Response<Team>?) {
                if (response != null) {
                    val URIimgAway = response.body()?.teamresult?.get(0)?.strTeamBadge
                    TeamAwayBadgeFavorite = response.body()?.teamresult?.get(0)?.strTeamBadge.toString()
                    if (response.isSuccessful) {
                        Picasso.with(this@DetailActivity)
                                .load(URIimgAway)
                                .placeholder(R.drawable.placeholder)
                                .into(imgAwayDetail)
                    }
                }
            }

            override fun onFailure(call: Call<Team>?, t: Throwable?) {

            }
        })
    }

    private fun addToFavorite(){
        try {
            database.use {
                insert("favorite",
                        "idEvent" to tvIdEvent.text,
                        "teamHome" to TeamHomeFavorite,
                        "teamAway" to TeamAwayFavorite,
                        "tanggalFav" to tvTanggalPertandinganFavorite,
                        "ScoreHome" to ScoreHome,
                        "ScoreAway" to ScoreAway,
                        "idHomeTeam" to idHomeTeam,
                        "idAwayTeam" to idAwayTeam
                )
            }
            Toast.makeText(this, "Added to favorite", Toast.LENGTH_SHORT).show()
        } catch (e: SQLiteConstraintException){
            Toast.makeText(this, e.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteFavorite(){
        try {
            database.use {
                delete("favorite",
                        "id="+id
                )
            }
            Toast.makeText(this, "Data deleted", Toast.LENGTH_SHORT).show()
        } catch (e: SQLiteConstraintException){
            Toast.makeText(this, e.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }

}
