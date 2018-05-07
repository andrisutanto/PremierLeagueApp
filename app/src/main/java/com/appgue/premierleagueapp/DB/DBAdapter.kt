package com.appgue.premierleagueapp.DB

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appgue.premierleagueapp.R
import kotlinx.android.synthetic.main.item_favorite.view.*

/**
 * Created by Andri on 5/7/2018.
 */
class DBAdapter (val favorite: List<Favorite>) : RecyclerView.Adapter<DBAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        Log.i("SIZE",favorite.size.toString())
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(favorite[position])
    }

    override fun getItemCount(): Int {
        return favorite.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(favorite: Favorite) {
            itemView.nombre.text = favorite.name
        }
    }
}