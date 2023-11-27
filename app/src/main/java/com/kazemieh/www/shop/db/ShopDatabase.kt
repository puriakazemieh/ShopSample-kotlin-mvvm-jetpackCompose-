package com.kazemieh.www.shop.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kazemieh.www.shop.data.model.basket.CartItem

@Database(entities = [CartItem::class], version = 1, exportSchema = false)
abstract class ShopDatabase : RoomDatabase() {

    abstract fun cartDao(): CartDao
}