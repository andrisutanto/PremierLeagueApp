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
import com.appgue.premierleagueapp.Model.Event
import com.appgue.premierleagueapp.R

/**
 * Created by Andri on 4/21/2018.
 */
class PrevFragmentAdapter (c: FragmentActivity?, data: List<Event.EventsData>?) : RecyclerView.Adapter<PrevFragmentAdapter.ViewHolder>() {
    //init data untuk recyclerview
    private var prevEvent: List<Event.EventsData>? = data
    private var Context: Context? = c

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val prevData: Event.EventsData? = prevEvent?.get(position)
        holder.tvTanggalPertandinganPrev.text = prevData?.strDate
        holder.tvScoreHomePrev.text = prevData?.intHomeScore.toString()
        holder.tvScoreAwayPrev.text = prevData?.intAwayScore.toString()
        holder.tvTeamHomePrev.text = prevData?.strHomeTeam
        holder.tvTeamAwayPrev.text = prevData?.strAwayTeam
        //set on click dan kirim idEvent
        holder.LLPrev.setOnClickListener({ v ->
            val intent = Intent(Context?.applicationContext, DetailActivity::class.java)
            intent.putExtra("idEvent", prevData?.idEvent.toString())
            intent.putExtra("idHomeTeam", prevData?.idHomeTeam)
            intent.putExtra("idAwayTeam", prevData?.idAwayTeam)
            Context?.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return prevEvent!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        var inflater = LayoutInflater.from(Context).inflate(R.layout.item_prev_layout, parent, false)
        return ViewHolder(inflater)
    }

    // inner class VewHolder berfungsi untuk menangkap dan menginisialisasi semua widget yang diinflate dari method onCreateViewHolder
    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var tvTanggalPertandinganPrev = itemView?.findViewById<View>(R.id.tvTanggalPertandinganPrev) as TextView
        var tvScoreHomePrev = itemView?.findViewById<View>(R.id.tvScoreHomePrev) as TextView
        var tvScoreAwayPrev = itemView?.findViewById<View>(R.id.tvScoreAwayPrev) as TextView
        var tvTeamHomePrev = itemView?.findViewById<View>(R.id.tvTeamHomePrev) as TextView
        var tvTeamAwayPrev = itemView?.findViewById<View>(R.id.tvTeamAwayPrev) as TextView
        var LLPrev = itemView?.findViewById<View>(R.id.LLPrev) as LinearLayout
    }

}