package com.hexinary.restaurantmenujournal.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import com.hexinary.restaurantmenujournal.R
import com.hexinary.restaurantmenujournal.model.Item
import com.hexinary.restaurantmenujournal.model.ItemDatabaseManager

class AddItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Add Item"
        setContentView(R.layout.add_item)
        (findViewById<Button>(R.id.button_saveItem)).setOnClickListener {
            val databaseManager = ItemDatabaseManager(this)
            databaseManager.addItem(Item(
                System.currentTimeMillis(),
                findViewById<EditText>(R.id.editText_itemName).text.toString(),
                findViewById<EditText>(R.id.editText_restaurantName).text.toString(),
                findViewById<EditText>(R.id.editText_goodThings).text.toString(),
                findViewById<EditText>(R.id.editText_badThings).text.toString(),
                findViewById<RatingBar>(R.id.ratingBar_rating).rating
            ))
        }
    }

}