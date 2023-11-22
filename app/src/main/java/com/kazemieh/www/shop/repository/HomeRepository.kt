package com.kazemieh.www.shop.repository

import com.kazemieh.www.shop.data.model.home.AmazingItem
import com.kazemieh.www.shop.data.model.home.Slider
import com.kazemieh.www.shop.data.remote.BaseApiResponse
import com.kazemieh.www.shop.data.remote.HomeApiInterface
import com.kazemieh.www.shop.data.remote.NetworkResult
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api: HomeApiInterface) : BaseApiResponse() {

    suspend fun getSlider(): NetworkResult<List<Slider>> =
        safeApiCall {
            api.getSlider()
        }


    suspend fun getAmazingItem(): NetworkResult<List<AmazingItem>> =
        safeApiCall {
            api.getAmazingItem()
        }

    suspend fun getAmazingSuperMarketItems(): NetworkResult<List<AmazingItem>> =
        safeApiCall {
            api.getAmazingSuperMarketItems()
        }


}