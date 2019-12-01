package com.hexinary.restaurantmenujournal.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ItemSQLiteHelper(context: Context): SQLiteOpenHelper(context, "menu_item", null, 1){
    val DATABASE_NAME = "menu_item_database"
    val TABLE_NAME = "menu_item"
    val ITEM_ID = "item_id"
    val ITEM_NAME = "item_name"
    val RESTAURANT_NAME = "restaurant_name"
    val GOOD_COMMENTS = "good_comments"
    val BAD_COMMENTS = "bad_comments"
    val RATING = "rating"
    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE $TABLE_NAME (" +
                "$ITEM_ID INTEGER PRIMARY KEY," +
                "$ITEM_NAME TEXT," +
                "$RESTAURANT_NAME TEXT," +
                "$GOOD_COMMENTS TEXT," +
                "$BAD_COMMENTS TEXT," +
                "$RATING REAL)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}