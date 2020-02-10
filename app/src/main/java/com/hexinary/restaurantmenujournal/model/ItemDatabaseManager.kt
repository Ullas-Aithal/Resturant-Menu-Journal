package com.hexinary.restaurantmenujournal.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.core.database.getStringOrNull
import com.hexinary.restaurantmenujournal.model.ItemSQLiteHelper.DB_Constants

class ItemDatabaseManager(val mContext: Context) {
    private fun getReadableDatabase(): SQLiteDatabase{
        return ItemSQLiteHelper(mContext).readableDatabase
    }
    private fun getWriteableDatabase():SQLiteDatabase{
        return ItemSQLiteHelper(mContext).writableDatabase
    }
    fun addItem(item: Item){
        val values = ContentValues().apply{
            put(DB_Constants.ITEM_ID, item.itemId)
            put(DB_Constants.ITEM_NAME, item.itemName)
            put(DB_Constants.RESTAURANT_NAME, item.restaurantName)
            put(DB_Constants.GOOD_COMMENTS, item.goodComments)
            put(DB_Constants.BAD_COMMENTS, item.badComments)
            put(DB_Constants.RATING, item.rating)
        }
        getWriteableDatabase().insert(DB_Constants.TABLE_NAME,null,values)
    }
    fun updateItem(item: Item){
        val values = ContentValues().apply{
            put(DB_Constants.ITEM_ID, item.itemId)
            put(DB_Constants.ITEM_NAME, item.itemName)
            put(DB_Constants.RESTAURANT_NAME, item.restaurantName)
            put(DB_Constants.GOOD_COMMENTS, item.goodComments)
            put(DB_Constants.BAD_COMMENTS, item.badComments)
            put(DB_Constants.RATING, item.rating)
        }
        getWriteableDatabase().update(DB_Constants.TABLE_NAME,values,DB_Constants.ITEM_ID + "=" + item.itemId,null)
    }
    fun getItems():ArrayList<Item>{
        val itemList:ArrayList<Item> = arrayListOf()
        val db = getReadableDatabase()
        val projection = arrayOf(DB_Constants.ITEM_ID,
            DB_Constants.ITEM_NAME,
            DB_Constants.RESTAURANT_NAME,
            DB_Constants.GOOD_COMMENTS,
            DB_Constants.BAD_COMMENTS,
            DB_Constants.RATING)
        val cursor = db.query(DB_Constants.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null,
            null)

        with(cursor){
            while(moveToNext()){
                itemList.add(Item(getLong(getColumnIndexOrThrow(DB_Constants.ITEM_ID)),
                    getString(getColumnIndex(DB_Constants.ITEM_NAME)),
                    getString(getColumnIndex(DB_Constants.RESTAURANT_NAME)),
                    getStringOrNull(getColumnIndex(DB_Constants.GOOD_COMMENTS)),
                    getStringOrNull(getColumnIndex(DB_Constants.BAD_COMMENTS)),
                    getFloat(getColumnIndex(DB_Constants.RATING))))
            }
        }
        return itemList
    }
}