package com.hexinary.restaurantmenujournal.model

class Item (val itemId: Long,
            val itemName: String,
            val restaurantName: String?,
            val goodComments: String?,
            val badComments: String?,
            val rating: Float)