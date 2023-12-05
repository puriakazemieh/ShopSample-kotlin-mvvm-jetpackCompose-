package com.kazemieh.www.shop.data.remote

import com.kazemieh.www.shop.data.model.ResponseResult
import com.kazemieh.www.shop.data.model.profile.LoginRequest
import com.kazemieh.www.shop.data.model.profile.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CheckoutApi {

    @GET("/api/v1/getShippingCost")
    suspend fun getShippingCost(
        @Query("address") address: String
    ) : Response<ResponseResult<Int>>

}