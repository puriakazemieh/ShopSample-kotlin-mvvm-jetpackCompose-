package com.kazemieh.www.shop.repository

import com.kazemieh.www.shop.data.model.ResponseResult
import com.kazemieh.www.shop.data.remote.BaseApiResponse
import com.kazemieh.www.shop.data.remote.BasketApi
import javax.inject.Inject


class BasketRepository @Inject constructor(private val api: BasketApi): BaseApiResponse() {

}