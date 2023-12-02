package com.kazemieh.www.shop.repository

import com.kazemieh.www.shop.data.model.category.SubCategory
import com.kazemieh.www.shop.data.remote.BaseApiResponse
import com.kazemieh.www.shop.data.remote.CategoryApi
import com.kazemieh.www.shop.data.remote.NetworkResult
import javax.inject.Inject


class ProfileRepository @Inject constructor(private val api: CategoryApi) : BaseApiResponse() {

    suspend fun getSubCategories(): NetworkResult<SubCategory> =
        safeApiCall {
            api.getSubCategories()
        }

}