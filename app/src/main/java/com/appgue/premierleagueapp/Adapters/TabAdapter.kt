package com.appgue.premierleagueapp.Adapters

import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import com.appgue.premierleagueapp.Fragments.FavoriteFragment
import com.appgue.premierleagueapp.Fragments.NextFragment
import com.appgue.premierleagueapp.Fragments.PrevFragment

/**
 * Created by Andri on 4/21/2018.
 */
class TabAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> PrevFragment()
            1 -> NextFragment()
            else -> FavoriteFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }
}