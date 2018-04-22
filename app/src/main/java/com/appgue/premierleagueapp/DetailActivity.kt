package com.appgue.premierleagueapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.appgue.premierleagueapp.Utils.InitRetrofit
import retrofit2.Call
import retrofit2.Callback
import com.appgue.premierleagueapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //ambil id event utk lookup event
        val idEvent = intent.getStringExtra("idEvent").toInt()

        //mengambil intent
        val idHomeTeam = intent.getStringExtra("idHomeTeam").toInt()
        val idAwayTeam = intent.getStringExtra("idAwayTeam").toInt()

        tvIdEvent.text = intent.getStringExtra("idEvent")
        tvTanggalPertandinganDetail.text = intent.getStringExtra("strDate")
        tvTeamHomeDetail.text = intent.getStringExtra("strHomeTeam")
        tvTeamAwayDetail.text = intent.getStringExtra("strAwayTeam")
        tvScoreHomeDetail.text = intent.getStringExtra("intHomeScore")
        tvScoreAwayDetail.text = intent.getStringExtra("intAwayScore")

        loadDetail(idEvent)
        loadLogoHome(idHomeTeam)
        loadLogoAway(idAwayTeam)
    }


    private fun loadDetail(idEvent: Int) {

        var api = InitRetrofit().getInitInstance()
        var call = api.request_detail(idEvent)

        call.enqueue(object : Callback<EventDetails> {
            override fun onResponse(call: Call<EventDetails>?, response: retrofit2.Response<EventDetails>?) {
                if (response != null) {
                    if (response.isSuccessful) {
                        tvHomeGoalDetails.setText(response.body()?.result?.get(0)?.strHomeGoalDetails)
                        tvAwayGoalDetails.setText(response.body()?.result?.get(0)?.strAwayGoalDetails)

                        if(response.body()?.result?.get(0)?.strHomeFormation != "" || response.body()?.result?.get(0)?.strHomeFormation != null)
                            tvFormationHomeDetail.setText(response.body()?.result?.get(0)?.strHomeFormation)
                        else tvFormationHomeDetail.setText("no formation")

                        if(response.body()?.result?.get(0)?.strAwayFormation != "" || response.body()?.result?.get(0)?.strAwayFormation != null)
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
                    }
                }
            }

            override fun onFailure(call: Call<EventDetails>?, t: Throwable?) {

            }
        })
    }


    private fun loadLogoHome(idHomeTeam: Int) {

        var api = InitRetrofit().getInitInstance()
        var call = api.request_team(idHomeTeam)

        call.enqueue(object : Callback<Team> {
            override fun onResponse(call: Call<Team>?, response: retrofit2.Response<Team>?) {
                if (response != null) {
                    val URIimgHome = response.body()?.teamresult?.get(0)?.strTeamBadge
                    if (response.isSuccessful) {
                        Picasso.with(this@DetailActivity)
                                .load(URIimgHome)
                                .into(imgHomeDetail)
                    }
                }
            }

            override fun onFailure(call: Call<Team>?, t: Throwable?) {

            }
        })
    }

    private fun loadLogoAway(idAwayTeam: Int) {

        var api = InitRetrofit().getInitInstance()
        var call = api.request_team(idAwayTeam)

        call.enqueue(object : Callback<Team> {
            override fun onResponse(call: Call<Team>?, response: retrofit2.Response<Team>?) {
                if (response != null) {
                    val URIimgAway = response.body()?.teamresult?.get(0)?.strTeamBadge
                    if (response.isSuccessful) {
                        Picasso.with(this@DetailActivity)
                                .load(URIimgAway)
                                .into(imgAwayDetail)
                    }
                }
            }

            override fun onFailure(call: Call<Team>?, t: Throwable?) {

            }
        })
    }
}
