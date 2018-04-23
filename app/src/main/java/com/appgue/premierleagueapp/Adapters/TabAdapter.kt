package com.appgue.premierleagueapp.Adapters

import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import com.appgue.premierleagueapp.Fragments.NextFragment
import com.appgue.premierleagueapp.Fragments.PrevFragment

/**
 * Created by Andri on 4/21/2018.
 */
class TabAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
    // mengatur letak tabLayout sesuai posisi dan fragment yang akan ditampilkan
    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            PrevFragment()
        } else {
            NextFragment()
        }
    }
    // mengambil total dari fragment atau tampilan
    override fun getCount(): Int {
        return 2
    }
}