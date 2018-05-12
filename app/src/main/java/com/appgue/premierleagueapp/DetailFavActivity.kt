package com.appgue.premierleagueapp

import android.database.sqlite.SQLiteConstraintException
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.appgue.premierleagueapp.DB.Favorite
import com.appgue.premierleagueapp.DB.database
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail_fav.*
import kotlinx.android.synthetic.main.item_favorite.*
import org.jetbrains.anko.*
import org.jetbrains.anko.db.*


class DetailFavActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_fav)

        var id = intent.getStringExtra("id")

        //ambil id event utk lookup event
        val result = database.use {
            select("favorite")
                    .whereArgs("(id = {id})",
                            "id" to id).exec {
                        parseList(classParser<Favorite>())
                    }
            }

        //untuk testing isi hasil query
        //tvIdSqliteFavorite.text = result[0].toString()

        //tampilkan hasil query DB ke komponen view
        tvIdSqliteFavorite.text = result[0].id.toString()
        tvTanggalPertandinganDetailFavorite.text = result[0].tanggalFav
        tvTeamHomeDetailFavorite.text = result[0].teamHome
        tvTeamAwayDetailFavorite.text = result[0].teamAway
        val URIimgHome = result[0].teamHomeBadge
        val URIimgAway = result[0].teamAwayBadge

        Picasso.with(this@DetailFavActivity)
                .load(URIimgHome)
                .placeholder(R.drawable.placeholder)
                .into(imgHomeDetailFavorite)

        Picasso.with(this@DetailFavActivity)
                .load(URIimgAway)
                .placeholder(R.drawable.placeholder)
                .into(imgAwayDetailFavorite)
        tvHomeGoalDetailsFavorite.text = result[0].HomeGoals
        tvAwayGoalDetailsFavorite.text = result[0].AwayGoals
        tvFormationHomeDetailFavorite.text = result[0].HomeFormation
        tvFormationAwayDetailFavorite.text = result[0].AwayFormation
        tvHomeShotsFavorite.text = result[0].HomeShots
        tvAwayShotsFavorite.text = result[0].AwayShots

        tvHomeGoalkeeperFavorite.text = result[0].HomeGoalkeeper
        tvAwayGoalkeeperFavorite.text = result[0].AwayGoalkeeper

        tvHomeDefenseFavorite.text = result[0].HomeDefense
        tvAwayDefenseFavorite.text = result[0].AwayDefense
        tvHomeMidfieldFavorite.text = result[0].HomeMidfield
        tvAwayMidfieldFavorite.text = result[0].AwayMidfield
        tvHomeForwardFavorite.text = result[0].HomeForward
        tvAwayForwardFavorite.text = result[0].AwayForward
        tvScoreHomeDetailFavorite.text = result[0].ScoreHome
        tvScoreAwayDetailFavorite.text = result[0].ScoreAway

        //on click listener button favorite
        btnFavoriteFavorite.setOnClickListener{
            DeleteFavorite()
        }
    }

    private fun DeleteFavorite(){
        try {
            database.use {
                delete("favorite",
                        "id="+tvIdSqliteFavorite.text.toString()
                )
            }
            Toast.makeText(this, "Data deleted", Toast.LENGTH_SHORT).show()
        } catch (e: SQLiteConstraintException){
            Toast.makeText(this, e.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }
}
