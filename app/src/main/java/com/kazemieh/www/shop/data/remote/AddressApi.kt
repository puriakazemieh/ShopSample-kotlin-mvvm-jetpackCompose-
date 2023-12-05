package com.kazemieh.www.shop.data.remote

import com.kazemieh.www.shop.data.model.ResponseResult
import com.kazemieh.www.shop.data.model.address.UserAddress
import com.kazemieh.www.shop.data.model.profile.LoginRequest
import com.kazemieh.www.shop.data.model.profile.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AddressApi {


    @GET("/api/v1/getUserAddress")
    suspend fun getUserAddressList(
        @Query("token") token: String
    ) : Response<ResponseResult<List<UserAddress>>>

}