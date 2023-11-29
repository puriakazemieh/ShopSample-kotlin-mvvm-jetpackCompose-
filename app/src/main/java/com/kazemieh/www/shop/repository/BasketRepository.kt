package com.kazemieh.www.shop.repository

import com.kazemieh.www.shop.data.model.basket.CartItem
import com.kazemieh.www.shop.data.model.basket.CartStatus
import com.kazemieh.www.shop.data.model.home.StoreProduct
import com.kazemieh.www.shop.data.remote.BaseApiResponse
import com.kazemieh.www.shop.data.remote.BasketApi
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.db.CartDao
import javax.inject.Inject


class BasketRepository @Inject constructor(
    private val api: BasketApi,
    private val dao: CartDao
) : BaseApiResponse() {

    val currentCartItems = dao.getAllItems(CartStatus.CURRENT_CART)
    val nextCartItems = dao.getAllItems(CartStatus.NEXT_CART)

    suspend fun getSuggestedItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getSuggestedItems()
        }

    suspend fun insertCartItem(item: CartItem) = dao.insertCartItem(item)

    suspend fun removeFromCart(item: CartItem) = dao.removeFromCart(item)

    suspend fun changeCountCartItem(id: String, newCount: Int) =
        dao.changeCountCartItem(id, newCount)

    suspend fun changeStatusCartItem(id: String, newCartStatus: CartStatus) =
        dao.changeStatusCartItem(id, newCartStatus)

    val currentCartItemCount = dao.getCartItemCount(CartStatus.CURRENT_CART)
    val nextCartItemCount = dao.getCartItemCount(CartStatus.NEXT_CART)


}