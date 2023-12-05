package com.kazemieh.www.shop.repository

import com.kazemieh.www.shop.data.remote.BaseApiResponse
import com.kazemieh.www.shop.data.remote.CategoryApi
import javax.inject.Inject


class CheckoutRepository @Inject constructor(private val api: CategoryApi) : BaseApiResponse() {


//    suspend fun login(loginRequest: LoginRequest): NetworkResult<LoginResponse> =
//        safeApiCall {
//            api.login(loginRequest)
//        }



}