package com.kazemieh.www.shop.repository

import com.kazemieh.www.shop.data.model.home.StoreProduct
import com.kazemieh.www.shop.data.model.productdetail.NewComment
import com.kazemieh.www.shop.data.model.productdetail.ProductDetail
import com.kazemieh.www.shop.data.remote.BaseApiResponse
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.data.remote.ProductDetailApi
import javax.inject.Inject


class ProductDetailRepository @Inject constructor(private val api: ProductDetailApi) :
    BaseApiResponse() {

    suspend fun getProductById(productId: String): NetworkResult<ProductDetail> =
        safeApiCall {
            api.getProductById(productId)
        }

    suspend fun getSimilarProducts(categoryId: String): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getSimilarProducts(categoryId)
        }


    suspend fun setNewComment(newComment: NewComment): NetworkResult<String> =
        safeApiCall {
            api.setNewComment(newComment)
        }

}