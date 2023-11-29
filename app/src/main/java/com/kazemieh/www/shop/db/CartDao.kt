package com.kazemieh.www.shop.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kazemieh.www.shop.data.model.basket.CartItem
import com.kazemieh.www.shop.data.model.basket.CartStatus
import kotlinx.coroutines.flow.Flow
import retrofit2.http.DELETE

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCartItem(item: CartItem)

    @Query("select * from shopping_cart where cartStatus=:status")
    fun getAllItems(status: CartStatus): Flow<List<CartItem>>

    @Delete
    suspend fun removeFromCart(item: CartItem)

    @Query(" update shopping_cart set count=:newCount where itemId=:id")
    suspend fun changeCountCartItem(id: String, newCount: Int)

    @Query(" update shopping_cart set cartStatus=:newCartStatus where itemId=:id")
    suspend fun changeStatusCartItem(id: String, newCartStatus: CartStatus)

    @Query("select total(count) as count from shopping_cart where cartStatus=:status ")
    fun getCartItemCount(status: CartStatus) :Flow<Int>


}