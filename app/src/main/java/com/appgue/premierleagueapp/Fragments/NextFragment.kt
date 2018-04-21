package com.appgue.premierleagueapp.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appgue.premierleagueapp.Adapters.NextFragmentAdapter
import com.appgue.premierleagueapp.Event

import com.appgue.premierleagueapp.R
import com.appgue.premierleagueapp.Utils.InitRetrofit
import kotlinx.android.synthetic.main.fragment_next.*
import retrofit2.Call
import retrofit2.Callback


/**
 * A simple [Fragment] subclass.
 */
class NextFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_next, container, false)

        var swipe = view.findViewById<View>(R.id.refresh_next) as SwipeRefreshLayout
        swipe.setOnRefreshListener {
            swipe.isRefreshing = false
            getNext()
        }

        getNext()
        return view
    }

    private fun getNext() {
        var api = InitRetrofit().getInitInstance()
        var call = api.request_nextMatch()
        call.enqueue(object : Callback<Event> {

            override fun onFailure(call: Call<Event>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<Event>?, response: retrofit2.Response<Event>?) {
                if (response != null) {
                    if (response.isSuccessful) {
                        var data = response.body()?.data
                        val adapter = NextFragmentAdapter(activity, data)
                        recycler_next.adapter = adapter
                        recycler_next.layoutManager = GridLayoutManager(activity,1)
                    }
                }
            }

        })
    }

}// Required empty public constructor
