package com.kazemieh.www.shop.data.remote

import com.kazemieh.www.shop.data.model.ResponseResult
import com.kazemieh.www.shop.data.model.home.StoreProduct
import com.kazemieh.www.shop.data.model.profile.LoginRequest
import com.kazemieh.www.shop.data.model.profile.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ProfileApi {


    @POST("/api/v1/login")
    suspend fun login(
        @Body login : LoginRequest
    ) : Response<ResponseResult<LoginResponse>>

}