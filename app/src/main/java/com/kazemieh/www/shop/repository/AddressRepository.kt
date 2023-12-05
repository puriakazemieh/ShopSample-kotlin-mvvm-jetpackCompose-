package com.kazemieh.www.shop.repository

import com.kazemieh.www.shop.data.remote.AddressApi
import com.kazemieh.www.shop.data.remote.BaseApiResponse
import com.kazemieh.www.shop.data.remote.CategoryApi
import javax.inject.Inject


class AddressRepository @Inject constructor(private val api: AddressApi) : BaseApiResponse() {


//    suspend fun login(loginRequest: LoginRequest): NetworkResult<LoginResponse> =
//        safeApiCall {
//            api.login(loginRequest)
//        }



}