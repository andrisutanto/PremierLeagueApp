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
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable("favorite", true,
                "id" to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                "teamHome" to TEXT,
                "teamAway" to TEXT,
                "tanggalFav" to TEXT,
                "teamAwayBadge" to TEXT,
                "teamHomeBadge" to TEXT,
                "HomeGoals" to TEXT,
                "AwayGoals" to TEXT,
                "HomeFormation" to TEXT,
                "AwayFormation" to TEXT,
                "HomeShots" to TEXT,
                "AwayShots" to TEXT,
                "HomeGoalkeeper" to TEXT,
                "AwayGoalkeeper" to TEXT,
                "HomeDefense" to TEXT,
                "AwayDefense" to TEXT,
                "HomeMidfield" to TEXT,
                "AwayMidfield" to TEXT,
                "HomeForward" to TEXT,
                "AwayForward" to TEXT,
                "ScoreHome" to TEXT,
                "ScoreAway" to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}

// Access property for Context
val Context.database: DatabaseHelper
get() = DatabaseHelper.Instance(applicationContext)