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
                "id" to INTEGER + PRIMARY_KEY,
                "name" to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}

// Access property for Context
val Context.database: DatabaseHelper
get() = DatabaseHelper.Instance(applicationContext)