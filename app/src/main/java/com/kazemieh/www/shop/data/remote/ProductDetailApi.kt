package com.kazemieh.www.shop.data.remote

import com.kazemieh.www.shop.data.model.ResponseResult
import com.kazemieh.www.shop.data.model.home.StoreProduct
import com.kazemieh.www.shop.data.model.productdetail.ProductDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductDetailApi {
    @GET("/api/v1/getProductById")
    suspend fun getProductById(
        @Query("id") productId: String
    ) : Response<ResponseResult<ProductDetail>>
    @GET("/api/v1/getSimilarProducts")
    suspend fun getSimilarProducts(
        @Query("categoryId") categoryId: String
    ): Response<ResponseResult<List<StoreProduct>>>

}