package com.kazemieh.www.shop.repository

import com.kazemieh.www.shop.data.model.ResponseResult
import com.kazemieh.www.shop.data.model.home.StoreProduct
import com.kazemieh.www.shop.data.remote.BaseApiResponse
import com.kazemieh.www.shop.data.remote.BasketApi
import com.kazemieh.www.shop.data.remote.NetworkResult
import javax.inject.Inject


class BasketRepository @Inject constructor(private val api: BasketApi): BaseApiResponse() {

    suspend fun getSuggestedItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getSuggestedItems()
        }
}