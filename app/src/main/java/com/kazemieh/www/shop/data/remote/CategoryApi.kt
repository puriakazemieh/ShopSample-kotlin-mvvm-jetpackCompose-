package com.kazemieh.www.shop.data.remote

import com.kazemieh.www.shop.data.model.ResponseResult
import com.kazemieh.www.shop.data.model.category.SubCategory
import retrofit2.Response
import retrofit2.http.GET

interface CategoryApi {

    @GET("/api/v1/getSubCategories")
    suspend fun getSubCategories() : Response<ResponseResult<SubCategory>>

}