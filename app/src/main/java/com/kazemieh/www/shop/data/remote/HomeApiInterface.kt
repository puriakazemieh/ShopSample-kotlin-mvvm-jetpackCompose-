package com.kazemieh.www.shop.data.remote

import com.kazemieh.www.shop.data.model.ResponseResult
import com.kazemieh.www.shop.data.model.home.AmazingItem
import com.kazemieh.www.shop.data.model.home.MainCategory
import com.kazemieh.www.shop.data.model.home.Slider
import com.kazemieh.www.shop.data.model.home.StoreProduct
import retrofit2.Response
import retrofit2.http.GET

interface HomeApiInterface {

    @GET("/api/v1/getSlider")
    suspend fun getSlider(): Response<ResponseResult<List<Slider>>>

    @GET("/api/v1/getAmazingProducts")
    suspend fun getAmazingItem(): Response<ResponseResult<List<AmazingItem>>>


    @GET("/api/v1/getSuperMarketAmazingProducts")
    suspend fun getAmazingSuperMarketItems() : Response<ResponseResult<List<AmazingItem>>>


    @GET("/api/v1/get4Banners")
    suspend fun getProposalBanners() : Response<ResponseResult<List<Slider>>>


    @GET("/api/v1/getCategories")
    suspend fun getCategories() : Response<ResponseResult<List<MainCategory>>>


    @GET("/api/v1/getCenterBanners")
    suspend fun getCenterBanners() : Response<ResponseResult<List<Slider>>>


    @GET("/api/v1/getBestsellerProducts")
    suspend fun getBestSellerItems() : Response<ResponseResult<List<StoreProduct>>>

    @GET("/api/v1/getMostVisitedProducts")
    suspend fun getMostVisitedItems() : Response<ResponseResult<List<StoreProduct>>>


    @GET("/api/v1/getMostFavoriteProducts")
    suspend fun getMostFavoriteItems() : Response<ResponseResult<List<StoreProduct>>>

}