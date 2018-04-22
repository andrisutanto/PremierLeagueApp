package com.appgue.premierleagueapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //mengambil intent
        tvIdEvent.text = intent.getStringExtra("idEvent")
        tvTanggalPertandinganDetail.text = intent.getStringExtra("strDate")
        tvTeamHomeDetail.text = intent.getStringExtra("strHomeTeam")
        tvTeamAwayDetail.text = intent.getStringExtra("strAwayTeam")
        tvScoreHomeDetail.text = intent.getStringExtra("intHomeScore")
        tvScoreAwayDetail.text = intent.getStringExtra("intAwayScore")
    }
}
