package com.appgue.premierleagueapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.appgue.premierleagueapp.Utils.InitRetrofit
import retrofit2.Call
import retrofit2.Callback
import com.appgue.premierleagueapp.R
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //ambil id event utk lookup event
        val idEvent = intent.getStringExtra("idEvent").toInt()

        //mengambil intent
        tvIdEvent.text = intent.getStringExtra("idEvent")
        tvTanggalPertandinganDetail.text = intent.getStringExtra("strDate")
        tvTeamHomeDetail.text = intent.getStringExtra("strHomeTeam")
        tvTeamAwayDetail.text = intent.getStringExtra("strAwayTeam")
        tvScoreHomeDetail.text = intent.getStringExtra("intHomeScore")
        tvScoreAwayDetail.text = intent.getStringExtra("intAwayScore")

        loadDetail(idEvent)
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
}
