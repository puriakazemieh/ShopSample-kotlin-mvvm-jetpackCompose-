package com.kazemieh.www.shop.repository

import com.kazemieh.www.shop.data.remote.BaseApiResponse
import com.kazemieh.www.shop.data.remote.HomeApiInterface
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api: HomeApiInterface) :BaseApiResponse(){


}