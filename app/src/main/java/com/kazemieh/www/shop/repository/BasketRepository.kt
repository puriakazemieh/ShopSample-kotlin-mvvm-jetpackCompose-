package com.kazemieh.www.shop.repository

import com.kazemieh.www.shop.data.model.ResponseResult
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

    suspend fun getSuggestedItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getSuggestedItems()
        }

    suspend fun insertCartItem(car: CartItem) = dao.insertCartItem(car)


}