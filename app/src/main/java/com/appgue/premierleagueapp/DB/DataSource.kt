package com.appgue.premierleagueapp.DB

import android.content.Context
import kotlinx.coroutines.experimental.selects.select
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.parseList
import org.jetbrains.anko.db.select

/**
 * Created by Andri on 5/7/2018.
 */
class DataSource(context: Context) {
    val dbhelper = DatabaseHelper(context)

    fun getFavorite():List<Favorite> {
        return dbhelper.use {
            select("favorite").exec {
                parseList<Favorite>(classParser())
            }
        }
    }
}