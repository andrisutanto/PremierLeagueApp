package com.appgue.premierleagueapp.Adapters

import android.content.Context
import android.content.Intent
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.appgue.premierleagueapp.DetailActivity
import com.appgue.premierleagueapp.Event
import com.appgue.premierleagueapp.R

/**
 * Created by Andri on 4/21/2018.
 */
class NextFragmentAdapter : RecyclerView.Adapter<NextFragmentAdapter.ViewHolder>{
    //init data untuk recyclerview
    var nextEvent: List<Event.EventsData>? = null
    var Context: Context? = null

    //cons utk menangkap dan mencocokan data dari data yang diambil
    constructor(c: FragmentActivity?, data: List<Event.EventsData>?) {
        this.Context = c
        this.nextEvent = data
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nextData: Event.EventsData = nextEvent!!.get(position)
        holder.tvTanggalPertandinganNext.text = nextData.strDate
        holder.tvTeamHomeNext.text = nextData.strHomeTeam
        holder.tvTeamAwayNext.text = nextData.strAwayTeam
        //set on click dan kirim idEvent
        holder.LLNext.setOnClickListener({ v ->
            val intent = Intent(Context?.applicationContext, DetailActivity::class.java)
            intent.putExtra("idEvent", nextData.idEvent.toString())
            intent.putExtra("strDate", nextData.strDate)
            intent.putExtra("strHomeTeam", nextData.strHomeTeam)
            intent.putExtra("strAwayTeam", nextData.strAwayTeam)
            Context!!.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return nextEvent!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        var inflater = LayoutInflater.from(Context).inflate(R.layout.item_next_layout, parent, false)
        return ViewHolder(inflater)
    }

    // inner class VewHolder berfungsi untuk menangkap dan menginisialisasi semua widget yang diinflate dari method onCreateViewHolder
    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var tvTanggalPertandinganNext = itemView?.findViewById<View>(R.id.tvTanggalPertandinganNext) as TextView
        var tvTeamHomeNext = itemView?.findViewById<View>(R.id.tvTeamHomeNext) as TextView
        var tvTeamAwayNext = itemView?.findViewById<View>(R.id.tvTeamAwayNext) as TextView
        var LLNext = itemView?.findViewById<View>(R.id.LLNext) as LinearLayout
    }

}