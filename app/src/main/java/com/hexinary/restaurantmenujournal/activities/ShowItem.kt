package com.hexinary.restaurantmenujournal.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.hexinary.restaurantmenujournal.R
import com.hexinary.restaurantmenujournal.model.Item
import com.hexinary.restaurantmenujournal.model.ItemSQLiteHelper.DB_Constants

class ShowItem: AppCompatActivity() {
    var item: Item? = null
    companion object{
        fun createLaunchIntent(context:Context, item: Item): Intent{
               val intent = Intent(context,ShowItem::class.java)
            intent.apply {
                putExtra(DB_Constants.ITEM_ID,item.itemId)
                putExtra(DB_Constants.ITEM_NAME,item.itemName)
                putExtra(DB_Constants.RESTAURANT_NAME,item.restaurantName)
                putExtra(DB_Constants.GOOD_COMMENTS, item.goodComments)
                putExtra(DB_Constants.BAD_COMMENTS,item.badComments)
                putExtra(DB_Constants.RATING,item.rating)
            }
            return intent
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_item)
        if(intent != null){
            item = Item(
                intent.getLongExtra(DB_Constants.ITEM_ID,-1),
                intent.getStringExtra(DB_Constants.ITEM_NAME)!!,
                intent.getStringExtra(DB_Constants.RESTAURANT_NAME),
                intent.getStringExtra(DB_Constants.GOOD_COMMENTS),
                intent.getStringExtra(DB_Constants.BAD_COMMENTS),
                intent.getFloatExtra(DB_Constants.RATING,0F)
            )
        }
        if(item != null) {
            item!!.apply {
                findViewById<TextView>(R.id.textView_itemName).text = itemName
                findViewById<TextView>(R.id.textView_restaurantName).text = restaurantName
                findViewById<TextView>(R.id.textView_goodThings).text = goodComments
                findViewById<TextView>(R.id.textView_badThings).text = badComments
                findViewById<RatingBar>(R.id.ratingBar_rating).rating = rating
            }
        }

    }

}