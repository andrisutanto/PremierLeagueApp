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

        loadDetail()
    }


    private fun loadDetail() {

        var api = InitRetrofit().getInitInstance()
        var call = api.request_detail()

        call.enqueue(object : Callback<EventDetails> {
            override fun onResponse(call: Call<EventDetails>?, response: retrofit2.Response<EventDetails>?) {
                if (response != null) {
                    if (response.isSuccessful) {
                        tvAwayGoalDetails.setText(response.body()?.result?.get(0)?.strAwayGoalDetails)

                    }
                }
            }

            override fun onFailure(call: Call<EventDetails>?, t: Throwable?) {

            }
        })
    }
}
