package com.kazemieh.www.shop.repository

import com.kazemieh.www.shop.data.model.address.UserAddress
import com.kazemieh.www.shop.data.remote.AddressApi
import com.kazemieh.www.shop.data.remote.BaseApiResponse
import com.kazemieh.www.shop.data.remote.CategoryApi
import com.kazemieh.www.shop.data.remote.NetworkResult
import javax.inject.Inject


class AddressRepository @Inject constructor(private val api: AddressApi) : BaseApiResponse() {


    suspend fun getUserAddressList(token: String): NetworkResult<List<UserAddress>> =
        safeApiCall {
            api.getUserAddressList(token)
        }




}