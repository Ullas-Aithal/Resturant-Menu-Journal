package com.hexinary.restaurantmenujournal.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.hexinary.restaurantmenujournal.R
import com.hexinary.restaurantmenujournal.model.Item
import com.hexinary.restaurantmenujournal.model.ItemDatabaseManager
import com.hexinary.restaurantmenujournal.model.ItemSQLiteHelper

class AddItem : AppCompatActivity() {

    var currentItem:Item? = null

    companion object{
        fun createLaunchIntent(context: Context, item: Item): Intent {
            val intent = Intent(context,AddItem::class.java)
            intent.apply {
                putExtra(ItemSQLiteHelper.ITEM_ID,item.itemId)
                putExtra(ItemSQLiteHelper.ITEM_NAME,item.itemName)
                putExtra(ItemSQLiteHelper.RESTAURANT_NAME,item.restaurantName)
                putExtra(ItemSQLiteHelper.GOOD_COMMENTS, item.goodComments)
                putExtra(ItemSQLiteHelper.BAD_COMMENTS,item.badComments)
                putExtra(ItemSQLiteHelper.RATING,item.rating)
            }
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Add Item"
        setContentView(R.layout.add_item)
        if(intent != null && intent.hasExtra(ItemSQLiteHelper.ITEM_ID))  {

                currentItem = Item(
                intent.getLongExtra(ItemSQLiteHelper.ITEM_ID,-1),
                intent.getStringExtra(ItemSQLiteHelper.ITEM_NAME)!!,
                intent.getStringExtra(ItemSQLiteHelper.RESTAURANT_NAME),
                intent.getStringExtra(ItemSQLiteHelper.GOOD_COMMENTS),
                intent.getStringExtra(ItemSQLiteHelper.BAD_COMMENTS),
                intent.getFloatExtra(ItemSQLiteHelper.RATING,0F))

                currentItem!!.apply {
                    findViewById<TextView>(R.id.editText_itemName).text = itemName
                    findViewById<TextView>(R.id.editText_restaurantName).text = restaurantName
                    findViewById<TextView>(R.id.editText_goodThings).text = goodComments
                    findViewById<TextView>(R.id.editText_badThings).text = badComments
                    findViewById<RatingBar>(R.id.ratingBar_rating).rating = rating
                }


        }

        (findViewById<Button>(R.id.button_saveItem)).setOnClickListener {
            val databaseManager = ItemDatabaseManager(this)
            databaseManager.addItem(Item(
                if(currentItem != null) currentItem!!.itemId else System.currentTimeMillis(),
                findViewById<EditText>(R.id.editText_itemName).text.toString(),
                findViewById<EditText>(R.id.editText_restaurantName).text.toString(),
                findViewById<EditText>(R.id.editText_goodThings).text.toString(),
                findViewById<EditText>(R.id.editText_badThings).text.toString(),
                findViewById<RatingBar>(R.id.ratingBar_rating).rating
            ))
            finish()
        }
    }

}