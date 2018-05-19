package com.appgue.premierleagueapp.DB

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Created by Andri on 4/29/2018.
 */

class DatabaseHelper(ctx: Context) :
        ManagedSQLiteOpenHelper(ctx, "Favorite", null, 1) {

    companion object {
        private var instance: DatabaseHelper? = null
        fun Instance(context: Context): DatabaseHelper{
            if (instance==null){
                instance = DatabaseHelper(context.applicationContext)
            }
            return instance as DatabaseHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable("favorite", true,
                "id" to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                "idEvent" to TEXT,
                "teamHome" to TEXT,
                "teamAway" to TEXT,
                "tanggalFav" to TEXT,
                "ScoreHome" to TEXT,
                "ScoreAway" to TEXT,
                "idHomeTeam" to TEXT,
                "idAwayTeam" to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}

val Context.database: DatabaseHelper
get() = DatabaseHelper.Instance(applicationContext)