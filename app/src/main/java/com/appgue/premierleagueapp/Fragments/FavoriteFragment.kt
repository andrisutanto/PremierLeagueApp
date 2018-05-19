package com.appgue.premierleagueapp.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.appgue.premierleagueapp.DB.DBAdapter
import com.appgue.premierleagueapp.DB.DataSource
import com.appgue.premierleagueapp.DB.Favorite
import com.appgue.premierleagueapp.Model.Team


import com.appgue.premierleagueapp.R
import org.jetbrains.anko.db.*
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.jetbrains.anko.support.v4.onRefresh


/**
 * A simple [Fragment] subclass.
 */
class FavoriteFragment : Fragment() {
    lateinit var favorite: List<Favorite>
    lateinit var dataSource: DataSource
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_favorite, container, false)
        val swipe = view.findViewById<View>(R.id.refresh_favorite) as SwipeRefreshLayout

        recyclerView = view.findViewById(R.id.recycler_favorite) as RecyclerView
        dataSource = DataSource(requireContext())
        createData()
        favorite = dataSource.getFavorite()
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        recyclerView.adapter = DBAdapter(activity, favorite)

        swipe.setOnRefreshListener {
            swipe.isRefreshing = false
            createData()
            favorite = dataSource.getFavorite()
            recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
            recyclerView.adapter = DBAdapter(activity, favorite)
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        createData()
        favorite = dataSource.getFavorite()
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        recyclerView.adapter = DBAdapter(activity, favorite)

    }

    private fun createData() {
        dataSource.getFavorite()
    }

}
