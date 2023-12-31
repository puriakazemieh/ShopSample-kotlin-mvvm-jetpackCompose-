package com.kazemieh.www.shop.repository

import com.kazemieh.www.shop.data.model.home.AmazingItem
import com.kazemieh.www.shop.data.model.home.MainCategory
import com.kazemieh.www.shop.data.model.home.Slider
import com.kazemieh.www.shop.data.model.home.StoreProduct
import com.kazemieh.www.shop.data.remote.BaseApiResponse
import com.kazemieh.www.shop.data.remote.HomeApi
import com.kazemieh.www.shop.data.remote.NetworkResult
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api: HomeApi) : BaseApiResponse() {

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


    suspend fun getProposalBanners(): NetworkResult<List<Slider>> =
        safeApiCall {
            api.getProposalBanners()
        }


    suspend fun getCategories(): NetworkResult<List<MainCategory>> =
        safeApiCall {
            api.getCategories()
        }


    suspend fun getCenterBanners(): NetworkResult<List<Slider>> =
        safeApiCall {
            api.getCenterBanners()
        }


    suspend fun getBestSellerItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getBestSellerItems()
        }

    suspend fun getMostVisitedItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getMostVisitedItems()
        }


    suspend fun getMostFavoriteItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getMostFavoriteItems()
        }


    suspend fun getMostDiscountedItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getMostDiscountedItems()
        }


}