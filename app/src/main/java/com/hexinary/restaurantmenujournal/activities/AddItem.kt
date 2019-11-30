package com.hexinary.restaurantmenujournal.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hexinary.restaurantmenujournal.R

class AddItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Add Item"
        setContentView(R.layout.add_item)
    }

}