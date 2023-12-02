package com.kazemieh.www.shop.repository

import com.kazemieh.www.shop.data.model.category.SubCategory
import com.kazemieh.www.shop.data.model.profile.LoginRequest
import com.kazemieh.www.shop.data.model.profile.LoginResponse
import com.kazemieh.www.shop.data.remote.BaseApiResponse
import com.kazemieh.www.shop.data.remote.CategoryApi
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.data.remote.ProfileApi
import javax.inject.Inject


class ProfileRepository @Inject constructor(private val api: ProfileApi) : BaseApiResponse() {


    suspend fun login(loginRequest: LoginRequest): NetworkResult<LoginResponse> =
        safeApiCall {
            api.login(loginRequest)
        }



}