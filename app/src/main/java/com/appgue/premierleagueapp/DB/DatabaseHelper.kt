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
                "HomeGoals" to TEXT + NOT_NULL,
                "AwayGoals" to TEXT + NOT_NULL,
                "HomeFormation" to TEXT + NOT_NULL,
                "AwayFormation" to TEXT + NOT_NULL,
                "HomeShots" to TEXT + NOT_NULL,
                "AwayShots" to TEXT + NOT_NULL,
                "HomeGoalkeeper" to TEXT + NOT_NULL,
                "AwayGoalkeeper" to TEXT + NOT_NULL,
                "HomeDefense" to TEXT + NOT_NULL,
                "AwayDefense" to TEXT + NOT_NULL,
                "HomeMidfield" to TEXT + NOT_NULL,
                "AwayMidfield" to TEXT + NOT_NULL,
                "HomeForward" to TEXT + NOT_NULL,
                "AwayForward" to TEXT + NOT_NULL,
                "ScoreHome" to TEXT + NOT_NULL,
                "ScoreAway" to TEXT + NOT_NULL)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}

// Access property for Context
val Context.database: DatabaseHelper
get() = DatabaseHelper.Instance(applicationContext)