package com.appgue.premierleagueapp.DB

import android.content.Context
import android.content.Intent
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.appgue.premierleagueapp.R
import com.appgue.premierleagueapp.DetailActivity
import com.appgue.premierleagueapp.DetailFavActivity
import com.appgue.premierleagueapp.Model.Event
import kotlinx.android.synthetic.main.item_favorite.view.*


/**
 * Created by Andri on 5/7/2018.
 */
class DBAdapter (c: FragmentActivity?, val favorite: List<Favorite>) : RecyclerView.Adapter<DBAdapter.ViewHolder>(){
    private var Context: Context? = c

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        Log.i("SIZE",favorite.size.toString())
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(favorite[position])
        //set onclick listener dan kirim id database
        holder.LLFavorite.setOnClickListener({ v ->
            val intent = Intent(Context?.applicationContext, DetailFavActivity::class.java)
            intent.putExtra("idEvent", "1")
            Context?.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return favorite.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var LLFavorite = itemView?.findViewById<View>(R.id.LLFavorite) as LinearLayout
        fun bindItems(favorite: Favorite) {
            itemView.tvTeamHomeFavorit.text = favorite.teamHome
            itemView.tvTeamAwayFavorit.text = favorite.teamAway
            itemView.tvTanggalPertandinganFavorit.text = favorite.id.toString()
        }
    }
}