package com.kazemieh.www.shop.data.remote

import com.kazemieh.www.shop.data.model.ResponseResult
import com.kazemieh.www.shop.data.model.home.StoreProduct
import retrofit2.Response
import retrofit2.http.GET

interface BasketApi {


    @GET("/api/v1/getAllProducts")
    suspend fun getSuggestedItems(): Response<ResponseResult<List<StoreProduct>>>

}