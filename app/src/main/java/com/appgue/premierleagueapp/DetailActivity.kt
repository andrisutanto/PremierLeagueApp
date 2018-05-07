package com.appgue.premierleagueapp

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.appgue.premierleagueapp.DB.database
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //on click listener button favorite
        btnFavorite.setOnClickListener{
            addToFavorite()
        }

        //ambil id event utk lookup event
        val idEvent = intent.getStringExtra("idEvent").toInt()

        //mengambil intent
        val idHomeTeam = intent.getStringExtra("idHomeTeam").toInt()
        val idAwayTeam = intent.getStringExtra("idAwayTeam").toInt()
        tvIdEvent.text = intent.getStringExtra("idEvent")

        loadDetail(idEvent)
        loadLogoHome(idHomeTeam)
        loadLogoAway(idAwayTeam)
    }


    private fun loadDetail(idEvent: Int) {

        val api = InitRetrofit().getInitInstance()
        val call = api.requestDetail(idEvent)

        call.enqueue(object : Callback<EventDetails> {
            override fun onResponse(call: Call<EventDetails>?, response: retrofit2.Response<EventDetails>?) {
                if (response != null) {
                    if (response.isSuccessful) {
                        tvHomeGoalDetails.setText(response.body()?.result?.get(0)?.strHomeGoalDetails)
                        tvAwayGoalDetails.setText(response.body()?.result?.get(0)?.strAwayGoalDetails)

                        if(response.body()?.result?.get(0)?.strHomeFormation != "")
                            tvFormationHomeDetail.setText(response.body()?.result?.get(0)?.strHomeFormation)
                        else tvFormationHomeDetail.setText("no formation")

                        if(response.body()?.result?.get(0)?.strAwayFormation != "")
                            tvFormationAwayDetail.setText(response.body()?.result?.get(0)?.strAwayFormation)
                        else tvFormationAwayDetail.setText("no formation")

                        tvHomeShots.setText(response.body()?.result?.get(0)?.intHomeShots.toString())
                        tvAwayShots.setText(response.body()?.result?.get(0)?.intAwayShots.toString())

                        tvHomeGoalkeeper.setText(response.body()?.result?.get(0)?.strHomeLineupGoalkeeper)
                        tvAwayGoalkeeper.setText(response.body()?.result?.get(0)?.strAwayLineupGoalkeeper)

                        tvHomeDefense.setText(response.body()?.result?.get(0)?.strHomeLineupDefense)
                        tvAwayDefense.setText(response.body()?.result?.get(0)?.strAwayLineupDefense)

                        tvHomeMidfield.setText(response.body()?.result?.get(0)?.strHomeLineupMidfield)
                        tvAwayMidfield.setText(response.body()?.result?.get(0)?.strAwayLineupMidfield)

                        tvHomeForward.setText(response.body()?.result?.get(0)?.strHomeLineupForward)
                        tvAwayForward.setText(response.body()?.result?.get(0)?.strAwayLineupForward)

                        tvTanggalPertandinganDetail.setText(response.body()?.result?.get(0)?.strDate)
                        tvTeamHomeDetail.setText(response.body()?.result?.get(0)?.strHomeTeam)
                        tvTeamAwayDetail.setText(response.body()?.result?.get(0)?.strAwayTeam)
                        tvScoreHomeDetail.setText(response.body()?.result?.get(0)?.intHomeScore.toString())
                        tvScoreAwayDetail.setText(response.body()?.result?.get(0)?.intAwayScore.toString())
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
                        "id" to "123456",
                        "name" to "Arsenal")

                insert("favorite",
                        "id" to "123455",
                        "name" to "Chelsea")

                insert("favorite",
                        "id" to "123454",
                        "name" to "Manchester United")
            }
            Toast.makeText(this, "Added to favorite", Toast.LENGTH_SHORT).show()
        } catch (e: SQLiteConstraintException){
            Toast.makeText(this, e.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }

}
