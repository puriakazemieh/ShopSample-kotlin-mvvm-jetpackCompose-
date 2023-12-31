package com.kazemieh.www.shop.repository

import com.kazemieh.www.shop.data.model.chekcout.ConfirmPurchase
import com.kazemieh.www.shop.data.model.chekcout.OrderDetail
import com.kazemieh.www.shop.data.remote.BaseApiResponse
import com.kazemieh.www.shop.data.remote.CategoryApi
import com.kazemieh.www.shop.data.remote.CheckoutApi
import com.kazemieh.www.shop.data.remote.NetworkResult
import javax.inject.Inject


class CheckoutRepository @Inject constructor(private val api: CheckoutApi) : BaseApiResponse() {

    suspend fun getShippingCost(address: String): NetworkResult<Int> =
        safeApiCall {
            api.getShippingCost(address)
        }


    suspend fun setNewOrder(cartOrderDetail: OrderDetail): NetworkResult<String> =
        safeApiCall {
            api.setNewOrder(cartOrderDetail)
        }

    suspend fun confirmPurchase(confirmPurchase: ConfirmPurchase): NetworkResult<String> =
        safeApiCall {
            api.confirmPurchase(confirmPurchase)
        }


}